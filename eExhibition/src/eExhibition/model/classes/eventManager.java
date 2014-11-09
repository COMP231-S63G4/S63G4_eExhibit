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

public class eventManager implements eventCatalog {
	private static eventManager evm = null;	

	public synchronized static eventManager getInstance() {
		if (evm == null ) {
			
			evm = new eventManager();
			
		}
		return evm;
	}

	
	
	private eventManager() {
		//Just to be sure nobody outside make object of adminManager Class- Private Constructor
	
	}
	public Map<String,Event> getEvent(String eventid){
		Map<String,Event> events=new HashMap<String, Event>();
		try {
		    
			Class.forName("com.mysql.jdbc.Driver");				
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eexhibition", "root", "password");
		    Statement st=con.createStatement();
		    ResultSet rs=st.executeQuery("Select eventid,eventname,details,location,startdate,enddate,eventorganisers from events where eventid='"+eventid+"'");
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



	@Override
	public User addEvent(String location, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User updateEvent(String location, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User deleteEvent(String eventId, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User getOrganisername(String eventorganizers) {
		// TODO Auto-generated method stub
		return null;
	}

}
