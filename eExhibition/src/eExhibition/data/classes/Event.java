package eExhibition.data.classes;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {

	String eventId;
	String eventName;
	String details;
	String location;
	Date startDate;
	Date endDate;
	String eventOrganizers;//Physical organizer commitee
	
	public Event(String eventId,String eventName,String details,	String location,Date startDate,	Date endDate,	String eventOrganizers)
	{
		this.eventId=eventId;
		this.eventName= eventName;
		this.details =details;
		this.location= location;
		this.startDate= startDate;
		this.endDate =endDate;
		this.eventOrganizers= eventOrganizers;
	}
	public String getEventId()
	{
		return eventId;
	}
	public void setEventId(String eId)
	{
		eventId=eId;
	}
	
	public String getEventName()
	{
		return eventName;
	}
	public void setEventName(String name)
	{
		this.eventName=name;
		
	}
	public String getDetails()
	{
		return details;
	}
	public void setDetails(String details)
	{
		this.details=details;
		
	}
	
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location=location;
		
	}
	
	public Date getStartDate()
	{
		return startDate;
	}
	public void setStartDate(Date startDate)
	{
		this.startDate=startDate;
	}
	
	public Date getEndDate()
	{
		return endDate;
	}
	public void setEndDate(Date endDate)
	{
		this.endDate=endDate;
	}
	
	public String getEventOrganizers()
	{
		return eventOrganizers;
	}
	public void setEventOrganizers(String eventOrganizers)
	{
		this.eventOrganizers=eventOrganizers;
		
	}
	public String getEndDateInString()
	{
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(endDate);
		return s;
	}
	public String getStartDateInString()
	{
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String s = formatter.format(startDate);
		return s;
	}
}
