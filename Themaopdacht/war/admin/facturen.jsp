<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Afgeronde klussen</h2>

		<%@ page import="domein.financien.Factuur"%>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="java.util.*"%>

		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}

				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application
						.getAttribute("alleUsers");
				if (klanten.size() > 0) {
			%>
			<table>
				<tr>
					<th>ID</th>
					<th>Naam</th>
					<th></th>
				</tr>
				<%
					for (Klant k : klanten) {
							if (k.getId() == (Integer) request.getAttribute("id")) {
				%>
				<tr>
					<td><%=k.getId()%></td>
					<td><%=k.getNaam()%></td>
				</tr>
				<%
					}
				}
				%>
			</table>
			<%
				} else {
			%>
			<p>Er zijn nog geen facturen.</p>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>