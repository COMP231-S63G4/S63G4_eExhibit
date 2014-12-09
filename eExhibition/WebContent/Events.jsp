<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Events</title>
			<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
			<script src="${pageContext.request.contextPath}/javascript/javascript.js"></script>
			<link href="${pageContext.request.contextPath}/styles/js-image-slider.css" rel="stylesheet" type="text/css" />
			 <script src="${pageContext.request.contextPath}/javascript/js-image-slider.js" type="text/javascript"></script>
              <link href="${pageContext.request.contextPath}/styles/generic.css" rel="stylesheet" type="text/css" />
	</head><!--end of head-->
			<body><!--starting of body-->
				<%@ include file="bannerTop.jsp" %> 
						<script>
						$("#eventsPage").addClass("current");
</script>	
		
    <div id="sliderFrame">
        <div id="slider">
            <a href="index.html" target="_blank">
                <img src="${pageContext.request.contextPath}/images/image-slider-1.jpg" alt="Beauty Exhibition" />
            </a>
            <img src="${pageContext.request.contextPath}/images/image-slider-2.jpg" alt="Gaming Exhibition" />
            <img src="${pageContext.request.contextPath}/images/image-slider-3.jpg" alt=" Exhibition" />
            <img src="${pageContext.request.contextPath}/images/image-slider-4.jpg" alt="Photo Exhibition" />
            <img src="${pageContext.request.contextPath}/images/image-slider-5.jpg" alt="Art Exhibition"/>
        </div>
		</div>
		
		

								 <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							