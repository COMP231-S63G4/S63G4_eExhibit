<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewOrganisers</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<h2>------All Organizers-----</h2>
<table border="1" align="center">
<tr>
<th>UserName</th><th>Name</th><th>Address</th><th>Phone</th><th>Email</th><th></th><th></th>
</tr>
<c:forEach items="${requestScope.userList}" var="user">
	
	<form action="${pageContext.request.contextPath}/adminResponseManager" method="post">
		<tr>
		<th><input type="hidden" name="uname"   value="<c:out value="${user.key}"></c:out>"/><c:out value="${user.key}"></c:out></th>
		<th><c:out value="${user.value.name}"></c:out></th>
		<th><c:out value="${user.value.address}"></c:out></th>
		<th><c:out value="${user.value.phone}"></c:out></th>
		<th><c:out value="${user.value.email}"></c:out></th>
		<th><input type="submit" name="action" value="View"/></th>
		<th><input type="submit" name="action" value="Delete"/></th>
		</tr>
	</form>
	
</c:forEach>


</table>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>