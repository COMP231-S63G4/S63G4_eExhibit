package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
					"jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			Statement st = con.createStatement();
			st.executeUpdate("Insert into notification(uname,notification,date) values('"
					+ uname
					+ "','"
					+ notification
					+ "','"
					+ new java.sql.Timestamp(new java.util.Date().getTime())
					+ "')");

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

	@Override
	public Map<String,Notification> getAllNotificationOfUserName(String uname) {
		
		Map<String,Notification> notifications=new HashMap<String, Notification>();
		
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select uname,notification,date from notification where uname='"+uname+"'");
		    while(rs.next())
		    {
		    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    	String sDate = String.valueOf(rs.getTimestamp("date"));		    	
		    	Date stDate = sdf.parse(sDate);		    	
		    	notifications.put(rs.getString(1),new Notification(rs.getString(1),rs.getString(2),stDate));
		    	
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
			
			return notifications;
	}

}
