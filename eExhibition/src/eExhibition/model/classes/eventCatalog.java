package eExhibition.model.classes;
import java.util.Map;

import eExhibition.data.classes.Event;
import eExhibition.data.classes.Product;

public interface eventCatalog {
	
	
	public Map<String,Event> getAllEvents();
	public Event getEventById(String eventId);
	public Event addEvent(Event newEvent);
	public Event updateEvent(Event changedEvent);
	public Event deleteEvent(Event event);
	public boolean eventIdExists(String eventid);
	public Product addProductEvent(Product newProduct);
	public boolean productIdExists(String productid);
	public Product addProduct(Product product);
}
