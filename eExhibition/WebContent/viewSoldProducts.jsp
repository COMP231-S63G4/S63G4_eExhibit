<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>viewExhibitors</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<h2>------All Sold Products-----</h2>
<table border="1" align="center">
<tr>
<th>Event Id</th><th>Product Id</th><th>Buyer Name</th>
</tr>
<c:forEach items="${requestScope.userList}" var="soldproduct">
	
	<form action="${pageContext.request.contextPath}/OrganiserResponseManager" method="post">
		<tr>
		<th><input type="hidden" name="uname"   value="<c:out value="${soldproduct.key}"></c:out>"/><c:out value="${soldproduct.key}"></c:out></th>
		<th><c:out value="${soldproduct.value.eventid}"></c:out></th>
		<th><c:out value="${soldproduct.value.productid}"></c:out></th>
		<th><c:out value="${soldproduct.value.buyeruname}"></c:out></th>
		
		</tr>
	</form>
	
</c:forEach>


</table>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>