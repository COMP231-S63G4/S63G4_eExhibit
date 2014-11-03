<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"/></script>
<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
<style type="text/css">
	.noBorder
	{
		border:none;
	}
</style>
<script>
	$(document).ready(function(){
		  $("#autoGenerate").click(function(){
			  if($("#name").val().trim()==""||$("#address").val().trim()==""||
					  $("#phone").val().trim()==""||$("#email").val().trim()=="")
			  {
			  	alert("Please provide all above details to autogenerate username and password");
			  }
			  else{
				  var size=($("#name").val()).length;
				  size=(size>3)?4:size>2?3:size>1?2:1;
				var username=($("#name").val().trim()).substr(0,size)+
							($("#email").val().replace(/\./g,'').replace(/\@/g,'').trim()).substr(0,3)
							+Math.ceil(Math.random()*1000000);
				var password=($("#email").val().replace(/\./g,'').replace(/\@/g,'').trim()).substr(0,3)+$("#phone").val().trim().replace(/\ /g,'').replace(/\+/g,'').substr(0,5)+$("#name").val().trim().substr(0,size)
					+Math.ceil(Math.random()*100);
				$("#uname").val(username);
				$("#password").val(password);
			}
		   
		  });
	});
</script>

</head>
<body>
 <%@ include file="bannerTop.jsp" %> 
 

<div style="text-align: left;margin-left:100px;margin-right:100px">

<fieldset>
<legend>
<h1 style="color:white;">Create Account</h1></legend>

<form action="${pageContext.request.contextPath}/RegistrationManager"  method="post">
<br>
<br>
<img src="${pageContext.request.contextPath}/images/registerPic.jpg" width="300px" height="425px" style="margin-left: 50px"/>
	<table align="left" style="font-size: 20px;color:white" >
	
		<tr>
			<th> &nbsp;</th>
			<td>&nbsp;</td>
		</tr>
		
		<tr>
		
			<th>Name: </th>
			<td><input  type="text" id="name" name="name" placeholder="Exhibitor Name" style="width:160px;"/></td>
		</tr>
		<tr>
		<tr>
		
			<th>Address: </th>
			<td><input  type="text" id="address" name="address" placeholder="Address" style="width:160px;"/></td>
		</tr>
		<tr>
		<tr>
		
			<th>Phone Number: </th>
			<td><input  type="text" id="phone" name="phone" placeholder="Phone Number" style="width:160px;"/></td>
		</tr>
		<tr>
		<tr>
		
			<th>Email: </th>
			<td><input  type="text" id="email" name="email" placeholder="Email" style="width:160px;"/></td>
		</tr>
		<tr>
		
			<th>Type: </th>
			<td>
			<select style="width:160px;" name="role">
			  <option >--Select--</option>
			  <option value="rusr">Registered User</option>
			  <option value="exbt">Exhibitor</option>
			  
			</select>
			</td>
		</tr>
		<tr>
		<tr><td colspan="2" align="right"> <input type="button" id="autoGenerate"  value="Auto Generate Username&Password" /></td></tr>
	
		<tr>
		
			<th>UserName(Id): </th>
			<td><input  type="text" id="uname" name="uname" placeholder="Username" style="width:160px;"/></td>
		</tr>
		<tr>
		<tr>
		
			<th>Password: </th>
			<td><input  type="text" id="password" name="password" placeholder="Password" style="width:160px;"/></td>
		</tr>
		<tr>
	
	
	<tr><td colspan="2" align="center"><input type="submit" name="action" value="Register" style="margin-left:65px"/></td></tr>
	
	</table>
	</form>
	<br/>
	</fieldset>
	</div>
	
	 <%@ include file="bannerBottom.jsp" %> 		
</body>
</html>