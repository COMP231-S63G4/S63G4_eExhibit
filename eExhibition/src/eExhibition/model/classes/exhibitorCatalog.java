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
import java.util.Map;

import eExhibition.data.classes.*;

public interface exhibitorCatalog {
	public User addExhibitor(User exhibitor,String password);
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password);
	public User getExhibitor(String uname);
	
	public Map<String,Event> getAllOtherEvents(String exhibitoruname);
	public Map<String,Event> getAllExhibitorEvents(String exhibitoruname);
	
	public boolean registerToParticipate(String uname,String eventId, String description);
	
	public ArrayList<Product> getAllProductsOtherThanBiddingProducts(String uname) ;
	public ArrayList<BiddingProduct> getAllBiddingProducts(String uname,String eventid) ;
	
	public User getUserById(String userid);
	public Event getEventById(String eventId);
	
	
}
