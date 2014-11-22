<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display registereduser</title>
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
<fieldset style="margin-left:150px;margin-right:150px">
<legend>
<h1 style="color:white;">registereduser Profile</h1></legend>
<div style="text-align:center;color:white">
	<h2>
		<c:choose>
		    <c:when test="${requestScope.CALLER=='Display Registered User'}">
		       Displaying Registered User Details!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Add Registered User'}">
		       Following Registered User has been added successfully!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Delete Registered User'}">
		       Following Registered User has been deleted from system!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Update Registered User'}">
		       Your Updated Registered User Details!!!
		    </c:when>
	    
		</c:choose>
	</h2>
	<br/>
	<c:if test="${requestScope.CALLER=='Display Registered User'}">
		<c:if test="${requestScope.Role=='Registered User'}">
		 <form action="${pageContext.request.contextPath}/registeredUserResponseManager" method="post">
		</c:if>
		<c:if test="${requestScope.Role!='Registered User'}">
		      <form action="${pageContext.request.contextPath}/adminResponseManager" method="post">
		  </c:if>
		 <table  align="center" frame="box" >
		<tbody>
		<tr>
			<th>Name: </th><td><input   type="text" name="name" value="<c:out value="${requestScope.registereduser.name}"/>" style="width:160px;"/></td>
		</tr>
		<tr>
			<th>Username(Id): </th><td><input   type="text" name="uname" value="<c:out value="${requestScope.uname}"/>" style="width:160px;"/>
			<input   type="hidden" name="oldUserId" value="<c:out value="${requestScope.uname}"/>"/></td>
		</tr>
		<tr>
			<th>Password:</th><td><input   type="text" name="password" value="<c:out value="${requestScope.password}"/>" style="width:160px;"/>
			</td>
		</tr> 
		<tr>
			<th>Address: </th><td><input   type="text" name="address" value="<c:out value="${requestScope.registereduser.address}"/>" style="width:160px;"/></td>
		</tr>
		<tr>
			<th>Phone Number: </th><td><input   type="text" name="phone" value="<c:out value="${requestScope.registereduser.phone}"/>" style="width:160px;"/></td>
		</tr>
		<tr>
			<th>Email:</th><td><input   type="text" name="email" value="<c:out value="${requestScope.registereduser.email}"/>" style="width:160px;"/></td>
		</tr>
		
		
		</tbody>
		</table>
		<br/>
		
		<input type="submit" name="action"  value="Update registereduser" />
	
	</form>
	</c:if>
	
	<c:if test="${requestScope.CALLER!='Display Registered User'}">
		<table  align="center" frame="box" >
		<tbody>
		<tr>
			<th>Name: </th><td><c:out value="${requestScope.registereduser.name}"/></td>
		</tr>
		
		<tr>
			<th>Username(Id): </th><td> <c:out value="${requestScope.uname}"/> </td>
		</tr>
		<c:if test="${requestScope.CALLER!='Delete Registered User'}">
		<tr>
			<th>Password: </th><td><c:out value="${requestScope.password}"/> 
			</td>
		</tr> 
		</c:if>
		<tr>
			<th>Email: </th><td><c:out value="${requestScope.registereduser.email}"/></td>
		</tr>
		<tr>
			<th>Phone: </th><td><c:out value="${requestScope.registereduser.phone}"/></td>
		</tr>
		<tr>
			<th>Address: </th><td><c:out value="${requestScope.registereduser.address}"/> 
			</td>
		</tr>
		</tbody>
		</table>
		</c:if>
		<br/>
	<c:if test="${requestScope.Role=='Registered User'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/RegisteredUserHomePage.jsp'"/>
	</c:if>
	<c:if test="${requestScope.Role!='Registered User'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/AdminHomePage.jsp'"/>
	</c:if>
</div>
	</fieldset>
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>