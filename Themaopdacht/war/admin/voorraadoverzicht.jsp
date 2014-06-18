<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Overzicht Voorraad" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Onderdeel"%>
	<%@ page import="java.util.ArrayList"%>

	<div id="Content">
		<h2>Voorraad overzicht</h2>

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

				@SuppressWarnings("unchecked")
				ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) application
						.getAttribute("alleOnderdelen");
				if (onderdelen.size() > 0) {
			%>
		</div>
		<table>
			<tr>
				<th>Artikel nr</th>
				<th>Naam</th>
				<th>Aantal</th>
				<th>Prijs per artikel</th>
				<th></th>
			</tr>
			<%
				for (Onderdeel o : onderdelen) {
			%>
			<tr>
				<td><%=o.getArtikelNr()%></td>
				<td><%=o.getNaam()%></td>
				<td><%=o.getAantal() %></td>
				<td><%=o.getPrijsArtikel() %></td>
				<td><a href="onderdeelbewerken.jsp?id=<%=o.getArtikelNr()%>">Wijzigen</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<p>Er is nog geen voorraad.</p>
		<%
			}
		%>
		<a href='onderdeeltoevoegen.jsp'>Nieuw Onderdeel Toevoegen</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<html>