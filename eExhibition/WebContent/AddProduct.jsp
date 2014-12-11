<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
</head>
<body>

<body>
<%@ include file="bannerTop.jsp" %> 
					<div style="test-align:center">
						
						<table frame="box" align="center">
						<tr><td>
						
						<form  action="${pageContext.request.contextPath}/eventResponseManager" method="post" >
							<br/>
							Add New Product :<br/><br/>
							
							
							<span style="color: black;">Product Title :&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</span>
							<input type="text" name="producttitle" />
							<br/>
							<br/>
							Product Description :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 
                            <textarea  name="description" maxlength="1000" cols="26"rows="6"></textarea>
                             <br/>
							<br/>
                             
                             <span style="color: black;">Image :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="image" />
							<br/>
							<br/>
							<span style="color: black;">Price :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="price" />
							<br/>
							<br/>
							<span style="color: black;">Type :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<select style="width:160px;" name="role">
								  <option >--Select--</option>
								  <option value="Bid">Registered User</option>
								  <option value="Sale">Exhibitor</option>
			  
							</select>
							<br/>
							<br/>
							
							<input type="submit" name="action"  value="Add Product" />
						
						</form>
						</td></tr>
						</table>
					</div>
			 <%@ include file="bannerBottom.jsp" %> 		

</body>
</html>
