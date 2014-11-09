package eExhibition.data.classes;

public class ExhibitorEvent {
	private String uname;
	private String eventid;
	private String description;
	
	public ExhibitorEvent(String uname,String eventid,String description){
		this.uname=uname;
		this.eventid=eventid;
		this.description=description;
	}
	public String getUName()
	{
		return uname;
	}
	public String getEventId()
	{
		return eventid;
	}
	public void setUName(String uname)
	{
		this.uname=uname;
	}
	public void setEventId(String eventid)
	{
		this.eventid=eventid;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description=description;
	}
}
