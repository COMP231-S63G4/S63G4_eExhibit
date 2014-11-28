<div>
  <form action="${pageContext.request.contextPath}/sideMenuManager" method="post">
	 <img id="notificationIcon" src="${pageContext.request.contextPath}/images/notificationIcon.png" width="200px" height="95px"/>
	 <c:if test="${requestScope.notiStatus="new"}">
	  <img id="notificationIcon" src="${pageContext.request.contextPath}/images/notificationBlueIcon.png" width="200px" height="95px"/>
	</c:if>
	 <c:if test="${requestScope.notiStatus="old"}">
	 <img id="notificationIcon" src="${pageContext.request.contextPath}/images/notificationIcon.png" width="200px" height="95px"/>
	</c:if>
	  <img id="logoutIcon" src="${pageContext.request.contextPath}/images/logoutIcon.png" width="200px" height="95px"/>
	 <input type="submit" id="btnSideMenu" style="visibility: none;" name="action" value=""/>
	 <script>
		$("#notificationIcon").click(function(){			
			
			$("#btnSideMenu").attr("value","notificationIcon").trigger("click");
			
			});
		$("#logoutIcon").click(function(){			
			
			$("#btnSideMenu").attr("value","logoutIcon").trigger("click");
			
			});
		
	 </script>
</form>
</div>