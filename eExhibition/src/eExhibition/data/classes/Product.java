package eExhibition.data.classes;

public class Product {
	
			String productId;
			String productTitle;
			String description;
			//String image;
			String price;
			String type;
			String exhibitorUname;
			String kind;
			
			public  Product(String productId,String productTitle,String description,String price,String type,String exhibitorUname,String kind)
			{
			
			      this.productId=productId;
			      this.productTitle= productTitle;
			      this.description=description;
			      //this.image=image;
			      this.price= price;
			      this.type =type;
			      this.exhibitorUname=exhibitorUname;
			      this.kind=kind;
			}
			String getProductId()
			{
			return productId;
			}
			void setproductId(String pId)
			{
			productId=pId;
			}
			
			String getProductTitle()
			{
			return productTitle;
			}
			void setProductTitle(String title)
			{
			this.productTitle=title;
			
			}
			
			String getDescription()
			{
			return productTitle;
			}
			void setDescription(String description)
			{
			this.description=description;
			
			}
			
			String getPrice()
			{
			return productTitle;
			}
			void setPrice(String price)
			{
			this.price=price;
			
			}
			
			String getType()
			{
			return type;
			}
			void setType( String type)
			{
				
			this.type=type;
			
			}
			
			String getExhibitorUname()
			{
			return productTitle;
			}
			void setExhibitorUname(String exhibitorUname)
			{
			this.productTitle=exhibitorUname;
			
			}
			
			String getKind()
			{
			return kind;
			}
			void setKind( String kind)
			{
				
			this.kind=kind;
			
			}
			
}