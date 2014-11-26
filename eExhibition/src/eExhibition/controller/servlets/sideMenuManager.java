package eExhibition.controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eExhibition.data.classes.Event;
import eExhibition.data.classes.User;
import eExhibition.model.classes.adminManager;
import eExhibition.model.classes.eventManager;
import eExhibition.model.classes.exhibitorManager;
import eExhibition.model.classes.loginManager;
import eExhibition.model.classes.notificationManager;
import eExhibition.model.classes.organiserManager;

/**
 * Servlet implementation class sideMenuManager
 */
@WebServlet("/sideMenuManager")
public class sideMenuManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sideMenuManager() {
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
		notificationManager am=notificationManager.getInstance();
		
		
		
		if(action.equals("notificationIcon"))
		{
			String uname=(String) session.getAttribute("userName");
			//User exhibitor=em.getExhibitor(uname);
			request.setAttribute("password",am.getAllNotificationOfUserName(uname)); 
			
			rd = request.getRequestDispatcher("/displayNotification.jsp");
		}
		else if(action.equals("logoutIcon"))
		{
			
			
			session.invalidate();		
			rd = 
			request.getRequestDispatcher("/index.jsp");
			
		}
		
		rd.forward(request, response);
		
	}
	

}
