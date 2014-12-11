package eExhibition.data.classes;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BiddingProduct{

			Event event;
			Product product;
			Date startDate;
			Date endDate;
			String startPrice;
			String closePrice;
			User user;
			User user2;
			String topPrice2;
			User user3;
			String topPrice3;
			
			
			public BiddingProduct(Event event,Product product , Date startDate, Date endDate,String startPrice , String closePrice , User user,User user2,String topPrice2,User user3,String topPrice3)
			{
				this.event=event;
				this.product = product; 
				this.startDate= startDate;
				this.endDate =endDate;
				this.startPrice =startPrice ;
				this.closePrice= closePrice;
				this.user=user;
				this.user2=user2;
				this.topPrice2=topPrice2;
				this.user3=user3;
				this.topPrice3=topPrice3;
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
			public User getUser()
			{
				return user;
			}
			public void setUser(User user)
			{
				this.user=user;
			}
			public void setUser2(User user2)
			{
				this.user2=user2;
				
			}
			public User getUser2()
			{
				return user2;
			}
			public void setUser3(User user3)
			{
				this.user3=user3;
				
			}
			public User getUser3()
			{
				return user3;
			}
			public void setTopPrice2(String topPrice2){
				this.topPrice2=topPrice2;
			}
			public String getTopPrice2(){
				return topPrice2;
			}
			public void setTopPrice3(String topPrice3){
				this.topPrice3=topPrice3;
			}
			public String getTopPrice3(){
				return topPrice3;
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
