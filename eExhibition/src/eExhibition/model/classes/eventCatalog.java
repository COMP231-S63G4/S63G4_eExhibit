package eExhibition.model.classes;
import java.util.ArrayList;
import java.util.Map;

import eExhibition.data.classes.BiddingProduct;
import eExhibition.data.classes.Event;
import eExhibition.data.classes.Product;
import eExhibition.data.classes.SoldProduct;
import eExhibition.data.classes.User;

public interface eventCatalog {
	
	
	public Map<String,Event> getAllEvents();//GET ALL Events
	public Event getEventById(String eventId);
	public Event addEvent(Event newEvent);
	public Event updateEvent(Event changedEvent);
	public Event deleteEvent(Event event);
	public boolean eventIdExists(String eventid);
	
	public boolean productIdExists(String productid);//Ambiguous--
	public Product addProduct(Product product);
	public Product getProductById(String productId);
	
	
	public User getUserById(String userid);
	//bidding functions
	public Map<String, ArrayList<BiddingProduct>> getAllBiddindProducts();
	public Map<String,SoldProduct> getAllSoldProducts();
	public Product updateProduct(Product changedProduct);
	public Map<String,Product> getAllProducts();
}
