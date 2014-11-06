package eExhibition.model.classes;

import eExhibition.data.classes.User;

public interface exhibitorCatalog {
	public User addExhibitor(User exhibitor,String password);
	public User updateExhibitorDetail(User exhibitor, String oldUserId,	String password);
	public User getExhibitor(String uname);
}
