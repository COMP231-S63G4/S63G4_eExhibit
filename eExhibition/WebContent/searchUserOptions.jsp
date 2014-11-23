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
			<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
			
			<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jQueryui.js"></script>
			<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/jQueryui.css"/>
			 
	</head><!--end of head-->
			<body><!--starting of body-->
			<%@ include file="bannerTop.jsp" %> 
			
				<c:choose>
				    <c:when test="${requestScope.whoToSearch=='Exhibitor'}">
				       <h2>Search/View Exhibitors!!!</h2>
				       <form action="${pageContext.request.contextPath}/exhibitorResponseManager" method="post">
				    </c:when>
				    <c:when test="${requestScope.whoToSearch=='Organiser'}">
				        <h2>Search/View Organizers!!!</h2>
				        <form action="${pageContext.request.contextPath}/organiserResponseManager" method="post">
				    </c:when>
				    <c:otherwise>
				        <h2>Search/View Registered Users!!!</h2>				        
				        <form action="${pageContext.request.contextPath}/userResponseManager" method="post">
				  	</c:otherwise>		    
				</c:choose>		
					
			<div style="texh-align:center;">
							
				<table><tr><th>
					<c:choose>
					    <c:when test="${requestScope.whoToSearch=='Exhibitor'}">
					       To View All Exhibitors
					    </c:when>
					    <c:when test="${requestScope.whoToSearch=='Organiser'}">
					       To View All Organizers
					    </c:when>
					    <c:otherwise>
					       To View All Registered Users
					  	</c:otherwise>		    
					</c:choose>	
					</th>
					<td>
					<c:choose>
					    <c:when test="${requestScope.whoToSearch=='Exhibitor'}">
					      <input type="submit" name="action"  value="View Exhibitors" />
					    </c:when>
					    <c:when test="${requestScope.whoToSearch=='Organiser'}">
					      <input type="submit" name="action"  value="View Organizers" />
					    </c:when>
					    <c:otherwise>
					       <input type="submit" name="action"  value="View Registered Users" />
					  	</c:otherwise>		    
					</c:choose>	
										
					</td></tr>
				</table>
				<table>
				<tr><th>
					<c:choose>
					    <c:when test="${requestScope.whoToSearch=='Exhibitor'}">
					      Search Exhibitor by User Name
					    </c:when>
					    <c:when test="${requestScope.whoToSearch=='Organiser'}">
					       Search Organizer by User Name
					    </c:when>
					    <c:otherwise>
					       Search Registered by User Name
					  	</c:otherwise>		    
					</c:choose>	
					</th>
					<td>
					<input type="text" id="tags" name="unameSearchTBox"/>
					<c:choose>
					    <c:when test="${requestScope.whoToSearch=='Exhibitor'}">
					      <input type="submit"  name="action"  value="Search" />
					    </c:when>
					    <c:when test="${requestScope.whoToSearch=='Organiser'}">
					      <input type="submit"  name="action"  value="Search" />
					    </c:when>
					    <c:otherwise>
					       <input type="submit"  name="action"  value="Search" />
					  	</c:otherwise>		    
					</c:choose>	
										
					</td></tr>
				</table>
				<table></table>
			
			</div>	
			</form>		  
        <script>
		  $(function() {
			  var availableTags =("${requestScope.unames}").split(",");
			  //var items=data.split("\n");
		    $("#tags").autocomplete({
		      source: availableTags
		    });
		  });
		  </script>
			 <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							