package eExhibition.controller.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eExhibition.data.classes.User;
import eExhibition.model.classes.adminManager;
import eExhibition.model.classes.exhibitorManager;
import eExhibition.model.classes.loginManager;



@WebServlet("/RegistrationManager")

public class RegistrationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationManager() {
        super();
       
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		RequestDispatcher rd = null ;
		String action = request.getParameter("action");
		exhibitorManager em=exhibitorManager.getInstance();
		loginManager lm = loginManager.getInstance();
	// registeredUserManager rm =	registeredUserManager.getInstance();
						
		if(action.equals("Register"))
		{
			int exbtRegis=1;//REMOVE IT WHEN REGISTER USER IS ADDED
			String uname=request.getParameter("uname").trim();
			String password=request.getParameter("password").trim();
			String name=request.getParameter("name").trim();
			String email=request.getParameter("email").trim();
			String phone=request.getParameter("phone").trim();
			String address=request.getParameter("address").trim();
			String role=request.getParameter("role").trim();
			
			if(uname==""||password==""||name==""||email==""||phone==""||address==""||role=="")
			{
				request.setAttribute("errorMessage", "User can not be added because you are missing required fields...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			else if(lm.userNameExist(uname))
			{
				request.setAttribute("errorMessage", "Username already exists...");
				rd = request.getRequestDispatcher("/errorPage.jsp");
			}
			else{
						User exhibitor = null;
						exhibitor=new User(uname,name,email,phone,address);
						if(role.equals("exbt"))
						{
							
						
							User addedExhibitor=em.addExhibitor(exhibitor, password);
							
								
						}
						else{
							//User added=rm.addRegisteredUser(user, password);
							exbtRegis=0;
							System.out.println("-----KOMAL------");
						}
						request.setAttribute("indexMessage", "You are successfully registered...");
						rd = request.getRequestDispatcher("/index.jsp");
		
			}
			
	
		}
		rd.forward(request, response);
		
	}
}