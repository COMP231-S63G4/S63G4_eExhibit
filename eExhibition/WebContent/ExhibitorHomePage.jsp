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
	    
<fieldset style="margin-left:50px;margin-right:50px">
<legend>
<h1 style="color:white;">Your Current Events</h1></legend>
<table border="1" align="center" style="color:white">
<tr>
<th>Event Name</th>
</tr>

<c:forEach items="${requestScope.events}" var="event">
	
	<form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
	
		<tr>
		
		 <th> <div class="eventClick"><img  src="${pageContext.request.contextPath}/images/eventIcon.gif" style="height:50px;width:50px"/><br>
		 <input type="hidden" name="eventId" value="${event.key}"/>
		<c:out value="${event.value.getEventName()}"></c:out>
		</div>
		<script>
			$(".eventClick").click(function(){
				$(this).parent().child().find(".submitBtn").trigger("click");	
				});
			$(".submitBtn").click(function(){
				alert("I am ok");
				});
		</script>
		<input class="submitBtn" name="action" style="display:none;"/>
		</th>
		<th>
		<input  class="submitBtn" name="action" value="View Event Page"/>
		</th>
	
		</tr>
		
	</form>
	
</c:forEach>



</table>

	</fieldset>
	    <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
