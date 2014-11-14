<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      
    <title>ViewUsers</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>

  </head>
  
  <body style="text-align: center;">
  <%@ include file="bannerTop.jsp" %>
  <fieldset style="margin-left:150px;margin-right:150px ;">
<legend>

  <h1 style="color:white">All Registered Users </h1></legend>
  
  <form action="${pageContext.request.contextPath}/organiserResponseManager"  method="post">
  
  <table align="center" frame="box" style="color:white">
  <tr>
  <td></td><th colspan="4">User Details</th>
  </tr>
  <tr >
    <th>Select</th><th>UserId</th><th>Name</th><th>Email</th><th>Phone Number</th>
  </tr>
  <c:forEach items="${requestScope.exhibitors}" var="user">
  <tr>
	  	<td>  
		 		<input type="checkbox" name="userIds" value="${user.value.getUserId()}" />
		 					
		</td>
		<td> <c:out value="${user.value.getUserId()}"></c:out></td>
		<td> <c:out value="${user.value.getName()}"></c:out></td>
		<td> <c:out value="${user.value.getEmail()}"></c:out></td>
		<td> <c:out value="${user.value.getPhone()}"></c:out></td>
		
  </tr>
  </c:forEach>
  <tr>
  <td></td><th colspan="4"><input type="submit" name="action" value="Select"/></th>
  </tr>
  </table>
 
  </form>
   </fieldset>
   <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
