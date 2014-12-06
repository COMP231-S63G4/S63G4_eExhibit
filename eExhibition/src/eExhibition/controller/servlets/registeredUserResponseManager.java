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

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Event;
import eExhibition.data.classes.ExhibitorEvent;
import eExhibition.data.classes.Product;
import eExhibition.data.classes.User;
import eExhibition.model.classes.adminManager;
import eExhibition.model.classes.eventManager;
import eExhibition.model.classes.loginManager;
import eExhibition.model.classes.notificationManager;
import eExhibition.model.classes.organiserManager;
import eExhibition.model.classes.registeredUserManager;

/**
 * Servlet implementation class adminResponseManager
 */
@WebServlet("/registeredUserResponseManager")
public class registeredUserResponseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registeredUserResponseManager() {
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
		registeredUserManager rm=registeredUserManager.getInstance();
		notificationManager nm=notificationManager.getInstance();
		adminManager am=adminManager.getInstance();
		//loginManager lm=loginManager.getInstance();
		//organiserManager om=organiserManager.getInstance();
		//notificationManager nm=notificationManager.getInstance();
		eventManager em=eventManager.getInstance();
		if(action.equals("My Details"))
		{
			String uname=(String) session.getAttribute("userName");
			User registereduser=rm.getRegisteredUser(uname);
			request.setAttribute("password",am.getPasswordOfUserName(uname)); 
			 request.setAttribute("uname", uname); 
			 request.setAttribute("registereduser", registereduser);
			 request.setAttribute("CALLER", "Display Registered User");
				 request.setAttribute("Role", "RegisteredUser");
				 rd = request.getRequestDispatcher("/displayRegisteredUser.jsp");
		}
		
		else if(action.equals("View All Events"))
		{
			
			Map<String, Event> events=em.getAllEvents();
			request.setAttribute("events", events);
			
					
			rd = request.getRequestDispatcher("/viewEventsForUsers.jsp");
		}
		else if(action.equals("View Bidding Products"))
		{
			
			Map<String, ArrayList<BiddingProduct>> bidProducts=em.getAllBiddindProducts();
			request.setAttribute("bidproduct", bidProducts);
								
			rd = request.getRequestDispatcher("/biddingProductsAllEvents.jsp");
		}
		if(action.equals("Reported Content"))
		{
			String productid=request.getParameter("productid");
			Product product=em.getProductById(productid);
			Product reportedContent=rm.reportedContent(product);
			rd = request.getRequestDispatcher("/ViewProducts.jsp");
		}
		else if(action.equals("My Bid"))
		{
			String earlierTopUser=(String) request.getAttribute("top1");
			//bidding values added
			nm.sendNotification(earlierTopUser, "Hey!!! Somebody has bid higger than you for product "
					+".");									
			rd = request.getRequestDispatcher("/biddingProductsAllEvents.jsp");
		}
		
	
		
		
		rd.forward(request, response);
		
	}
	

}
