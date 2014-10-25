package eExhibition.data.classes;

public class User {
	String uName;
	String name;
	String email;
	String phone;
	String address;
	public User(String uId,String name,String email,String phone,String address){
		uName=uId;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.address=address;
	}
	String getUserId()
	{
		return uName;
	}
	void setUserId(String uId)
	{
		uName=uId;
	}
	String getName()
	{
		return name;
	}
	void setName(String name)
	{
		this.name=name;
		
	}
	String getEmail()
	{
		return email;
	}
	void setEmail(String email)
	{
		this.email=email;
		
	}
	String getPhone()
	{
		return phone;
	}
	void setPhone(String phone)
	{
		this.phone=phone;
		
	}
	String getaddress()
	{
		return address;
	}
	void setAddress(String address)
	{
		this.address=address;
	}
}
