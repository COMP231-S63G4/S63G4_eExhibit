package eExhibition.model.classes;

import java.util.Map;

import eExhibition.data.classes.*;

public interface exhibitorCatalog {
	public User addExhibitor(User exhibitor,String password);
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password);
	public User getExhibitor(String uname);
	public Map<String,Event> getAllOtherEvents(String exhibitoruname);
	public User registerToParticipate(User exhibitor,Event eventId, String description);
}
