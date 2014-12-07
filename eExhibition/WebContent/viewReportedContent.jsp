<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Reported Content</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body style="text-align:center;">
<%@ include file="bannerTop.jsp" %> 
<fieldset style="margin-left:50px;margin-right:50px">
<legend>
<h1 style="color:white;">All Reported Products</h1></legend>

<table border="1" align="center" style="color:white">
<tr>
<th>Select</th><th>Product Name</th><th>Details</th><th>Image</th><th>Price</th><th>Type</th><th>Exhibitor Name</th>
</tr>

<c:forEach items="${requestScope.products}" var="product">
	
	<form action="${pageContext.request.contextPath}/adminResponseManager" method="post">
		<tr>
		<%-- <th><c:out value="${product.key}"></c:out></th> --%>
		
		<th><input type="hidden" name="productid" value="<c:out value="${product.key}"></c:out>"/>
		<input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="producttitle" value="<c:out value="${product.value.getProductTitle()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc"   name="description" value="<c:out value="${product.value.getDescription()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="image" value="<c:out value="${product.value.getImage()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="price" value="<c:out value="${product.value.getPrice()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="type" value="<c:out value="${product.value.getType()}"></c:out>"/></th>
		<th><input type="text" size="8" onfocus="this.blur();" class="noedit abc" name="exhibitoruname" value="<c:out value="${product.value.exhibitorUname()}"></c:out>"/></th>
		<th><span style="cursor:pointer;" class="editbutton">Edit</span><input type="submit" style="display:none;" name="action" value="Update Product"/></th>
		<th><input type="submit" class="delBtn" name="action" value="Delete"/><span class="cancelbutton" style="cursor:pointer;display:none;">Cancel</span></th>
		</tr>
		
	</form>
	
</c:forEach>


</table>

	</fieldset>
<%@ include file="bannerBottom.jsp" %> 	
</body>
</html>
