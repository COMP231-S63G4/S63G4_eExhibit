<html> <!--starting of html-->
	<head><!--starting of head-->
		<title>eExhibition</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
		
		<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
			
              
        
	</head><!--end of head-->

	<body>
	<div id="container">

	    <div id="header">
	    <div id="title">oNLiNE eXhIbItiOn</div>
	    </div> 
        
        <div id="banner">

            <marquee  behavior="alternate"  >
                                  <img src="${pageContext.request.contextPath}/images/12.jpg" width="200px" height="95px"/>
                                 <img src="${pageContext.request.contextPath}/images/14.jpg"  width="200px" height="95px"/>
                                 <img src="${pageContext.request.contextPath}/images/15.jpg"  width="200px" height="95px"/>
                                 <img src="${pageContext.request.contextPath}/images/16.jpg"  width="200px" height="95px"/>
                                  <img src="${pageContext.request.contextPath}/images/1.jpg"  width="200px" height="95px"/>
                                  <img src="${pageContext.request.contextPath}/images/aboutUsPic.jpg"  width="200px" height="95px"/>
                                  <img src="${pageContext.request.contextPath}/images/13.jpg"  width="200px" height="95px"/> 
                             </marquee>
        </div>
		    <div id="menu">
			    <ul>
				    <li><a class="current"  href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
				    <li><a href="${pageContext.request.contextPath}/AboutUs.jsp">About us</a></li>
				    <li><a  href="${pageContext.request.contextPath}/Gallery.jsp">Gallery</a></li>
				    <li><a  href="${pageContext.request.contextPath}/Services.jsp">Services</a></li>
				    <li><a  href="${pageContext.request.contextPath}/Events.jsp">Events</a></li>
				    <li><a  href="${pageContext.request.contextPath}/ContactUs.jsp">Contact Us</a></li>
			        <li><a  href="${pageContext.request.contextPath}/SignUp.jsp">Sign Up</a></li>
			    </ul>
    
		    </div> 
  
            <div id="content_area1">
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
					 
                     
                         <h2 style="color:#99CC66">Entry Point</h2>
					     <br /><br />

					     Username:&nbsp; <input type="text" name="name" />
                        <!-- <br><br>
					     Password:&nbsp;  <input type="password" name="pass"  /> -->
					     <br/><br/>
					     <input type="submit" name="login"  value="Take In" style="width: 75px; margin-left: 111px" />
                         <br /><br />
                     
					 </form>
					 
					 
				</div> 
				
            </div> <!-- end of content_area1-->
    
			<div id="footer">    
				Copyright © 2014 <strong>eExhibition</strong>
			</div> <!-- end of footer -->
    
		</div> <!-- end of container -->
     </body><!--end of body-->
</html><!--end of html-->

			
							



 