package eExhibition.model.classes;
import java.util.ArrayList;
import java.util.Map;

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Event;
import eExhibition.data.classes.Product;
import eExhibition.data.classes.User;

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
	public Product getProductById(String productId);
	
	
	public User getUserById(String userid);
	//bidding functions
	public Map<String, ArrayList<BiddingProduct>> getAllBiddindProducts();
}
