<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Gallery</title>
			<link href="${pageContext.request.contextPath}/styles/stylesheet.css" rel="stylesheet" type="text/css" />
			<script type="text/javascript" src="${pageContext.request.contextPath}/jQuery.js"></script>
			<script src="${pageContext.request.contextPath}/javascripts/javascript.js"></script>
	</head><!--end of head-->
			<body><!--starting of body-->
					<%@ include file="bannerTop.jsp" %> 
							<div id="content_area1">
							<div class="bottom_panel_section">
									<div class="news_section">
									
									
									<div id="wrapper">
        <div id="zoom-slider">
            <img src="images/g1.jpg" alt="" />
            <img src="images/g2.jpg" alt="" />
            
                <img src="images/g5.jpg" alt="" /></a>
            <img src="images/g4.jpg" alt="" />
			<img src="images/g6.jpg" alt="" />
            <img src="images/g7.jpg" alt="" />
           
                <img src="images/g8.jpg" alt="" /></a>
            <img src="images/g9.jpg" alt="" />
			 <img src="images/g10.jpg" alt="" />
			 <img src="images/g11.jpg" alt="" />
			<img src="images/g12.jpg" alt="" />
            <img src="images/g13.jpg" alt="" />
           
                <img src="images/g8.jpg" alt="" /></a>
            <img src="images/g14.jpg" alt="" />
			 <img src="images/g15.jpg" alt="" />
        </div>
        <!--The following are custom navigation buttons-->
        <div style="width:840px;background:black;padding: 4px 8px 8px 12px; border-radius:0 0 6px 6px; text-align:right;">
            <div style="float:left;">
                <a onclick="zoomSlider.previous()" class="navPrev"></a>
                <a id='auto' onclick="switchAutoAdvance()"></a>
                <a onclick="zoomSlider.next()" class="navNext"></a>
            </div>
            <span id="thumbs">
                <span><img src="images/g1C.jpg" /></span>
                <span><img src="images/g2C.jpg" /></span>
                <span><img src="images/g4C.jpg" /></span>
                <span><img src="images/g5C.jpg" /></span>
				<span><img src="images/g6C.jpg" /></span>
				<span><img src="images/g7C.jpg" /></span>
				 <span><img src="images/g8C.jpg" /></span>
                <span><img src="images/g9C.jpg" /></span>
                <span><img src="images/g10C.jpg" /></span>
                <span><img src="images/g11C.jpg" /></span>
				<span><img src="images/g12C.jpg" /></span>
				<span><img src="images/g13C.jpg" /></span>
				<span><img src="images/g14C.jpg" /></span>
				 <span><img src="images/g15C.jpg" /></span>
                
                
            </span>
        </div>
        <!--The following are HTML captions-->
        <div id="htmlcaption1" style="display: none;">
            <span style="color:#09F;font-size:20px;"></span> 
        </div> 
        <div id="htmlcaption2" style="display: none;">
            <strong style="color:#C90;"></strong>
        </div> 
    </div>
    <br />
    <br />
    <br />
    <p class="nav"> <a href="demo2.html"></a></p>
    <script type="text/javascript">
        //The following script is for custom navigation buttons.
        function switchAutoAdvance() {
            zoomSlider.switchAuto();
            switchPlayPauseClass();
        }
        function switchPlayPauseClass() {
            var auto = document.getElementById('auto');
            if (auto) {
                var isAutoPlay = zoomSlider.getAuto();
                auto.className = isAutoPlay ? "navPause" : "navPlay";
                auto.title = isAutoPlay ? "Pause" : "Play";
            }
        }
        switchPlayPauseClass();


        //Change the captionEffect. It is recommended to set { captionEffect: "fade" } directly through the zoomSliderOptions in the javascript file instead of using the approach below
        zoomSlider.changeOptions({ captionEffect: "fade" });

    </script>
					


									</div>
							</div> 
							  
        
								<div class="cleaner_h20">&nbsp;</div>  
          
				    </div> <!-- end of content_area1-->
    
					
							  
        
								 <%@ include file="bannerBottom.jsp" %> 	
     </body><!--end of body-->
</html><!--end of html-->
		 
                

			
							
