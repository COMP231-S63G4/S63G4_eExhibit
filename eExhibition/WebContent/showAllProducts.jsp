<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewEvents</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<style>
.noedit{
border: none;
background-color: rgb(106,107,89);

}

</style>
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>

</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<fieldset style="margin-left:50px;margin-right:50px">
<legend>
<h1 style="color:white;">All Product of Events </h1></legend>

<table border="1" align="center" style="color:white">
<tr>
<th>Image</th><th>Product Name</th><th>Description</th><th>Price</th><th>Seller Name</th>
</tr>

<c:forEach items="${requestScope.products}" var="product">
	
	<form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
		<tr>
		
		<td><image width="150" height="150" src="${pageContext.request.contextPath}/eimages/${product.getImage()}"/></td>
		<th><input type="hidden" name="productid" value="<c:out value="${product.getProductId()}"></c:out>"/>
		<input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="productname" value="<c:out value="${product.getProductTitle()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc"   name="details" value="<c:out value="${product.getDescription()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="price" value="<c:out value="${product.getPrice()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="exhibitorName" value="<c:out value="${product.getExhibitorUname()}"></c:out>"/></th>
		</tr>
		
		
	</form>
	
</c:forEach>


</table>

	
	
	
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>