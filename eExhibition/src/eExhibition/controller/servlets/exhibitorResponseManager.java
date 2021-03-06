package eExhibition.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Event;
import eExhibition.data.classes.ExhibitorEvent;
import eExhibition.data.classes.Product;
import eExhibition.data.classes.User;
import eExhibition.model.classes.adminManager;
import eExhibition.model.classes.eventManager;
import eExhibition.model.classes.exhibitorManager;
import eExhibition.model.classes.loginManager;
import eExhibition.model.classes.organiserManager;

/**
 * Servlet implementation class exhibitorResponseManager
 */
@WebServlet("/exhibitorResponseManager")
public class exhibitorResponseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exhibitorResponseManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();		
		RequestDispatcher rd = 
		request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);	    		
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userName")==""||session.getAttribute("userName")==null)
		{
			session.invalidate();
			
			RequestDispatcher rd = 
			request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);	    		
			return;
		}
		
		RequestDispatcher rd = null ;
		String action = request.getParameter("action");
		adminManager am=adminManager.getInstance();
		loginManager lm=loginManager.getInstance();
		organiserManager om=organiserManager.getInstance();
		exhibitorManager em=exhibitorManager.getInstance();
		eventManager evm=eventManager.getInstance();
		Map<String,Event> eventsName=em.getAllExhibitorEvents(session.getAttribute("userName").toString());
		
		Set<String> eventnams = eventsName.keySet();
		String[] eventnames=eventnams.toArray(new String[eventnams.size()]);;
		
		if(action.equals("My Details"))
		{
			String uname=(String) session.getAttribute("userName");
			User exhibitor=em.getExhibitor(uname);
			request.setAttribute("password",am.getPasswordOfUserName(uname)); 
			 request.setAttribute("uname", uname); 
			request.setAttribute("exhibitor", exhibitor);
			 request.setAttribute("CALLER", "Display Exhibitor");
			 request.setAttribute("Role", "Exhibitor");
			 rd = request.getRequestDispatcher("/displayExhibitor.jsp");
		}
		else if(action.equals("Join Event"))
		{
			String exhibitoruname=(String) session.getAttribute("userName");
			Map<String, Event> events=em.getAllOtherEvents(exhibitoruname);
			
			request.setAttribute("events", events);
			
					
			rd = request.getRequestDispatcher("/selectEventForParticipation.jsp");
		}
		else if(action.equals("View Exhibitors")){
			Map<String,User> userList = new HashMap<String,User>();
			ArrayList<User> alist=am.getAllUsers("exbt");//All organisers
		
			for(User u:alist)
			{
				userList.put(u.getUserId(),u);
			}
			
			request.setAttribute("userList", userList);
			request.setAttribute("whoToSearch","Exhibitor");
			rd = request.getRequestDispatcher("/viewOrganisers.jsp");
		}
		else if(action.equals("Search")){
			Map<String,User> userList = new HashMap<String,User>();
			String uname = request.getParameter("unameSearchTBox");
			ArrayList<User> alist=am.getAllUsersById("exbt",uname);
		
			for(User u:alist)
			{
				userList.put(u.getUserId(),u);
			}
			
			request.setAttribute("userList", userList);
			request.setAttribute("whoToSearch","Exhibitor");
			rd = request.getRequestDispatcher("/viewOrganisers.jsp");
		}
		else if(action.equals("Participate"))
		{
			
			 String eventId=request.getParameter("events");			
			 Event event=om.getEventById(eventId);			 
			 request.setAttribute("event",event);
			/* Map<String, User>  exhibitors=om.getAllExhibitors();
			 request.setAttribute("exhibitors",exhibitors);*/
			 rd = request.getRequestDispatcher("/joinEvent.jsp");
		}
		if(action.equals("Confirm"))
		{
			String uname=(String) session.getAttribute("userName");
			
			String eventid=request.getParameter("eventid");
			
			String whyJoin=request.getParameter("description").trim();
			
			
			
			if(whyJoin=="")
			{
				request.setAttribute("errorMessage", "User can not be added because you are missing required fields...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			
			else{			
												
					em.registerToParticipate(uname,eventid,whyJoin);
															
						}
					request.setAttribute("joinEventMessage", "Request sent to Organiser for Confirmation");
					rd = request.getRequestDispatcher("/joinEvent.jsp");
						
		
			}
			
		
		else if(action.equals("View All Events"))
		{
			
			Map<String, Event> events=om.getAllEvents();
			request.setAttribute("events", events);
			
					
			rd = request.getRequestDispatcher("/viewEventsForExhibitor.jsp");
		}
		
		
		else if(action.equals("View Event Page"))
		{
			String uname=(String) session.getAttribute("userName");
		
			String eventid=request.getParameter("eventid");
			rd = request.getRequestDispatcher("/EventPage.jsp");
					
	
		}
		 
		else if(action.equals("Update Exhibitor"))
		 {
			String uname=request.getParameter("uname").trim();
			String password=request.getParameter("password").trim();
			String oldUserId=request.getParameter("oldUserId").trim();//old password from hidden field 
			
			String name=request.getParameter("name").trim();
			String email=request.getParameter("email").trim();
			String phone=request.getParameter("phone").trim();
			String address=request.getParameter("address").trim();
			int flag=1;
			if(uname==""||password==""||name==""||email==""||phone==""||address=="")
			{
				request.setAttribute("errorMessage", "Exhibitor can not be updated because you are missing required fields...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
				flag=0;//Go away
			}
			else if(lm.userNameExist(uname) ){//Will go if uname already exist
				if((uname.equals(oldUserId)))
				{
					//This means user going to update his info but he does not changed uname
				}
				else{//if he change user name then find whether uname already exist
				request.setAttribute("errorMessage", "Changes can not be made because Username already exists...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
				flag=0;//Go away
				}
			}
			
			
			if(flag==1){
				User exhibitor = null;
			
				exhibitor=new User(uname,name,email,phone,address);
			
					User updatedExhibitor=em.updateExhibitorDetail(exhibitor, oldUserId, password);
				 if(updatedExhibitor==null){
				    	
				    	request.setAttribute("errorMessage", "Something went wrong...");
						rd = request.getRequestDispatcher("/errorPage.jsp");
				    }
				    else{
				  request.setAttribute("password", password); 
				  request.setAttribute("uname", uname); 
				  request.setAttribute("exhibitor", updatedExhibitor);
				  request.setAttribute("CALLER", "Update Exhibitor");
				  request.setAttribute("Role", "Exhibitor");
				  rd = request.getRequestDispatcher("/displayExhibitor.jsp");
				    }
			
			}
			
			
		}
		else{
			
			for(int i=0;i<eventnames.length;i++)
			{
				Event e=(eventsName.get(eventnames[i]));
				if(action.equals( e.getEventName())  )
						{
							String eventid=eventnames[i];
							request.setAttribute("eventid", eventid);
							
							request.setAttribute("eventname", e.getEventName());
							ArrayList<Product> products=em.getAllProductsOtherThanBiddingProducts((String) session.getAttribute("userName"));
							log("JAGRAJ SIDHU :"+products.size());
							ArrayList<BiddingProduct> bidProducts=em.getAllBiddingProducts((String) session.getAttribute("userName"), eventid);
							request.setAttribute("products", products);
							request.setAttribute("bidproducts", bidProducts);
							rd=request.getRequestDispatcher("/exhibitorProducts.jsp");
						}
			}
			
		}
		rd.forward(request, response);
		
	}
	

}
