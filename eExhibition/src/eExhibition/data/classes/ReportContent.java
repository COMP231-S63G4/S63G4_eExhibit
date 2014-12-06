package eExhibition.data.classes;

public class ReportContent {
	
			String productId;
			
			String description;
			
			String userid;
			
			
			public  ReportContent(String productId,String description,String userid)
			{
			
			      this.productId=productId;
			     
			      this.description=description;
			      
			      this.userid=userid;
			     
			}
			public String getProductId()
			{
			return productId;
			}
			
			public void setproductId(String pId)
			{
			productId=pId;
			}
			
			
			
			public String getDescription()
			{
			return description;
			}
			
			public void setDescription(String description)
			{
			this.description=description;
			
			}
			
			
			public String getuserid()
			{
			return userid;
			}
			
			public void setuserid(String userid)
			{
			this.userid=userid;
			
			}
			
			
			
}