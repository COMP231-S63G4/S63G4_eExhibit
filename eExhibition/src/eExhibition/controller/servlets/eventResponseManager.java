package eExhibition.controller.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eExhibition.data.classes.Event;
import eExhibition.data.classes.User;
import eExhibition.model.classes.eventManager;
import eExhibition.model.classes.exhibitorManager;
import eExhibition.model.classes.loginManager;

/**
 * Servlet implementation class eventResponseManager
 */
@WebServlet("/eventResponseManager")
public class eventResponseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventResponseManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null ;
		String action = request.getParameter("action");
		eventManager em=eventManager.getInstance();
		/*loginManager lm = loginManager.getInstance();*/
	// registeredUserManager rm =	registeredUserManager.getInstance();
						
		if(action.equals("Create New Event"))
		{
		
			String eventname=request.getParameter("eventname").trim();
			String details=request.getParameter("details").trim();
			String location=request.getParameter("location").trim();
			String startdate=request.getParameter("startdate").trim();
			String enddate=request.getParameter("enddate").trim();
			String eventorganisers=request.getParameter("eventorganisers").trim();
			String eventid= "E"+(Math.random() * 100000000 + 1);
			while(em.eventIdExists(eventid))
			{
				eventid= "E"+(Math.random() * 100000000 + 1);
			}
			java.sql.Date sd=null;
			java.sql.Date ed=null;
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
				sd= new java.sql.Date(format.parse(startdate).getTime());
				ed= new java.sql.Date(format.parse(enddate).getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			
			
			
			
			if(eventname==""||details==""||location==""||eventorganisers=="")
			{
				request.setAttribute("errorMessage", "Event can not be added because you are missing required fields...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			
			else{
						Event event = null;
						event=new Event(eventid, eventname, details, location, sd, ed, eventorganisers);
						Event addedEvent=em.addEvent(event);
						//request.setAttribute("indexMessage", "You are successfully registered...");
						rd = request.getRequestDispatcher("/OrganiserHomePage.jsp");
		
			}
			
	
		}
		
		rd.forward(request, response);
		
	}
}