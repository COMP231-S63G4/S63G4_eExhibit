package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginManager {
	
	private static loginManager lm = null;	

	public synchronized static loginManager getInstance() {
		if (lm == null ) {
			
			lm = new loginManager();
			
		}
		return lm;
	}

	
	
	private loginManager() {
		//Just to be sure nobody outside make object of loginManager Class- Private Constructor
	
	}
	//Return type(admn,exbt,rusr,orgn) if successful
	public String validateLoginDetails(String uname)//,String password)
	{
		
		try {
	    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from login");
		 
			while(rs.next())
			{
			        
			        if((rs.getString(1).equals(uname)))//&&(rs.getString(2).equals(password)))
					{
					  
					  return rs.getString(3);
					  
					}
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
			return null;//If uname and password do not match
		}
		public boolean userNameExist(String uname)
		{
			try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select uname from login");
			 
				while(rs.next())
				{
				        
				        if((rs.getString(1)).equals(uname))
						{
						  
						  return true;
						  
						}
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
			return false;
			
		}
	
}
