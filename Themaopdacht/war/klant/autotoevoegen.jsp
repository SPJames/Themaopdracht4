<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Auto Toevoegen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%
		int id = (Integer) session.getAttribute("ID");
	%>
	<div id="register">
		<h2>Auto Toevoegen</h2>

		<jsp:include page="../message.jsp" />

		<form action="RegistreerAutoServlet.do" method="post">
			<fieldset>
				<input type="hidden" name="klantid" value="<%=id%>" /> 
				<label for="Merk">Merk</label> <input type="text" name="merk"
					placeholder="Merk" class="box" /> <label for="Kenteken">Kenteken</label>
				<input type="text" name="kenteken" placeholder="1-AAA-11"
					class="box" /> <input type="submit" value="Toevoegen" class="down" />
			</fieldset>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<html>