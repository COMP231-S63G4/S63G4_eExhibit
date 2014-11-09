<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddEvent</title>
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
						
						<form  action="${pageContext.request.contextPath}/loginServlet" method="post" >
							<br/>
							EVENT FORM :<br/><br/>
							<span style="color: black;">Event Id: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
							 <input type="text" name="name" />
							<br/>
							<br/>
							<span style="color: black;">Event Name :&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</span>
							<input type="text" name="Ename" />
							<br/>
							<br/>
							
							 <label for="comments">Events details :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
 
                            <textarea  name="comments" maxlength="1000" cols="16"rows="6"></textarea>
                             </br>
                             </br>
                             
                             <span style="color: black;">Event Location :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="ELocation" />
							<br/>
							<br/>
							<span style="color: black;">Start Date :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="Sdete" />
							<br/>
							<br/>
							<span style="color: black;">End Date :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="Edate" />
							<br/>
							<br/>
							<span style="color: black;">Event Organizers :&nbsp; </span>
							<input type="Text" name="OrgName" />
							<br/>
							<br/>
							<input type="submit" name="submit"  value="log in" />
						
						</form>
						</td></tr>
						</table>
					</div>
			 <%@ include file="bannerBottom.jsp" %> 		

</body>
</html>
