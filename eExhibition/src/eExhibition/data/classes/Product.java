package eExhibition.data.classes;

public class Product {
	
			String productId;
			String productTitle;
			String description;
			String image;
			String price;
			String type;
			String exhibitorUname;
			String kind;
			
			public  Product(String productId,String productTitle,String description,String price,String type,String exhibitorUname,String kind)
			{
			
			      this.productId=productId;
			      this.productTitle= productTitle;
			      this.description=description;
			      this.image=image;
			      this.price= price;
			      this.type =type;
			      this.exhibitorUname=exhibitorUname;
			      this.kind=kind;
			}
			public String getProductId()
			{
			return productId;
			}
			
			public void setproductId(String pId)
			{
			productId=pId;
			}
			
			public void setImage(String img)
			{
				image=img;
			}
			
			public String getImage()
			{
				return image;
			}
			
			public String getProductTitle()
			{
			return productTitle;
			}
			
			public void setProductTitle(String title)
			{
			this.productTitle=title;
			
			}
			
			public String getDescription()
			{
			return productTitle;
			}
			
			public void setDescription(String description)
			{
			this.description=description;
			
			}
			
			public String getPrice()
			{
			return productTitle;
			}
			
			public void setPrice(String price)
			{
			this.price=price;
			
			}
			
			public String getType()
			{
			return type;
			}
			public void setType( String type)
			{
				
			this.type=type;
			
			}
			
			public String getExhibitorUname()
			{
			return productTitle;
			}
			
			public void setExhibitorUname(String exhibitorUname)
			{
			this.productTitle=exhibitorUname;
			
			}
			
			public String getKind()
			{
			return kind;
			}
			
			public void setKind( String kind)
			{
				
			this.kind=kind;
			
			}
			
}