package eExhibition.model.classes;

import java.util.ArrayList;

import eExhibition.data.classes.ReportContent;
import eExhibition.data.classes.User;

public interface adminCatalog {
	
	//Own Details changing
	public int changeAdminDetails(String uname,String password);
	
	//Organizer Related
	public User addOrganiser(User organiser,String password);
	public User updateOrganiser(User organiser,String oldUserId,String password);
	public User deleteOrganiser(String uname);
	public User getOrganiser(String uname);
	public String getPasswordOfUserName(String uname);
	public ArrayList<User> getAllUsers(String type);
	public ArrayList<User> getAllUsersById(String type,String uname);
	public ArrayList<String> getAllUsersId(String type);
	public ArrayList<ReportContent> getAllReportedContent();
	public boolean deleteReportedContent(String productid,String userid);
}
