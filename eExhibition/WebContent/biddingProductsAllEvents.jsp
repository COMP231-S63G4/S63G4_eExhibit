<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Services</title>
			<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
			<script src="${pageContext.request.contextPath}/javascripts/javascript.js"></script>
			
	</head><!--end of head-->
			<body><!--starting of body-->
			<%@ include file="bannerTop.jsp" %> 
			<div>
				<c:forEach items="${requestScope.bidproduct}" var="bidMap">
					<div>
						<%-- <input type="hidden" value="<c:out value="${bidMap.key}"></c:out>"/> --%>						
						<span>Event Id: <c:out value="${bidMap.key}"></c:out></span>
						<br/>
						
						<c:forEach items="${bidMap.value}" var="bidProduct">
							<div>
							<form action="${pageContext.request.contextPath}/registeredUserResponseManager"  method="post">
								<span>Product Name: <c:out value="${bidProduct.getProduct().getProductTitle()}"></c:out></span> 
								<span>Start Date: <c:out value="${bidProduct.getStartDate()}"></c:out></span>
								 <span>End Date: <c:out value="${bidProduct.getEndDate()}"></c:out></span>
								<br/>
								<span>Start Price: <c:out value="${bidProduct.getStartPrice()}"></c:out> </span> 
								<span>Close Price: <c:out value="${bidProduct.getClosePrice()}"></c:out></span>
								<br/>
								<br/>
								<h3>Top 3 bidder Details</h3>
								<span>1. User Name: <c:out value="${bidProduct.getUser().getName()}"></c:out></span> 
								<span>Price: <c:out value="${bidProduct.getClosePrice()}"></c:out></span>
								
								<span>2. User Name: <c:out value="${bidProduct.getUser2().getName()}"></c:out></span> 
								<span>Price: <c:out value="${bidProduct.getTopPrice2()}"></c:out></span>
								<span>3. User Name: <c:out value="${bidProduct.getUser3().getName()}"></c:out></span> 
								<span>Price: <c:out value="${bidProduct.getTopPrice3()}"></c:out></span>
								<input type="hidden" name="topPrice" value="<c:out value="${bidProduct.getClosePrice()}"></c:out>"/>
								<input type="hidden" name="eventid" value="<c:out value="${bidMap.key}"></c:out>"/>
								<input type="hidden" name="productid" value="<c:out value="${bidProduct.getProduct().getProductId()}"></c:out>"/>
								
								<input type="text" name="bidValue"/>
								<input type="submit" name="action" value="My Bid"/>
								
								</form>
							</div>
						</c:forEach>
					
					
					</div>
				</c:forEach>
			</div>
			<%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							