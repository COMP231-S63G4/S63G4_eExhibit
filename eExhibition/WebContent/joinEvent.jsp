
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JoinEvent</title>
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
 

<div style="text-align: left;margin-left:100px;margin-right:100px">

<fieldset style="margin-left:150px;margin-right:150px">
<legend>
<h1 style="color:white;">Event Participation Form</h1></legend>

<form action="${pageContext.request.contextPath}/exhibitorResponseManager"  method="post">
<br>
<br>

<h1 style="color:white">Welcome to  event  <c:out value="${requestScope.event.getEventName()}"></c:out></h1>

	<table align="center" style="font-size: 20px;color:white" >
	<tr>
	<td><h4 style="color: red;">
	
						<c:out value="${requestScope.joinEventMessage}"/>
						</h4>
	</td></tr>
		<tr>
			<th> <input type="hidden" name="eventid" value="${requestScope.event.getEventId()}"/>&nbsp;</th>
			<td>&nbsp;</td>
		</tr>
		
		
		<tr>
		<th>
        Please provide the item details 
		</th>
		</tr>
		<tr>
			<td>
			<textarea  name="description" maxlength="1000" cols="25" rows="6"></textarea>
			
		</td>
		</tr>
		
	
	
	<tr><td ><input type="submit" name="action" value="Confirm" style="margin-left:65px"/></td></tr>
	
	</table>
	<c:if test="${requestScope.Role=='Exhibitor'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/ExhibitorHomePage.jsp'"/>
	</c:if>
	</form>
	
	<br/>
	</fieldset>
	</div>
	
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>