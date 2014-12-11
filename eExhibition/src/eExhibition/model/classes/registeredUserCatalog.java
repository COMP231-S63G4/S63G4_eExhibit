package eExhibition.model.classes;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import eExhibition.data.classes.*;

public interface registeredUserCatalog {
	public User addRegisteredUser(User registeredUser,String password);
	public User updateRegisteredUserDetail(User registeredUser, String oldUserId,	String password);
	public User getRegisteredUser(String uname);
	
	public Product reportedContent(Product product);
	public ArrayList<Product> getAllProducts() ;
	
	
}
