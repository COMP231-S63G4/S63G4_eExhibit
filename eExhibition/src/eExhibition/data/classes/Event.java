package eExhibition.data.classes;

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
	String getEventId()
	{
		return eventId;
	}
	void setEventId(String eId)
	{
		eventId=eId;
	}
	
	String getEventName()
	{
		return eventName;
	}
	void setEventName(String name)
	{
		this.eventName=name;
		
	}
	String getDetails()
	{
		return details;
	}
	void setDetails(String details)
	{
		this.details=details;
		
	}
	
	String getLocation()
	{
		return location;
	}
	void setLocation(String location)
	{
		this.location=location;
		
	}
	
	Date getStartDate()
	{
		return startDate;
	}
	void setStartDate(Date startDate)
	{
		this.startDate=startDate;
	}
	
	Date getEndDate()
	{
		return endDate;
	}
	void setEndDate(Date endDate)
	{
		this.endDate=endDate;
	}
	
	String getEventOrganizers()
	{
		return eventOrganizers;
	}
	void setEventOrganizers(String eventOrganizers)
	{
		this.eventOrganizers=eventOrganizers;
		
	}
}
