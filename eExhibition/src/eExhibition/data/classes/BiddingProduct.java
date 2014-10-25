package eExhibition.data.classes;

import java.util.Date;


public class BiddingProduct{

			String eventId;
			Product product;
			Date startDate;
			Date endDate;
			String startPrice;
			String closePrice;
			String uName;
			
			
			public BiddingProduct(String eventId,Product product , Date startDate, Date endDate,String startPrice , String closePrice , String uName)
			{
				this.eventId=eventId;
				this.product = product; 
				this.startDate= startDate;
				this.endDate =endDate;
				this.startPrice =startPrice ;
				this.closePrice= closePrice;
				this.uName=uName;
			}
			
			String getEventId()
			{
				return eventId;
			}
			void setEventId(String eventId)
			{
				this.eventId=eventId;
			}
			Product getProduct()
			{
				return product;
			}
			void setProduct(Product product)
			{
				this.product = product; 
			}
			Date getStartDate()
			{
				return startDate;
				
			}
			void setStartDate(Date startDate)
			{
				this.startDate= startDate;
			}
			Date getEndDate()
			{
				return endDate;
				
			}
			void setEndDate(Date endDate)
			{
				this.endDate =endDate;
			}
			String getStartPrice()
			{
				return startPrice;
			}
			void setStartPrice(String startPrice)
			{
				this.startPrice =startPrice ;
			}
			String getClosePrice()
			{
				return closePrice;
			}
			void setClosePrice(String closePrice)
			{
				this.closePrice= closePrice;
			}
			String getUName()
			{
				return uName;
			}
			void setUName(String uName)
			{
				this.uName=uName;
			}
}
