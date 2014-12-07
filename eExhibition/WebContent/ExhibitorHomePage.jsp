<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ExhibitorHomePage</title>
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
		input.viewAllEvents{
			background-image:url(${pageContext.request.contextPath}/images/viewAllEvents.png);
			width:100px;
			height:100px;
			border:0;
		}
			input.joinEvent{
			background-image:url(${pageContext.request.contextPath}/images/viewAllEvents.png);
			width:100px;
			height:100px;
			border:0;
		}
		
	</style>
  </head>
  
  <body style="text-align:center;">
  <%@ include file="bannerTop.jsp" %> 
   Hello Exhibitor <br/>
    <div  style="position:absolute;right:230px;top:248px;">
    	<%@ include file="sideMenuNotificationLogout.jsp" %> 
    </div>
    <form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
   <table align="center">
		    <tr>
		    
		    <td><input   class="viewDetails" value="">
		    <br/><input type="Submit" name="action"  value="My Details"/></td>
		    <td><input   class="viewAllEvents" value="">
		    <br/><input type="Submit" name="action"  value="View All Events"/></td>
		    <td><input   class="joinEvent" value="">
		    <br/><input type="Submit" name="action"  value="Join Event"/></td>
		    </tr>
		    
		     
	    </table>
	    </form>
	    <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
