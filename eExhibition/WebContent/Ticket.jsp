<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ContactUs</title>
        <link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" />
			
			<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
			<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
	</head><!--end of head-->
			<body><!--starting of body-->
					 <%@ include file="bannerTop.jsp" %> 
					<div id="ContactLeft">
                      <fieldset>
    <legend>
     <h2 style="color:#99CC66">Buy tickets:</h2></legend>
                        <table id="ContactForm" >

<tr>
 <td >
  <label for="first_name">First Name :</label>
 </td>
 <td >
  <input  type="text" name="first_name" maxlength="50" size="30">
 </td>
</tr>
  
<tr>
 <td ">
  <label for="last_name">Last Name : </label>
 </td>
 <td >
  <input  type="text" name="last_name" maxlength="50" size="30">
 </td>
</tr>
<tr>
 <td >
  <label for="email">Email : </label>
 </td>
 <td >
  <input  type="text" name="email" maxlength="80" size="30">
 </td>
 
</tr>
<tr>
 <td >
  <label for="telephone">Phone : </label>
 </td>
 <td >
  <input  type="text" name="telephone" maxlength="30" size="30">
 </td>
</tr>
<tr>
 <td ">
  <label for="last_name">Event Name : </label>
 </td>
 <td >
  <input  type="text" name="last_name" maxlength="50" size="30">
 </td>
</tr>

<tr>
 <td ">
  <label for="last_name">Event Date : </label>
 </td>
 <td >
  <input  type="text" name="last_name" maxlength="50" size="30">
 </td>
</tr>
<tr>
 <td ">
  <label for="last_name">Event Time : </label>
 </td>
 <td >
  <input  type="text" name="last_name" maxlength="50" size="30">
 </td>
</tr>
<tr>
 <td colspan="2" style="text-align:center">
  <input type="submit" value="Pay Now">   
 </td>
</tr>
</table>
                          </fieldset>
				    </div>
					
							  
        
								<div class="cleaner_h20">&nbsp;</div>  
          
				    </div> <!-- end of content_area1-->
				    
				    
				    <%@ include file="bannerBottom.jsp" %> 	
		</div> <!-- end of container -->
     </body><!--end of body-->
</html><!--end of html-->
		 
