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
<h2>------Pending Requests-----</h2>
<table border="1" align="center">
<tr>
<th>UserName</th><th>EventId</th><th>Description</th><th colspan="2">Action</th>
</tr>
<c:forEach items="${requestScope.requests}" var="request">
	
	<form action="${pageContext.request.contextPath}/organiserResponseManager" method="post">
		<tr>
		<th><input type="hidden" name="uname"   value="<c:out value="${request.getUName()}"></c:out>"/>
		<c:out value="${request.getUName()}"></c:out></th>
		<th><input type="hidden" name="eventid"   value="<c:out value="${request.getEventId()}"></c:out>"/>
		<c:out value="${request.getEventId()}"></c:out></th>
		<th><input type="hidden" name="description"   value="<c:out value="${request.getDescription()}"></c:out>"/>
		<c:out value="${request.getDescription()}"></c:out></th>
		<th><input type="submit" name="action" value="Accept"/></th>
		<th><input type="submit" name="action" value="Reject"/></th>
		</tr>
	</form>
	
</c:forEach>


</table>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>