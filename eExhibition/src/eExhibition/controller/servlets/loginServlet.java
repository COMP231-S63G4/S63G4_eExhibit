package eExhibition.controller.servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eExhibition.data.classes.Notification;
import eExhibition.model.classes.loginManager;
import eExhibition.model.classes.notificationManager;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String pass=request.getParameter("pass");

		RequestDispatcher rd = null;
		loginManager lm = loginManager.getInstance();
		notificationManager nm = notificationManager.getInstance();
		String type = lm.validateLoginDetails(name ,pass);
		if (type != null) {
			session.setAttribute("userName", name);// Later fetch user
													// name-JAGRAJ SIDHU
			ArrayList<Notification> notifications = nm
					.getAllNotificationOfUserName(name);
			if (notifications == null) {
				request.setAttribute("notiStatus", "old");
			} else {
				request.setAttribute("notiStatus", "new");
			}
			request.setAttribute("topNotification", notifications);
			if (type.equals("admn")) {

				rd = request.getRequestDispatcher("/AdminHomePage.jsp");

			}

			else if (type.equals("orgn")) {

				rd = request.getRequestDispatcher("/OrganiserHomePage.jsp");

			} else if (type.equals("exbt")) {
				rd = request.getRequestDispatcher("/ExhibitorHomePage.jsp");

			} else if (type.equals("rusr")) {
				rd = request
						.getRequestDispatcher("/RegisteredUserHomePage.jsp");

			}
		} else {
			rd = request.getRequestDispatcher("/ErrorMessage.jsp");

		}
		rd.forward(request, response);

	}

}
