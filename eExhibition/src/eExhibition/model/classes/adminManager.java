package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eExhibition.data.classes.User;

public class adminManager implements adminCatalog {
	private static adminManager am = null;	

	public synchronized static adminManager getInstance() {
		if (am == null ) {
			
			am = new adminManager();
			
		}
		return am;
	}

	
	
	private adminManager() {
		//Just to be sure nobody outside make object of adminManager Class- Private Constructor
	
	}

	@Override
	public int changeAdminDetails(String uname, String password) {
		int res = 0;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
			res=st.executeUpdate("Update login set uname='"+uname+"',password='"+password+"' where type='admn'");
		 
			
			st.close();
			
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return res;
		}
		
		
	

	@Override
	public User addOrganiser(User organiser, String password) {//Komal task
		
	}

	@Override
	public User updateOrganiser(User organiser,String oldUserId, String password) {//komal task
		
	}

	@Override
	public User deleteOrganiser(String uname) {
		User deletedOrganiser=null;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    deletedOrganiser=getOrganiser(uname);
			st.executeUpdate("Delete from login where uname='"+uname+"'");
			st.executeUpdate("Delete from users where uname='"+uname+"'");
			
			st.close();
			
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				return deletedOrganiser;
			
	}



	@Override
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users=new ArrayList<User>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname,name,address,phone,email from users");
				while(rs.next())
				{
					users.add(new User(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(4),rs.getString(3)));
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
				
			return users;
		}



	@Override
	public User getOrganiser(String uname) {
		User user=null;
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname,name,address,phone,email from users where uname='"+uname+"'");
				while(rs.next())
				{
					user=new User(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(4),rs.getString(3));
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
				
			return user;//if not found return null
	}



	@Override
	public String getPasswordOfUserName(String uname) {
		String password=null;
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname,password,type from login where uname='"+uname+"'");
				while(rs.next())
				{
					password=rs.getString(2);
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
				
			return password;
	}

	
	
	
}
