package eExhibition.data.classes;

import java.util.Date;


public class BiddingProduct{

			Event event;
			Product product;
			Date startDate;
			Date endDate;
			String startPrice;
			String closePrice;
			User user;
			
			
			public BiddingProduct(Event event,Product product , Date startDate, Date endDate,String startPrice , String closePrice , User user)
			{
				this.event=event;
				this.product = product; 
				this.startDate= startDate;
				this.endDate =endDate;
				this.startPrice =startPrice ;
				this.closePrice= closePrice;
				this.user=user;
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
			public Date getStartDate()
			{
				return startDate;
				
			}
			public void setStartDate(Date startDate)
			{
				this.startDate= startDate;
			}
			public Date getEndDate()
			{
				return endDate;
				
			}
			public void setEndDate(Date endDate)
			{
				this.endDate =endDate;
			}
			public String getStartPrice()
			{
				return startPrice;
			}
			public void setStartPrice(String startPrice)
			{
				this.startPrice =startPrice ;
			}
			public String getClosePrice()
			{
				return closePrice;
			}
			public void setClosePrice(String closePrice)
			{
				this.closePrice= closePrice;
			}
			public User getUName()
			{
				return user;
			}
			public void setUName(User user)
			{
				this.user=user;
			}
}
