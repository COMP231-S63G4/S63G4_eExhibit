package eExhibition.data.classes;

public class ExhibitorEvent {
	private String uname;
	private String eventid;
	public ExhibitorEvent(){
		
	}
	public ExhibitorEvent(String uname,String eventid){
		uname=this.uname;
		eventid=this.eventid;
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
		uname=this.uname;
	}
	public void setEventId(String eventid)
	{
		eventid=this.eventid;
	}
}
