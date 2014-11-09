<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>InviteExhibitorSelectEvent</title>
    
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
