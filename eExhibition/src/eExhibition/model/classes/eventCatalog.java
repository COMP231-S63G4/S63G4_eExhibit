package eExhibition.model.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import eExhibition.data.classes.Event;
import eExhibition.data.classes.User;

public interface eventCatalog {
	
	
	//Events  Related Details
	

	public User addEvent(String location,Date startDate,Date endDate);
	public User updateEvent(String location,Date startDate,Date endDate);
	public User deleteEvent(String eventId,String eventName);
	public User getOrganisername(String eventorganizers);
	public Map<String,Event> getEvent(String eventid);
	
}
