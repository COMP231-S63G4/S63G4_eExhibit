<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>AboutUs</title>
			<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
			<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
		</head><!--end of head-->
			<body><!--starting of body-->
					 <%@ include file="bannerTop.jsp" %>
					 
					 <div id="content_area1">
							<div class="bottom_panel_section">
									<div class="news_section">
									
								
									<div id="product_left">&nbsp;&nbsp;
					 <img src="images/P1C.jpg"> </br></br>
					
									</div>&nbsp;&nbsp;&nbsp;&nbsp;
									<div id="product_right">
									<text id= "product_text"> &nbsp; 
									 &nbsp; &nbsp; &nbsp; &nbsp; Book Name: Author</br></br>
									 &nbsp; &nbsp;  &nbsp; &nbsp;Author Name: Steve </br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; Original price: $100</br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; Current price: $60</br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; Coupon Name:BOOK14</br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; Book Type: Drama </br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Status: IN STOCK</br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Time Left: 2 days</br></br>
									&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; HURRY UP GUYS!
									</div>
							</div> 
							  </div>
        
								<div class="cleaner_h20">&nbsp;</div>  
          
				    </div> <!-- end of content_area1-->
				    
				    
				    <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
    
