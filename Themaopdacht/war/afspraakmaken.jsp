<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Afspraak maken" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="menu.jsp">
	<jsp:param name="name" value="Home" />
</jsp:include>
<div id="register">
	<h2>Afspraak maken</h2>
	<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
		</div>
		<%@ page import="klantenbinding.Auto" %>
		<%@ page import="java.util.ArrayList"%>
		
		<%
		String id = "";
		String name = "";
		id = "" + (int) session.getAttribute("ID");
		name = (String) session.getAttribute("Username"); 
		%>

	<form action="KlusAanmakenServlet.do" method="get">
		<input type="hidden" name="klantid" value="<%= id %>" />
		<input type="hidden" name="name" value="<%= name %>" />
		
		<!-- Auto -->
		<select name="auto">
			<% 
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) application.getAttribute("allAutos");
			if (Autos.size() > 0) {
				for (Auto a : Autos) {
					if (a.getKlantid().equals(id) && !a.isInReparatie()) { %>
					
						<option value="<%= a.getKenteken() %>"><%= a.getKenteken() %></option>
					
					<%}
				}
			}
			%>
		</select>
		
		<!-- diensttype -->
		<select name="diensttype">
			<option value="rep">Reparatie/Onderhoud/APK</option>
			<option value="park">Parkeren</option>
			<option value="tank">Tanken</option>
		</select>
		<!-- beschrijving klus -->
		<textarea rows="10" cols="50" name="comments"></textarea>
		<input type="submit" value="Verzenden" />
	</form>
</div>
</body>
</html>