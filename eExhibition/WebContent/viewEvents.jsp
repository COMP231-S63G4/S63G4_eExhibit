<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<h2>------All Events-----</h2>
<table border="1" align="center">
<tr>
<th>Event Id</th><th>Event Name</th><th>Details</th><th>Location</th><th>Start Date</th><th>End Date</th><th>Event Organizers</th>
</tr>

<c:forEach items="${requestScope.events}" var="event">
	
	<form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
		<tr>
		<th><c:out value="${event.key}"></c:out></th>
		
		<th><c:out value="${event.value.eventName}"></c:out></th>
		<th><c:out value="${event.value.details}"></c:out></th>
		<th><c:out value="${event.value.location}"></c:out></th>
		<th><c:out value="${event.value.startDate}"></c:out></th>
		<th><c:out value="${event.value.endDate}"></c:out></th>
		<th><c:out value="${event.value.eventOrganizers}"></c:out></th>
		</tr>
	</form>
	
</c:forEach>


</table>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>