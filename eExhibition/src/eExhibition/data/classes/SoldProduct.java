package eExhibition.data.classes;

import java.util.Date;

public class SoldProduct {
	Event event;
	Product product;
	String buyeruname;
	
	
	public SoldProduct(Event event,Product product ,String buyeruname )
	{
		this.event=event;
		this.product = product; 
		this.buyeruname=buyeruname;
	}
	
	public Event getEvent()
	{
		return event;
	}
	public void setEvent(Event event)
	{
		this.event=event;
	}
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		this.product = product; 
	}
	
	public void setBuyerUname(String buyeruname)
	{
		this.buyeruname= buyeruname;
	}
	public String getBuyerUname()
	{
		return buyeruname;
		
	}
}