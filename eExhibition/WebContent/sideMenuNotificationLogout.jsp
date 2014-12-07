<div>
	<form action="${pageContext.request.contextPath}/sideMenuManager"
		method="post">
		<div style="height:25px;">
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
		<script>
			$("#notificationIcon").click(
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