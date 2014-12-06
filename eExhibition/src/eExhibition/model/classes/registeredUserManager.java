package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eExhibition.data.classes.Product;
import eExhibition.data.classes.User;

public class registeredUserManager implements registeredUserCatalog {
	private static registeredUserManager em = null;	

	public synchronized static registeredUserManager getInstance() {
		if (em == null ) {
			
			em = new registeredUserManager();
			
		}
		return em;
	}

	
	
	private registeredUserManager() {
		
	
	}
	
	@Override 
	public User addRegisteredUser(User registeredUser, String password) {
		
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    Statement st=con.createStatement();
					st.executeUpdate("Insert into login(uname,password,type) values('"+registeredUser.getUserId()+"','"+password+"','rusr')");
					st.executeUpdate("Insert into users(uname,name,email,phone,address) values('"+registeredUser.getUserId()+
							"','"+registeredUser.getName()+"','"+registeredUser.getEmail()+
							"','"+registeredUser.getPhone()+"','"+registeredUser.getaddress()+"')");
										
										
					st.close();
					
					con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return registeredUser;
				
			}

	public Product reportedContent(Product product){
		String description="";
		String userId="";
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
			st.executeUpdate("Insert into reportedContent='"+product.getProductId()+"',password='"+description+"' where uname='"+userId+"'");
			
			st.close();
			
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return product;
		
	}
	
	
	
	public User updateRegisteredUserDetail(User registeredUser, String oldUserId,	String password) {
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    Statement st=con.createStatement();
					st.executeUpdate("Update login set uname='"+registeredUser.getUserId()+"',password='"+password+"' where uname='"+oldUserId+"'");
					st.executeUpdate("Update users set uname='"+registeredUser.getUserId()+"',name='"+registeredUser.getName()+"',email='"+registeredUser.getEmail()+"',phone='"+registeredUser.getPhone()+"',address='"+registeredUser.getaddress()+"' where uname='"+oldUserId+"'");
					
					st.close();
					
					con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return registeredUser;
				
			}
	
	public User getRegisteredUser(String uname) {
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

	
}
