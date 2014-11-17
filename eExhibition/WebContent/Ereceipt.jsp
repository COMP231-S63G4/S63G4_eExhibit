<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ereceipt </title>
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
 
<div style="text-align: left;margin-left:50px;margin-right:50px;color:white;">

<fieldset>
<legend>
<h1 style="color:white;">E-Receipt</h1></legend>

<form action="${pageContext.request.contextPath}/UserResponseManager"  method="post">
<h1>Thank You!</h1>
<p>Your order is being processed.This typically takes 30 to 60 seconds. An order confirmation will be e-mailed to you.</p>
<p><u>You do not need to wait for your order to complete processing.</u></p>
<h3 style="color:white;">
<br>
Order Processing Status :
<br>
Order Transaction Number :
<br>
Order Confirmation to :
<br>
order Posted :
<br>
</h3>
<p>
Please make sure that your e-mail address is correct. To view or edit account information use the <b>My Profile Page</b>
<h2>Would you like to Continue Shopping or log-off? </h2>
</p>

	</form>
	<br/>
	</fieldset>
	</div>
	
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>