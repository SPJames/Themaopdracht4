<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Overzicht Facturen</h2>

		<%@ page import="domein.financien.Factuur"%>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="domein.klusbeheer.Klus"%>
		<%@ page import="java.util.*"%>

		<jsp:include page="../message.jsp"/>

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur> facturen = (ArrayList<Factuur>) application
					.getAttribute("alleFacturen");//haal alle facturen op
			if (facturen.size() > 0) {//save guard voor als de array leeg is
		%>
		<table>
			<tr>
				<th>Factuur ID</th>
				<th>Totaalprijs (btw + korting)</th>
				<th>Factuur Wijzigen</th>
			</tr>
			<%
				for (Factuur f : facturen) {
			%>
			<tr>
				<td><%=f.getFactuurNummer()%></td>
				<td>&euro;<%=f.getTotaalprijsKorting()%></td>
				<td><a href="wijzigfactuur.jsp?id=<%=f.getFactuurNummer()%>">Wijzig</a></td>
			</tr>

			<%
				}
			%>
		</table>
		<%
			} else {//als de array leeg is
		%>
		<p>Er zijn nog geen facturen.</p>
		<%
			}
		%>
	</div>
</body>
</html>