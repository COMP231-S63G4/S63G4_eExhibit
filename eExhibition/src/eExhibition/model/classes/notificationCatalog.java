package eExhibition.model.classes;

import java.util.ArrayList;
import java.util.Map;

import eExhibition.data.classes.Notification;

public interface notificationCatalog {
	public boolean sendNotification(String uname, String notification);

	public ArrayList<Notification> getAllNotificationOfUserName(String uname);
	
	public boolean sendUserNotificationOfWonBiddingProduct(String userId,String notifiction);
}
