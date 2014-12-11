package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import eExhibition.data.classes.Notification;
import eExhibition.data.classes.SoldProduct;

public class notificationManager implements notificationCatalog {

	private static notificationManager nm = null;

	public synchronized static notificationManager getInstance() {
		if (nm == null) {

			nm = new notificationManager();

		}
		return nm;
	}

	private notificationManager() {
		// Just to be sure nobody outside make object of notificationManager
		// Class- Private Constructor

	}

	@Override
	public boolean sendNotification(String uname, String notification) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eexhibition", "root", "password");
			Statement st = con.createStatement();
			st.executeUpdate("Insert into notification(uname,notification,date,status) values('"
					+ uname
					+ "','"
					+ notification
					+ "','"
					+ new java.sql.Timestamp(new java.util.Date().getTime())

					+ "','notviewed')");

			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	// functionality to fetch the notifications from the database of respective
	// user

	@Override
	public ArrayList<Notification> getAllNotificationOfUserName(String uname) {

		ArrayList<Notification> notifications = new ArrayList<Notification>();
		int flag = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eexhibition", "root", "password");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("Select uname,notification,date from notification where uname='"
							+ uname + "' and status='notviewed'");
			/*st.executeUpdate("Update notification set status='viewed' where uname='"
					+ uname + "'");*/
			while (rs.next()) {
				flag = 1;
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String sDate = String.valueOf(rs.getTimestamp("date"));
				Date stDate = sdf.parse(sDate);
				notifications.add(
						new Notification(rs.getString(1), rs.getString(2),
								stDate));

			}

			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == 0) {
			return null;
		} else {
			return notifications;
		}
	}

	@Override
	public boolean sendUserNotificationOfWonBiddingProduct(String userId,
			String notification) {
		// TODO Auto-generated method stub
		try {

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eexhibition", "root", "password");
			Statement st = con.createStatement();
			st.executeUpdate("Insert into notification(uname,notification,date,status) values('"
					+ userId
					+ "','"
					+ notification
					+ "','"
					+ new java.sql.Timestamp(new java.util.Date().getTime())

					+ "','notviewed')");

			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

}
