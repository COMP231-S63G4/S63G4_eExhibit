package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class notificationManager implements notificationCatalog {

private static notificationManager nm = null;
	

	public synchronized static notificationManager getInstance() {
		if (nm == null ) {
			
			nm = new notificationManager();
			
		}
		return nm;
	}

	
	
	private notificationManager() {
		//Just to be sure nobody outside make object of notificationManager Class- Private Constructor
	
	}
	@Override
	public boolean sendNotification(String uname, String notification) {
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();						
			st.executeUpdate("Insert into notification(uname,notification,date) values('"+uname+"','"
				+notification+"','"+new java.sql.Timestamp(new java.util.Date().getTime())+"')");	
			
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
