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

/**
 * Servlet implementation class mainPage
 */

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String name=request.getParameter("name");		
		String pass=request.getParameter("pass");
		
		session.setAttribute("userName", name);//Later fetch user name-JAGRAJ SIDHU
		RequestDispatcher rd ;
		int flag=0,a=0;
		try {
	    Class.forName("com.mysql.jdbc.Driver");
				
		java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
	    Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from login");
		 
		
		/*a=
		1.Admin
		2.Organizer
		3.Exhibitor
		4.Registered User
		*/
			
				while(rs.next())
				{
				        
				        if((rs.getString(1).equals(name))&&(rs.getString(2).equals(pass)))
						{
						  flag=1;
						  if(rs.getString(3).equals("admn"))
						  {
						  a=1 ;
						  }
						  if(rs.getString(3).equals("orgn"))
						  {
						  a=2;
						  }
						  if(rs.getString(3).equals("exbt"))
						  {
						  a=3 ;
						  }
						  if(rs.getString(3).equals("rusr"))
						  {
						  a=4;
						  }
					      break;
						}
				}
				st.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(flag==1)
			{
			if(a==1)
			{
			
				rd = request.getRequestDispatcher("/AdminHomePage.jsp");
			
			}
			
			else if(a==2)
			{
			
				rd = request.getRequestDispatcher("/OrganiserHomePage.jsp");
					
			
			}
			else if(a==3){
				rd = request.getRequestDispatcher("/ExhibitorHomePage.jsp");
					
				
			}else{
				rd = request.getRequestDispatcher("/RegisteredUserHomePage.jsp");
					
			}
			
			}
			
		   else{
			   rd = request.getRequestDispatcher("/ErrorMessage.jsp");
							
		   }
		
		
		
		
		rd.forward(request, response);
	}

}
