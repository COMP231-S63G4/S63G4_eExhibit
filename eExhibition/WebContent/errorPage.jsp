<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>

<style type="text/css">
	.noBorder
	{
		border:none;
	}
</style>

</head>
<body>
<%@ include file="bannerTop.jsp" %> 
<br/>
<div style="text-align:center">
	<h1>...OOPs Error!!! We are sorry...</h1>
	<h2><b>Reason:</b></h2>
	<h2 style="color: red;">
	
		<c:out value="${requestScope.errorMessage}"/>
	</h2>
		
		<br/>
	<br/>
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/index.jsp'"/>
</div>
	<%@ include file="bannerBottom.jsp" %> 		
</body>
</html>