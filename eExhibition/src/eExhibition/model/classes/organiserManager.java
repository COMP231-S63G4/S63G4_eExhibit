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

import eExhibition.data.classes.Event;
import eExhibition.data.classes.ExhibitorEvent;
import eExhibition.data.classes.User;

public class organiserManager implements organiserCatalog {
	
	private static organiserManager om = null;
	

	public synchronized static organiserManager getInstance() {
		if (om == null ) {
			
			om = new organiserManager();
			
		}
		return om;
	}

	
	
	private organiserManager() {
		//Just to be sure nobody outside make object of organiserManager Class- Private Constructor
	
	}
	@Override
	public User updateOrganiserDetail(User organiser, String oldUserId,	String password) {
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
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
	
	public Map<String,Event> getAllEvents(){
		Map<String,Event> events=new HashMap<String, Event>();
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select eventid,eventname,details,location,startdate,enddate,eventorganisers from events");
		    while(rs.next())
		    {
		    	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
	public Event getEventById(String id)
	{
		Event event = null;
try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
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
	public Map<String,User> getAllExhibitors(){
		Map<String,User> exhibitors=new HashMap<String, User>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select users.uname,name,address,phone,email from users,login where users.uname=login.uname and type='exbt'");
				while(rs.next())
				{
					exhibitors.put(rs.getString(1),new User(rs.getString(1),rs.getString(2),rs.getString(5),rs.getString(4),rs.getString(3)));
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
				
			return exhibitors;
	}
	public ArrayList<ExhibitorEvent> getAllPendingRequest(){
		ArrayList<ExhibitorEvent> pendingRequests=new ArrayList<ExhibitorEvent>();
		try {
			    
				Class.forName("com.mysql.jdbc.Driver");				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
			    Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("Select uname,eventid,description from pendingrequest");
				while(rs.next())
				{
					 pendingRequests.add(new ExhibitorEvent(rs.getString(1),rs.getString(2),rs.getString(3)));
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
				
			return pendingRequests;
		
	}
	public boolean requestDecisionMaker(ExhibitorEvent ue,String action){
		
				try {
					    
						Class.forName("com.mysql.jdbc.Driver");				
						java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
					    Statement st=con.createStatement();						
						st.executeUpdate("Delete from pendingrequest where uname='"+ue.getUName()+"' and eventid='"+ue.getEventId()+"'");
						if(action.equals("accept"))
						{
							st.executeUpdate("Insert into eventexhibitor values('"+ue.getEventId()+"','"+ue.getUName()+"')");
								   
						}
						/*else
						{
							st.executeUpdate("Insert into notification(uname,notification,date) values('"+ue.getUName()+"','Sorry!!! You request to participate in exhibition "
									+ue.getEventId()+" has been rejected','"+new java.sql.Timestamp(new java.util.Date().getTime())+"')");	
									
						}*/
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
	
	public boolean inviteExhibitors(String eventId,ArrayList<String> exhibitorsUnames){
		try {
				    
					Class.forName("com.mysql.jdbc.Driver");				
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
				    Statement st=con.createStatement();
				    String notification;
				    for(String exhibitor : exhibitorsUnames)
				    {
				    	notification="Congratulation!!! You have been invited to participate in new event "+eventId+".";
				    	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
				    	st.executeUpdate("Insert into eventexhibitor(eventid,exhibitoruname) values('"+eventId+"','"+exhibitor+"')");
				    	st.executeUpdate("Insert into notification(uname,notification,date) values('"+exhibitor+"','"+notification+"','"+date+"')");	
				    }
					
					
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
	public Map<String, Event> getAllTickets() {
		Map<String,Event> events=new HashMap<String, Event>();
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select ");
		    while(rs.next())
		    {
		    	
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
			
			return events;
	}



	public int numberOfSoldTickets() {
		int noOfSoldTickets=0;
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
		    Statement st=con.createStatement();
		    noOfSoldTickets=st.executeUpdate("Select COUNT(*) FROM ticket");
						
			st.close();
			
			con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return noOfSoldTickets;
		
}


}

