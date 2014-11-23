<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>OrganiserHomePage</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
	<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
	
<style type="text/css">

		input.viewDetails{
			background-image:url(${pageContext.request.contextPath}/images/viewDetails.png);
			width:100px;
			height:100px;
			border:0;
		}
		
		
		input.viewEvents
		{
		background-image:url(${pageContext.request.contextPath}/images/viewAllEvents.png);
			width:100px;
			height:100px;
			border:0;
		 }
		 
		 input.viewBiddingProducts
		 {
		background-image:url(${pageContext.request.contextPath}/images/viewAllEvents.png);
			width:100px;
			height:100px;
			border:0;
		 }
	</style>
  </head>
  
  <body style="text-align:center;">
  <%@ include file="bannerTop.jsp" %> 
   Hello Registered User <br>
    <form action="${pageContext.request.contextPath}/registeredUserResponseManager" method="post">
	   <table align="center">
			    <tr>
			    
			    <td><input   class="viewDetails" value="">
			    <br/><input type="Submit" name="action"  value="My Details"/></td>
			    
			    <td><input   class="viewEvents" value="">
			    <br/><input type="Submit" name="action"  value="View All Events"/></td>
			    
			      <td><input   class="viewBiddingProducts" value="">
			    <br/><input type="Submit" name="action"  value="View Bidding Products"/></td>
			    
			    </tr>		    
			    			     
		    </table>
	    </form>
	    <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
