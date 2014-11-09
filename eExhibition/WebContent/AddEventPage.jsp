<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eehibition</title>
</head>
<body>

<body>
					<div style="test-align:center">
						<h2>Welcome to Online Exhibition</h2>
						<table frame="box" align="center">
						<tr><td>
						
						<form  action="${pageContext.request.contextPath}/loginServlet" method="post" >
							<br/>
							EVENT FORM :<br/><br/>
							
							<span style="color: black;">Event Name :&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;</span>
							<input type="text" name="eventname" />
							<br/>
							<br/>
							
							 <label for="comments"> Event details :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
 
                            <textarea  name="details" maxlength="1000" cols="16"rows="6"></textarea>
                             </br>
                             </br>
                             
                             span style="color: black;">Event Location :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="location" />
							<br/>
							<br/>
							<span style="color: black;">Start Date :&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="startdate" />
							<br/>
							<br/>
							<span style="color: black;">End Date :&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>
							<input type="Text" name="enddate" />
							<br/>
							<br/>
							<span style="color: black;">Event Organizers :&nbsp; </span>
							<input type="Text" name="Orgnisers" />
							<br/>
							<br/>
							<input type="submit" name="submit"  value="log in" />
						
						</form>
						</td></tr>
						</table>
					</div>
				

</body>
</html>
