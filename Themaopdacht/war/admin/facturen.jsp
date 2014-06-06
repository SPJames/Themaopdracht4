<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<div id="klus">
		<h2>Afgeronde klussen</h2>
		
		<div>
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
			}
		%>
		</div>
		
		<h2>pagina volgt...</h2>
	</div>
</body>
</html>