<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Auto Toevoegen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="menu.jsp" />
	<%!String id = "";%>
	<%
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("C_ID")) {
					id = c.getValue();
					break;
				}
			}
		}
	%>

	<h2>Auto Toevoegen</h2>
	<form action="RegisterAutoServlet.do" method="get">
		<fieldset>
			<input type="hidden" name="klantid" value="<%=id%>" /> <label
				for="Merk">Merk</label><input type="text" name="Merk"
				placeholder="merk" class="box" /> <label for="Kenteken">Kenteken</label><input
				type="text" name="Kenteken" placeholder="1-AAA-11" class="box" />
		</fieldset>
	</form>
</body>
<html>