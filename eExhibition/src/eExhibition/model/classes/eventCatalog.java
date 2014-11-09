package eExhibition.model.classes;
import java.util.Map;
import eExhibition.data.classes.Event;

public interface eventCatalog {
	
	
	public Map<String,Event> getAllEvents();
	public Event getEventById(String eventId);
	public Event addEvent(Event newEvent);
	public Event updateEvent(Event changedEvent);
	public Event deleteEvent(Event event);
	public boolean eventIdExists(String eventid);
}
