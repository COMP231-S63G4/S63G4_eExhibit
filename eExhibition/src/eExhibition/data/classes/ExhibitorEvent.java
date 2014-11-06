package eExhibition.data.classes;

public class ExhibitorEvent {
	private String uname;
	private String eventid;
	
	public ExhibitorEvent(String uname,String eventid){
		this.uname=uname;
		this.eventid=eventid;
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
}
