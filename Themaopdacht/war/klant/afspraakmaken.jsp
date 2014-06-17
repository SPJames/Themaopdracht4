<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Afspraak maken" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="register">
		<h2>Afspraak maken</h2>
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
			%>
			<div id="msgs">
				<%
					out.println(msgs);
				%>
			</div>
			<%
				}
			%>
		</div>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="domein.klantenbinding.Auto"%>
		<%@ page import="java.util.ArrayList"%>

		<%
			String id = "";
			String name = "";
			id = "" + (Integer) session.getAttribute("ID");
			name = (String) session.getAttribute("Username");
		%>

		<form action="KlusAanmakenServlet.do" method="get">
			<input type="hidden" name="klantid" value="<%=id%>" /> <input
				type="hidden" name="name" value="<%=name%>" />

			<!-- Auto -->
			<select name="auto">
				<%
					@SuppressWarnings("unchecked")
					ArrayList<Klant> klanten = (ArrayList<Klant>) application
							.getAttribute("alleUsers");
					for (Klant k : klanten) {
						if (k.getId() == (Integer.parseInt(id))) {
							ArrayList<Auto> autos = k.getAlleAutos();
							if (autos.size() > 0) {
								for (Auto a : autos) {
									if (!a.isInReparatie()) {
				%>
				<option value="<%=a.getKenteken()%>"><%=a.getKenteken()%></option>
				<%
					}
								}
							}
							break;
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
			<input class="down-afspraak" type="submit" value="Verzenden" />
		</form>
	</div>
</body>
</html>