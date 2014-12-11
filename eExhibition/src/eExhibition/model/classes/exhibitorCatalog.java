package eExhibition.model.classes;

import java.util.Map;

import eExhibition.data.classes.*;

public interface exhibitorCatalog {
	public User addExhibitor(User exhibitor,String password);
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password);
	public User getExhibitor(String uname);
	public Map<String,Event> getAllOtherEvents(String exhibitoruname);
	public Map<String,Event> getAllExhibitorEvents(String exhibitoruname);
	public boolean registerToParticipate(String uname,String eventId, String description);
	
	
}
