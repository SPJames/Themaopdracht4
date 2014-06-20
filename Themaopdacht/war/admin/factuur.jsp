<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Factuur Berekenen</h2>

		<%@ page import="domein.financien.Factuur"%>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="domein.klusbeheer.Klus"%>
		<%@ page import="java.util.*"%>

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur> facturen = (ArrayList<Factuur>) application
					.getAttribute("alleFacturen");
		%>

		<p>Factuur ID</p>
		<br />
		<p>Totaalprijs</p>
		<br />

		<%
			for (Factuur f : facturen) {
		%>

		<p><%=f.getFactuurNummer()%></p>
		<br />
		<p><%=f.getTotaalprijsExBtw()%></p>
		<br />
		<hr />
		<p><%=f.getTotaalprijs()%></p>
		<br />
		<p><%=f.getKorting()%></p>
		<br />
		<p><%=f.getTotaalprijsKorting()%></p>
		<br />

		<%
			}
		%>

	</div>
</body>
</html>