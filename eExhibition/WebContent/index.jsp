<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-Exhibition</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
	</head><!--end of head-->

	<body>
	<%@ include file="bannerTop.jsp" %> 
	 <script>
						$("#homePage").addClass("current");
</script>
			    <div id="leftside">
			            <div id="slider">
					    <a href="#" class="control_next"></a>
					    <a href="#" class="control_prev"></a>
						    <ul>				 
							    <li><img src="${pageContext.request.contextPath}/images/16.jpg"></li>
                                <li><img src="${pageContext.request.contextPath}/images/12.jpg"></li>
							    <li><a href="page2.html"><img src="${pageContext.request.contextPath}/images/14.jpg"></a></li>
							    <li ><a href="page2.html"><img src="${pageContext.request.contextPath}/images/15.jpg"></a></li>
							    <li ><a href="page2.html"><img src="${pageContext.request.contextPath}/images/16.jpg"></a></li>
							   </ul>   
					</div>			
				</div>
                <div id="rightside">
					  <form  action="${pageContext.request.contextPath}/loginServlet" method="post" >
					 <br /><br />
					 <h4 style="color: red;">
	
						<c:out value="${requestScope.indexMessage}"/>
						</h4>
                     
                         <h2 style="color:#99CC66">Log in</h2>
					     <br /><br />

					     Username:&nbsp; <input type="text" name="name" />
                         <br><br>
					     Password:&nbsp;  <input type="password" name="pass"  /> 
					     <br/></br>
					     <input type="submit" name="login"  value="Take In" style="width: 75px; margin-left: 111px" />
                         <br /><br />
                     
					 </form>
					 
					 
				</div> 
				
             <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->

			
							



 