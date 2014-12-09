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
					 <script>
						$("#aboutUsPage").addClass("current");
					 </script>
                        <div id="AboutUsLeft">
                         

<fieldset>
    <legend>
    <h2 style="color:#99CC66">About Us</h2></legend>

    
<h4 style="color:#99CC66 ;margin-top:20px;">What is Eexhibit.com?</h4>

	&nbsp;Looking for an online Exhibitions?Searching for unique things?<br />
	Online exhibition is the place to 
        be! Online exhibition is your neighborhood online exhibition ad posting site that aims at 
        making life simpler for its users. Eexhibit.com is the most easy way to 
        search, buy or sell,visit the exhibition sites near your area. 
<br /><br />
<h4 style="color:#99CC66">Why to use Eexhibit.com?</h4><br/>
	> Free,Fast and Simple<br />
    > Quick response<br />
    > Easy Search<br />




</fieldset>
</div>

                      
                        <div id="ContactRight">
                            <a href="${pageContext.request.contextPath}/index.html"><img src="${pageContext.request.contextPath}/images/aboutUsPic.jpg" style="width:300px;height:300px" /></a>
                        </div>
				    <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							