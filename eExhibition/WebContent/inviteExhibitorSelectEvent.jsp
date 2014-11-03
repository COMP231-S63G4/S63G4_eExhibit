<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>My JSP 'RegisteredUserHomePage.jsp' starting page</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>

  </head>
  
  <body style="text-align: center;">
  <%@ include file="bannerTop.jsp" %>
  <form action="${pageContext.request.contextPath}/organiserResponseManager"  method="post">
  <table align="center" frame="box">
  <tr >
  <td colspan="2">Invite exhibitors for event: </td>
  </tr>
  <tr>
  <td>
  
	 <select name="events">
				<c:forEach items="${requestScope.events}" var="event">
					<option value="${event.key}"><c:out value="${event.value.eventName}"></c:out></option>
				</c:forEach>
			</select>
			
	</td>
	<td><input type="submit" name="action" value="OK"/> </td>
  </tr>
  </table>
  </form>
  
   <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
