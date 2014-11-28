package eExhibition.data.classes;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Notification {

	String uname;
	String notification;	
	Date date;
	
	
	public Notification(String uname,String notification,Date date)
	{
		
		this.uname= uname;
		this.notification =notification;		
		this.date =date;
		
	}
	
	
	public String getUserName()
	{
		return uname;
	}
	public void setUserName(String name)
	{
		this.uname=name;
		
	}
	public String getNotification()
	{
		return notification;
	}
	public void setNotification(String notification)
	{
		this.notification=notification;
		
	}
	
	
	public Date getDate()
	{
		return date;
	}
	public void setStartDate(Date date)
	{
		this.date=date;
	}
	
	
	public String getDateInString()
	{
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(date);
		return s;
	}
	
}

