

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>eExibition - Home Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body style="background-color: #dddddd">
		<div style="text-align: center">
			<h2>---Welcome to eExibition.com ---</h2>
			<br/>
			<br/>
			<div style="border:5px #000000 solid;width:300px;position:absolute;left:38%;background-color: #f1dddd">
			<br/>
				<form id="form1" name="form1" action="${pageContext.request.contextPath}/loginServlet" method="post" >
					<br/>
					<span style="color: red;">User Name: </span>
					 <input type="text" name="name" />
					<br/>
					<br/>
					<span style="color: red;">Password&nbsp;:&nbsp;&nbsp; </span>
					<input type="password" name="pass" />
					<br/>
					<br/>
					<input type="submit" name="login"  value="log in" />
					
				</form>
				<br/>
			</div>
		</div>
	</body>
</html>

 