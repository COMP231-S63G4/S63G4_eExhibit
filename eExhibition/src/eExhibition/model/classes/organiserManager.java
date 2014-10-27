package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import eExhibition.data.classes.User;

public class organiserManager implements organiserCatalog {

	@Override
	public User updateOrganiserDetail(User organiser, String oldUserId,	String password) {
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    Statement st=con.createStatement();
					st.executeUpdate("Update login set uname='"+organiser.getUserId()+"',password='"+password+"' where uname='"+oldUserId+"'");
					st.executeUpdate("Update users set uname='"+organiser.getUserId()+"',name='"+organiser.getName()+"',email='"+organiser.getEmail()+"',phone='"+organiser.getPhone()+"',address='"+organiser.getaddress()+"' where uname='"+oldUserId+"'");
					
					st.close();
					
					con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return organiser;
				
			}

}
