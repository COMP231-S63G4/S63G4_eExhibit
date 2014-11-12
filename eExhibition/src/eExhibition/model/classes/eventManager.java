
				    	package eExhibition.model.classes;

				    	import java.sql.DriverManager;
				    	import java.sql.ResultSet;
				    	import java.sql.SQLException;
				    	import java.sql.Statement;
				    	import java.text.DateFormat;
				    	import java.text.ParseException;
				    	import java.text.SimpleDateFormat;
				    	import java.util.Date;
				    	import java.util.HashMap;
				    	import java.util.Map;

				    	import eExhibition.data.classes.Event;

				    	public class eventManager implements eventCatalog {

				    	private static eventManager em = null;
				    		

				    		public synchronized static eventManager getInstance() {
				    			if (em == null ) {
				    				
				    				em = new eventManager();
				    				
				    			}
				    			return em;
				    		}

				    		
				    		
				    		private eventManager() {
				    			//Just to be sure nobody outside make object of eventManager Class- Private Constructor	
				    		}
				    		public Map<String,Event> getAllEvents(){
				    			Map<String,Event> events=new HashMap<String, Event>();
				    			try {
				    			    
				    				Class.forName("com.mysql.jdbc.Driver");				
				    				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
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

				    		@Override
				    		public Event addEvent(Event newEvent) {
				    			int flag=0;
				    			try {
				    			    
				    				Class.forName("com.mysql.jdbc.Driver");				
				    				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    			    Statement st=con.createStatement();
				    				flag=st.executeUpdate("Insert into events(eventid,eventname,details,location,startdate,enddate,eventorganisers) values('"
				    			    +newEvent.getEventId()+"','"+newEvent.getEventName()+"','"+newEvent.getDetails()+"','"+newEvent.getLocation()+"','"+newEvent.getStartDate()+"','"+newEvent.getEndDate()+"','"+newEvent.getEventOrganizers()+"')");
				    				
				    				st.close();
				    				
				    				con.close();
				    				} catch (SQLException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				} catch (ClassNotFoundException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				}
				    				if(flag!=0)
				    				{
				    					return newEvent;
				    				}
				    				else{
				    					return null;
				    				}
				    			
				    		}

				    		@Override
				    		public Event updateEvent(Event changedEvent) {
				    			int flag=0;
				    			try {
				    			    
				    				Class.forName("com.mysql.jdbc.Driver");				
				    				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    			    Statement st=con.createStatement();
				    				flag=st.executeUpdate("Update events set eventname='"+
				    			    changedEvent.getEventName()+"',details='"+changedEvent.getDetails()+"',location='"+changedEvent.getLocation()
				    			    +"',startdate='"+changedEvent.getStartDate()+"',enddate='"+changedEvent.getEndDate()+"',eventorganisers='"+changedEvent.getEventOrganizers()+"' where eventid='"+changedEvent.getEventId()+"'");
				    				
				    				st.close();
				    				
				    				con.close();
				    				} catch (SQLException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				} catch (ClassNotFoundException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				}
				    				if(flag!=0)
				    				{
				    					return changedEvent;
				    				}
				    				else{
				    					return null;
				    				}
				    			
				    		}

				    		@Override
				    		public Event deleteEvent(Event event) {
				    			
				    			try {
				    			    
				    				Class.forName("com.mysql.jdbc.Driver");				
				    				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    			    Statement st=con.createStatement();
				    				st.executeUpdate("Delete from events where eventid='"+event.getEventId()+"'");
				    				
				    				st.close();
				    				
				    				con.close();
				    				} catch (SQLException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				} catch (ClassNotFoundException e) {
				    					// TODO Auto-generated catch block
				    					e.printStackTrace();
				    				}
				    			return event;
				    		}

				    		@Override
				    		public boolean eventIdExists(String eventid) {
				    			try {
				    			    
				    				Class.forName("com.mysql.jdbc.Driver");				
				    				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "admin");
				    			    Statement st=con.createStatement();
				    				ResultSet rs=st.executeQuery("select eventid from events");
				    			 
				    				while(rs.next())
				    				{
				    				        
				    				        if((rs.getString(1)).equals(eventid))
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
		    	