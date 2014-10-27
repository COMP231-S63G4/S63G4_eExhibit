package eExhibition.model.classes;

import eExhibition.data.classes.User;

public interface organiserCatalog {
	public User updateOrganiserDetail(User organiser,String oldUserId,String password);
	
}
