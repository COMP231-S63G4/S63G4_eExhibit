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
		input.inviteExibitors{
			background-image:url(${pageContext.request.contextPath}/images/inviteExibitors.png);
			width:100px;
			height:100px;
			border:0;
		}
		
		input.pendingRequest{
			background-image:url(${pageContext.request.contextPath}/images/viewOrganisers.png);
			width:100px;
			height:100px;
			border:0;
		}
		input.addEvent{
		background-image:url(${pageContext.request.contextPath}/images/addEvent.png);
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
	</style>
  </head>
  
  <body style="text-align:center;">
  <%@ include file="bannerTop.jsp" %> 
   Hello Organiser <br>
    <form action="${pageContext.request.contextPath}/organiserResponseManager" method="post">
   <table align="center">
		    <tr>
		    
		    <td><input   class="viewDetails" value="">
		    <br/><input type="Submit" name="action"  value="My Details"/></td>
		    
		    <td><input   class="addEvent" value="">
		    <br/><input type="Submit" name="action"  value="Add Event"/></td>
		    
		    <td><input   class="inviteExibitors" value="">
		    <br/><input type="Submit" name="action"  value="Invite Exhibitors"/></td>
		    
		    <td><input   class="pendingRequest" value="">
		    <br/><input type="Submit" name="action"  value="Pending Requests"/></td>
		    
		    </tr>
		    
		    <tr>
		    
		    <td><input   class="viewEvents" value="">
		    <br/><input type="Submit" name="action"  value="View All Events"/></td>
		    
		    <td>&nbsp;</td>
		    
		    <td>&nbsp;</td>
		    
		    <td>&nbsp;</td>
		    
		    </tr>
		    
		     
	    </table>
	    </form>
	    <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
