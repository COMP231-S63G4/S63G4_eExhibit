package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eExhibition.data.classes.ReportContent;
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
	public User addOrganiser(User organiser, String password) {
		int loginOk=0;
		int userOk=0;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
			loginOk=st.executeUpdate("Insert into login(uname,password,type) values('"+organiser.getUserId()+"','"+password+"','orgn')");
			userOk=st.executeUpdate("Insert into users(uname,name,email,phone,address) values('"+organiser.getUserId()+"','"+organiser.getName()+"','"+organiser.getEmail()+"','"+organiser.getPhone()+"','"+organiser.getaddress()+"')");
			
			st.close();
			
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(loginOk!=0&&userOk!=0)
			{
				return organiser;
			}
			else{
				return null;
			}
	}

	@Override
	public User updateOrganiser(User organiser,String oldUserId, String password) {
		
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

	public boolean deleteReportedContent(String productid,String userid){
		
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    
			st.executeUpdate("Delete from reportedcontent where productid='"+productid+"' and userid='"+userid+"'");
						
			st.close();
			
			con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				return false;
			} 
				return true;
		
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
	public ArrayList<String> getAllUsersId(String type){
		
		ArrayList<String> usersid=new ArrayList<String>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname from login where type='"+type+"'");
				while(rs.next())
				{
					usersid.add(rs.getString(1));
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
				
			return usersid;
		
	}
	@Override
	public ArrayList<User>getAllUsersById(String type,String uname){
		ArrayList<User> users=new ArrayList<User>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select users.uname,name,address,phone,email from users,login where users.uname=login.uname and type='"+type+"' and users.uname like '%"+uname+"%'");
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

	public ArrayList<ReportContent> getAllReportedContent(){
		ArrayList<ReportContent> contents=new ArrayList<ReportContent>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select productid,description,userid from reportedcontent ");
				while(rs.next())
				{
					contents.add(new ReportContent(rs.getString(1),rs.getString(2),rs.getString(3)));
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
				
			return contents;
		
	}
	
	@Override
	public ArrayList<User> getAllUsers(String type) {
		ArrayList<User> users=new ArrayList<User>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select users.uname,name,address,phone,email from users,login where users.uname=login.uname and type='"+type+"' ");
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
