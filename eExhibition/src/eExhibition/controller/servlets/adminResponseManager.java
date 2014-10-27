package eExhibition.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eExhibition.data.classes.User;
import eExhibition.model.classes.adminManager;
import eExhibition.model.classes.loginManager;

/**
 * Servlet implementation class adminResponseManager
 */
@WebServlet("/adminResponseManager")
public class adminResponseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminResponseManager() {
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
		
		if(action.equals("Add Organiser"))
		{
			rd = request.getRequestDispatcher("/addOrganiser.jsp");
		}
		
		else if(action.equals("View")){
			
			String uname=request.getParameter("uname");
			User organiser=am.getOrganiser(uname);
			request.setAttribute("password",am.getPasswordOfUserName(uname)); 
			 request.setAttribute("uname", uname); 
			 request.setAttribute("organiser", organiser);
			 request.setAttribute("CALLER", "Display Organiser");
			 rd = request.getRequestDispatcher("/displayOrganiser.jsp");
		}
		
		else if(action.equals("Delete")){
			String uname=request.getParameter("uname");
			User deletedOrganiser=am.deleteOrganiser(uname);
			/*request.setAttribute("password",am.getPasswordOfUserName(uname)); //lol jad delete ho geya ta millu ki*/
			 request.setAttribute("uname", uname); 
			 request.setAttribute("organiser", deletedOrganiser);
			 request.setAttribute("CALLER", "Delete Organiser");
			 rd = request.getRequestDispatcher("/displayOrganiser.jsp");
	}
		else if(action.equals("View Organizers")){
			Map<String,User> userList = new HashMap<String,User>();
			ArrayList<User> alist=am.getAllUsers();
		
			for(User u:alist)
			{
				userList.put(u.getUserId(),u);
			}
			
			request.setAttribute("userList", userList);
			rd = request.getRequestDispatcher("/viewOrganisers.jsp");
		}
		
		else if(action.equals("Update Details"))
		{
			String uname=request.getParameter("changedUname").trim();
			String password=request.getParameter("changedPassword").trim();
			if(lm.userNameExist(uname))
			{
				request.setAttribute("errorMessage", "Username already exists...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			else{
				int res=am.changeAdminDetails(uname, password);
				if(res!=0){
				request.setAttribute("passChanged", "Your username and password successfully changed!!!");
				rd = request.getRequestDispatcher("/AdminHomePage.jsp");
				}
				else{
					request.setAttribute("errorMessage", "Internal Error!!! Username and password not changed...");
					rd = request.getRequestDispatcher("/errorPage.jsp");
				}
			}
		}
		
		
		else if(action.equals("Update Organizer"))
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
				request.setAttribute("errorMessage", "Organizer can not be updated because you are missing required fields...");
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
				User organiser = null;
			
				organiser=new User(uname,name,email,phone,address);
			
					User updatedOrganiser=am.updateOrganiser(organiser, oldUserId, password);
				 if(updatedOrganiser==null){
				    	
				    	request.setAttribute("errorMessage", "Something went wrong...");
						rd = request.getRequestDispatcher("/errorPage.jsp");
				    }
				    else{
				  request.setAttribute("password", password); 
				  request.setAttribute("uname", uname); 
				  request.setAttribute("organiser", updatedOrganiser);
				  request.setAttribute("CALLER", "Update Organiser");
				  rd = request.getRequestDispatcher("/displayOrganiser.jsp");
				    }
			
			}
			
			
		}
		
		
		
		
		else if(action.equals("Add"))
		{
			String uname=request.getParameter("uname").trim();
			String password=request.getParameter("password").trim();
			String name=request.getParameter("name").trim();
			String email=request.getParameter("email").trim();
			String phone=request.getParameter("phone").trim();
			String address=request.getParameter("address").trim();
			if(uname==""||password==""||name==""||email==""||phone==""||address=="")
			{
				request.setAttribute("errorMessage", "Organizer can not be added because you are missing required fields...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			else if(lm.userNameExist(uname))
			{
				request.setAttribute("errorMessage", "Username already exists...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			else{
			User organiser = null;
			
				organiser=new User(uname,name,email,phone,address);
			
					User addedOrganiser=am.addOrganiser(organiser, password);
				 if(addedOrganiser==null){
				    	
				    	request.setAttribute("errorMessage", "Something went wrong...");
						rd = request.getRequestDispatcher("/errorPage.jsp");
				    }
				    else{
				  request.setAttribute("password", password); 
				  request.setAttribute("uname", uname); 
				 request.setAttribute("organiser", addedOrganiser);
				 request.setAttribute("CALLER", "Add Organiser");
				 rd = request.getRequestDispatcher("/displayOrganiser.jsp");
				    }
			
			}
		}
		else{
			request.setAttribute("errorMessage", action);
			 rd = request.getRequestDispatcher("/errorPage.jsp");
		}
		
		
		
		rd.forward(request, response);
		
	}
	

}
