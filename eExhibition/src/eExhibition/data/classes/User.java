package eExhibition.data.classes;

public class User {
	
	private String uName;
	private String name;
	private String email;
	private String phone;
	private String address;
	public User(String uId,String name,String email,String phone,String address){
		this.uName=uId;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.address=address;
	}
	public String getUserId()
	{
		return uName;
	}
	public void setUserId(String uId)
	{
		uName=uId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email=email;
		
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
		
	}
	public String getaddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
}
