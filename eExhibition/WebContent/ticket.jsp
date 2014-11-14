<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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
 

<div style="text-align: left;margin-left:150px;margin-right:150px;color:white;">

<fieldset>
<legend>
<h1 style="color:white;">Ticket</h1></legend>

<form action="${pageContext.request.contextPath}/UserResponseManager"  method="post">
<br>
<h1> Welcome to<c:out value="${event.getEventName()}"></c:out> event </h1>
<br>

<div style="text-align: left;color:white;width:50%;font-size:20px;float:left;">
Name -
<br><br>
Email Id-
<br><br>
Contact No-
<br>
<br>
Exhibitor -
</div>

<div style="font-size:20px;color:white;width:50%;float:right;">
Venue- 
<br>
<br>

Time -
<br>
</div>
<div style="font-size:26px;margin-top:120px ;margin-left:120px;text-align:left;float:left">

This event is organised by  
</div>


	</form>
	<br/>
	</fieldset>
	</div>
	
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>