package eExhibition.model.classes;

import java.util.ArrayList;
import java.util.Map;

import eExhibition.data.classes.Event;
import eExhibition.data.classes.User;

public interface organiserCatalog {
	public User updateOrganiserDetail(User organiser,String oldUserId,String password);
	public Map<String,Event> getAllEvents();
	public Map<String,User> getAllExhibitors();
	public Event getEventById(String eventId);
	public boolean inviteExhibitors(String eventId,ArrayList<String> exhibitorsUnames);
}
