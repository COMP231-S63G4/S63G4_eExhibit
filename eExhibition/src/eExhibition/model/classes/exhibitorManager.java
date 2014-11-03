package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import eExhibition.data.classes.User;

public class exhibitorManager implements exhibitorCatalog {
	private static exhibitorManager em = null;	

	public synchronized static exhibitorManager getInstance() {
		if (em == null ) {
			
			em = new exhibitorManager();
			
		}
		return em;
	}

	
	
	private exhibitorManager() {
		//Just to be sure nobody outside make object of adminManager Class- Private Constructor
	
	}
	
	@Override
	public User addExhibitor(User exhibitor, String password) {
		
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
				    Statement st=con.createStatement();
					st.executeUpdate("Insert into login(uname,password,type) values('"+exhibitor.getUserId()+"','"+password+"','exbt')");
					st.executeUpdate("Insert into users(uname,name,email,phone,address) values('"+exhibitor.getUserId()+
							"','"+exhibitor.getName()+"','"+exhibitor.getEmail()+
							"','"+exhibitor.getPhone()+"','"+exhibitor.getaddress()+"')");
										
										
					st.close();
					
					con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return exhibitor;
				
			}

	
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password) {
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
				    Statement st=con.createStatement();
					st.executeUpdate("Update login set uname='"+exhibitor.getUserId()+"',password='"+password+"' where uname='"+oldUserId+"'");
					st.executeUpdate("Update users set uname='"+exhibitor.getUserId()+"',name='"+exhibitor.getName()+"',email='"+exhibitor.getEmail()+"',phone='"+exhibitor.getPhone()+"',address='"+exhibitor.getaddress()+"' where uname='"+oldUserId+"'");
					
					st.close();
					
					con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return exhibitor;
				
			}
	
}
