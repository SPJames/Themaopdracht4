<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Index" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="menu.jsp" />
	
	<div id="Content"><p>Welkom bij <b>AutoTotaalDiensten!</b></p>
	<!-- openstaande klussen van klant, zodat hij/zij voortgang kan volgen-->
 	</div>
 	
 	<%
		Object plek = request.getAttribute("plek");
	
		if((plek != null) && ((int) plek > 0)) {%>
			<script type="text/javascript">alert("De klus is geregistreerd! Uw plek is <%= plek %>");</script>
		<%}
	%>
</body>
<html>