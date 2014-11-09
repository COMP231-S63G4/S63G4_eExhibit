<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>SelectEventForParticipation</title>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>

  </head>
  
  <body style="text-align: center;">
  <%@ include file="bannerTop.jsp" %>
  <fieldset style="margin-left:150px;margin-right:150px">
<legend>
<h1 style="color:white;">Event Participation Form</h1></legend>
  <form action="${pageContext.request.contextPath}/exhibitorResponseManager"  method="post">
  <table align="center" frame="box" style="color:white">
  <tr >
  <td colspan="2">Choose events for participation: </td>
  </tr>
  <tr>
  <td>
  
	 <select name="events">
				<c:forEach items="${requestScope.events}" var="event">
					<option value="${event.key}"><c:out value="${event.value.getEventName()}"></c:out></option>
				</c:forEach>
			</select>
			
	</td>
	<td><input type="submit" name="action" value="Participate"/> </td>
  </tr>
  </table>
  <c:if test="${requestScope.Role=='Exhibitor'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/ExhibitorHomePage.jsp'"/>
	</c:if>
  </form>
  </fieldset>
  
   <%@ include file="bannerBottom.jsp" %> 	
  </body>
</html>
