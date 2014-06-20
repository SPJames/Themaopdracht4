<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Facturen</h2>

		<%@ page import="domein.financien.Factuur"%>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="domein.klusbeheer.Klus"%>
		<%@ page import="java.util.*"%>

		<jsp:include page="message.jsp" />

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur> facturen = (ArrayList<Factuur>) application
					.getAttribute("alleFacturen");
			if (facturen.size() > 0) {
		%>
		<table>
			<tr>
				<th>Factuur ID</th>
				<th>Totaalprijs (btw + korting)</th>
			</tr>
			<%
				for (Factuur f : facturen) {
			%>
			<tr>
				<td><%=f.getFactuurNummer()%></td>
				<td><%=f.getFactuurNummer()%></td>
				<td><%=f.getTotaalprijsExBtw()%></td>
				<hr />
				<td><%=f.getTotaalprijs()%></td>
				<td><%=f.getKorting()%></td>
				<td><%=f.getTotaalprijsKorting()%></td>
			</tr>

			<%
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
</body>
</html>