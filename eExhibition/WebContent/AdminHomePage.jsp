<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    
    <title>AdminHomePage</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
	<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
	<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
	<style type="text/css">
		input.addOrganiser{
			background-image:url(${pageContext.request.contextPath}/images/addOrganiser.png);
			width:100px;
			height:100px;
			border:0;
		}
		input.viewOrganisers{
			background-image:url(${pageContext.request.contextPath}/images/viewOrganisers.png);
			width:100px;
			height:100px;
			border:0;
		}
	</style>
	
	<script>
		$(document).ready(function(){
		
			$("#changeAdminDetails").click(function(){
				$("#adminDetailDiv").slideToggle();
				});
		});
	</script>
  </head>
  
  <body style="text-align:center;">
  <%@ include file="bannerTop.jsp" %> 
    Welcome Admin !!!<br>
    <c:if test="${requestScope.passChanged!='' || requestScope.passChanged!=null}">
		        <div style="color:red;position:absolute;right:40px;top:10px;z-index: 1;"><c:out value="${requestScope.passChanged}"></c:out></div>
		    </c:if>
   
    <img src="${pageContext.request.contextPath}/images/settingIcon.png" id="changeAdminDetails"
    style="position:absolute;right:5px;top:8px;width:25px;height:25px;"/>
    
    <form action="${pageContext.request.contextPath}/adminResponseManager" method="post">
    
    <div id="adminDetailDiv" style="position:absolute;right:22px;top:28px;z-index:2;display:none;border:1px #000 solid;">
	   
	    <input type="text" name="changedUname" placeholder="New UserName"></input>
	    <br/><br/>
	    <input type="text" name="changedPassword" placeholder="New Password"></input>
	    <br/><br/>
	    
	   
	    <input type="Submit" name="action" value="Update Details">
	    
    
    
    </div>
   
	    <table align="center">
		    <tr>
		    <td><input  class="addOrganiser" value="">
		    <br/><input type="Submit" name="action"  value="Add Organiser"/></td>
		    <td><input   class="viewOrganisers" value="">
		    <br/><input type="Submit" name="action"  value="View Organizers"/></td>
		    </tr>
	    </table>
	    
    </form>
    <%@ include file="bannerBottom.jsp" %> 
  </body>
</html>
