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
					 <script>
						$("#contactUsPage").addClass("current");
</script>
					<div id="ContactLeft">
                      <fieldset>
    <legend>
    <h2 style="color:#99CC66">Contact Us</h2></legend>
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
 <td >
  <label for="comments">Comments :</label>
 </td>
 <td >
  <textarea  name="comments" maxlength="1000" cols="25" rows="6"></textarea>
 </td>
 
</tr>
<tr>
 <td colspan="2" style="text-align:center">
  <input type="submit" value="Submit">   
 </td>
</tr>
</table>
                          </fieldset>
				    </div>
                   	
                    <div id="ContactRight">
                        <form id="ContactForm1">
				
					 CONTACT US ON :<br/> <br/>4167789675<br/><br/>
					 
					 EMAIL :<br/><br/>
					 contact@eexhibition.me
                            </form>
					</div>
         
          
				    <%@ include file="bannerBottom.jsp" %> 	
		</div> <!-- end of container -->
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							