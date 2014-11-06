<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<div style="text-align:center">
	<h2>
		<c:choose>
		    <c:when test="${requestScope.CALLER=='Display Exhibitor'}">
		       Displaying Exhibitor Details!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Add Exhibitor'}">
		       Following Exhibitor has been added successfully!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Delete Exhibitor'}">
		       Following Exhibitor has been deleted from system!!!
		    </c:when>
		    <c:when test="${requestScope.CALLER=='Update Exhibitor'}">
		       Your Updated Exhibitor Details!!!
		    </c:when>
	    
		</c:choose>
	</h2>
	<br/>
	<c:if test="${requestScope.CALLER=='Display Exhibitor'}">
		<c:if test="${requestScope.Role=='Exhibitor'}">
		 <form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
		</c:if>
		<c:if test="${requestScope.Role!='Exhibitor'}">
		      <form action="${pageContext.request.contextPath}/adminResponseManager" method="post">
		  </c:if>
		 <table  align="center" frame="box" >
		<tbody>
		<tr>
			<th>Name: </th><td><input   type="text" name="name" value="<c:out value="${requestScope.exhibitor.name}"/>" style="width:160px;"/></td>
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
			<th>Address: </th><td><input   type="text" name="address" value="<c:out value="${requestScope.exhibitor.address}"/>" style="width:160px;"/></td>
		</tr>
		<tr>
			<th>Phone Number: </th><td><input   type="text" name="phone" value="<c:out value="${requestScope.exhibitor.phone}"/>" style="width:160px;"/></td>
		</tr>
		<tr>
			<th>Email:</th><td><input   type="text" name="email" value="<c:out value="${requestScope.exhibitor.email}"/>" style="width:160px;"/></td>
		</tr>
		
		
		</tbody>
		</table>
		<br/>
		
		<input type="submit" name="action"  value="Update Exhibitor" />
	
	</form>
	</c:if>
	
	<c:if test="${requestScope.CALLER!='Display Exhibitor'}">
		<table  align="center" frame="box" >
		<tbody>
		<tr>
			<th>Name: </th><td><c:out value="${requestScope.exhibitor.name}"/></td>
		</tr>
		
		<tr>
			<th>Username(Id): </th><td> <c:out value="${requestScope.uname}"/> </td>
		</tr>
		<c:if test="${requestScope.CALLER!='Delete Exhibitor'}">
		<tr>
			<th>Password: </th><td><c:out value="${requestScope.password}"/> 
			</td>
		</tr> 
		</c:if>
		<tr>
			<th>Email: </th><td><c:out value="${requestScope.exhibitor.email}"/></td>
		</tr>
		<tr>
			<th>Phone: </th><td><c:out value="${requestScope.exhibitor.phone}"/></td>
		</tr>
		<tr>
			<th>Address: </th><td><c:out value="${requestScope.exhibitor.address}"/> 
			</td>
		</tr>
		</tbody>
		</table>
		</c:if>
		<br/>
	<c:if test="${requestScope.Role=='Exhibitor'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/ExhibitorHomePage.jsp'"/>
	</c:if>
	<c:if test="${requestScope.Role!='Exhibitor'}">
	<input type="button" value="Go Back" onclick="window.location.href='/eExhibition/AdminHomePage.jsp'"/>
	</c:if>
</div>
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>