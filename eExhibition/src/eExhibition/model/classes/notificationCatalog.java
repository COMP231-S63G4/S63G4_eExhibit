package eExhibition.model.classes;

import java.util.Map;

import eExhibition.data.classes.Notification;

public interface notificationCatalog {
	public boolean sendNotification(String uname,String notification);
	public Map<String,Notification> getAllNotificationOfUserName(String uname);
}
