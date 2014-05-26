<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Auto Toevoegen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="menu.jsp">
	<jsp:param name="name" value="Home" />
</jsp:include>
	<%!int id = 0;%>
	<%
		id = (int)session.getAttribute("ID");
	%>
<div id="register">
	<h2>Auto Toevoegen</h2>
	
	<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
	</div>
	
	<form action="RegisterAutoServlet.do" method="get">
		<fieldset>
			<input type="hidden" name="klantid" value="<%=id%>" /> 
			
			<label for="Merk">Merk</label>
			<input type="text" name="Merk" placeholder="merk" class="box" /> 
			
			<label for="Kenteken">Kenteken</label>
			<input type="text" name="Kenteken" placeholder="1-AAA-11" class="box" />
			
			<input type="submit" value="Toevoegen" class="down" />
		</fieldset>
	</form>
</div>
</body>
<html>