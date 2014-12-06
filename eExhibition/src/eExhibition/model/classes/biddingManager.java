package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Product;
import eExhibition.data.classes.User;

public class biddingManager implements registeredUserCatalog {
	private static biddingManager em = null;	

	public synchronized static biddingManager getInstance() {
		if (em == null ) {
			
			em = new biddingManager();
			
		}
		return em;
	}

	
	
	private biddingManager() {
		
	
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



	public BiddingProduct getRegisteredUserWonBidProduct(User ruser){
		return null;
	}



	@Override
	public User addRegisteredUser(User registeredUser, String password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User updateRegisteredUserDetail(User registeredUser,
			String oldUserId, String password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Product reportedContent(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
