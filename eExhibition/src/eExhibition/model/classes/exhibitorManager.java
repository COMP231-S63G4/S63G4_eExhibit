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

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Event;
import eExhibition.data.classes.ExhibitorEvent;
import eExhibition.data.classes.Notification;
import eExhibition.data.classes.Product;
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
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
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

	public Map<String,Event> getAllOtherEvents(String exhibitoruname){
		Map<String,Event> events=new HashMap<String, Event>();
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select eventid,eventname,details,location,startdate,enddate,eventorganisers from events where eventid Not in(Select eventid from eventexhibitor where exhibitoruname ='"+exhibitoruname+"')");
		   		    
		    while(rs.next())
		    {
		    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	String sDate = String.valueOf(rs.getTimestamp("startdate"));
		    	String eDate = String.valueOf(rs.getTimestamp("enddate"));
		    	Date stDate = sdf.parse(sDate);
		    	Date edDate = sdf.parse(eDate);
		    	Event event=new Event(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),stDate,edDate,rs.getString(7));
		    	events.put(rs.getString(1), event);
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
			
			return events;
	}
	
	public Map<String,Event> getAllExhibitorEvents(String exhibitoruname){
		Map<String,Event> events=new HashMap<String, Event>();
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select eventid,eventname,details,location,startdate,enddate,eventorganisers from events where eventid in(Select eventid from eventexhibitor where exhibitoruname ='"+exhibitoruname+"')");
		   		    
		    while(rs.next())
		    {
		    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    	String sDate = String.valueOf(rs.getTimestamp("startdate"));
		    	String eDate = String.valueOf(rs.getTimestamp("enddate"));
		    	Date stDate = sdf.parse(sDate);
		    	Date edDate = sdf.parse(eDate);
		    	Event event=new Event(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),stDate,edDate,rs.getString(7));
		    	events.put(rs.getString(1), event);
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
			
			return events;
	}
	
	
	
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password) {
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
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
	
	public ArrayList<Product> getAllProductsOtherThanBiddingProducts(String uname) 
	{

		ArrayList<Product> products = new ArrayList<Product>();
		int flag = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("Select productid,producttitle,description,image,price,type,exhibitoruname,kind from products where exhibitoruname='"
							+ uname + "' and type!='bidd'");
			/*st.executeUpdate("Update notification set status='viewed' where uname='"
					+ uname + "'");*/
			while (rs.next()) {
				flag=1;
				products.add(
						new Product(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8)));

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
		} 
		if (flag == 0) {
			return null;
		} else {
			return products;
		}
	}
	
	public User getUserById(String userid)
	{
		User user=null;
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname,name,address,phone,email from users where uname='"+userid+"' ");
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
				
			return user;
	}
	public ArrayList<BiddingProduct> getAllBiddingProducts(String uname,String eventid){

		ArrayList<BiddingProduct> products = new ArrayList<BiddingProduct>();
		int flag = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("Select p.productid,p.producttitle,p.description,p.image,p.price,p.type,p.exhibitoruname,p.kind,b.startdate,b.enddate,b.startprice,b.closeprice,b.uname,b.uname2,b.topprice2,b.uname3,b.topprice3 from products p,biddingproduct b where p.exhibitoruname='"
							+ uname + "' and p.type='bidd' and p.productid=b.productid and b.eventid='"+eventid+"'");
			/*st.executeUpdate("Update notification set status='viewed' where uname='"
					+ uname + "'");*/
			while (rs.next()) {
				flag=1;
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String sDate = String.valueOf(rs.getTimestamp("startdate"));
				Date stDate=null;
				String eDate = String.valueOf(rs.getTimestamp("enddate"));
				Date edDate=null;
				try {
					stDate = sdf.parse(sDate);
					edDate = sdf.parse(eDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				products.add(
						
						new BiddingProduct(getEventById(eventid),new Product(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6),rs.getString(7), rs.getString(8)),stDate,edDate,rs.getString(11),rs.getString(12),getUserById(rs.getString(13)),getUserById(rs.getString(14)),rs.getString(15),getUserById(rs.getString(16)),rs.getString(17)));

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
		} 
		if (flag == 0) {
			return null;
		} else {
			return products;
		}
	}
	
	public User getExhibitor(String uname) {
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
	
	
	public Event getEventById(String id)
	{
		Event event = null;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select eventid,eventname,details,location,startdate,enddate,eventorganisers from events where eventid='"+id+"'");
		    while(rs.next())
		    {
		    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		    	String sDate = String.valueOf(rs.getTimestamp("startdate"));
		    	String eDate = String.valueOf(rs.getTimestamp("enddate"));
		    	Date stDate = sdf.parse(sDate);
		    	Date edDate = sdf.parse(eDate);
		    	event=new Event(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),stDate,edDate,rs.getString(7));
		    	
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
		return event;
	}
	
	
public boolean registerToParticipate(String uname,String eventId, String description) {
		
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    Statement st=con.createStatement();
					st.executeUpdate("Insert into pendingrequest(uname,eventid,description) values('"+uname+"','"+eventId+"','"+description+"')");
		
										
										
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
