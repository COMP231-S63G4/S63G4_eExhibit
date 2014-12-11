<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewEvents</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<fieldset style="margin-left:50px;margin-right:50px">
<legend>
<h1 style="color:white;">All Events</h1></legend>
<form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
<table border="1" align="center" style="color:white">
<tr>
<th>Event Name</th><th>Details</th><th>Location</th><th>Start Date</th><th>End Date</th><th>Event Organizers</th>
</tr>

<c:forEach items="${requestScope.events}" var="event">
	
	
		<tr>
		
		
		<th><c:out value="${event.value.getEventName()}"></c:out></th>
		<th><c:out value="${event.value.getDetails()}"></c:out></th>
		<th><c:out value="${event.value.getLocation()}"></c:out></th>
		<th><c:out value="${event.value.getStartDate()}"></c:out></th>
		<th><c:out value="${event.value.getEndDate()}"></c:out></th>
		<th><c:out value="${event.value.getEventOrganizers()}"></c:out></th>
		
		
		</tr>
		
	
	
</c:forEach>


</table>
<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/ExhibitorHomePage.jsp'"/>
	
	</form>
	</fieldset>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>