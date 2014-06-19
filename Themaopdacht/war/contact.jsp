<jsp:include page="header.jsp">
	<jsp:param name="title" value="Contact" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="home" value="home" />
	</jsp:include>

	<div id="Content">
		<h2>Contact</h2>
		<p>
			Ons adres:<br /> Utrecht Overvecht<br />Einsteindreef 44<br /> <br />
			Telefoonnummer: 035-1234567
		</p>
		<hr />
		<img src="/atd/images/map.png" alt="kaart" height="300"/>

	</div>
	<jsp:include page="footer.jsp" />
</body>
<html>