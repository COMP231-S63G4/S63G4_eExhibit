package eExhibition.model.classes;

import java.util.Map;

import eExhibition.data.classes.*;

public interface registeredUserCatalog {
	public User addRegisteredUser(User registeredUser,String password);
	public User updateRegisteredUserDetail(User registeredUser, String oldUserId,	String password);
	public User getRegisteredUser(String uname);
	
	
	
	
}
