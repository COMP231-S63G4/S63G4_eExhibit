<div>
	<form action="${pageContext.request.contextPath}/sideMenuManager"
		method="post">
		<div style="height: 25px;">
			<c:if test="${requestScope.notiStatus=='new'}">

				<img id="notificationIcon"
					src="${pageContext.request.contextPath}/images/notificationBlueIcon.png"
					width="25px" height="25px" />
			</c:if>
			<c:if test="${requestScope.notiStatus=='old'}">
				<img id="notificationIcon"
					src="${pageContext.request.contextPath}/images/notificationIcon.png"
					width="25px" height="25px" />
			</c:if>
			<img id="logoutIcon"
				src="${pageContext.request.contextPath}/images/logoutIcon.png"
				width="25px" height="25px" /> <input type="submit" id="btnSideMenu"
				style="display: none;" name="action" value="" />
		</div>
		<div id="notificationDiv"
			style="background-color: infobackground;position: absolute; right:50px; top: 30px; z-index: 2; display: none; border: 1px #000 solid;">

			<table id="notificationTable">
				<c:forEach items="${requestScope.topNotification}" var="notification">
					<tr>
						<td><c:out value="${notification.getNotification()}"></c:out></td>
						<td><c:out value="${notification.getDateInString()}"></c:out></td>
					</tr>
				</c:forEach>

			</table>


			<span id="notificationViewAll" style="cursor:pointer;"><b>ViewAll</b></span>



		</div>
		<script>
			$("#notificationIcon").click(
					function() {
						
						
						
						$("#notificationDiv").slideToggle();
				
								

					});
			
			$("#notificationViewAll").click(
					function() {

						$("#btnSideMenu").attr("value", "notificationIcon")
								.trigger("click");

					});
			$("#logoutIcon").click(function() {

				$("#btnSideMenu").attr("value", "logoutIcon").trigger("click");

			});
		</script>
	</form>
</div>