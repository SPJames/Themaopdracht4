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

		<p>Factuur ID</p><p><%=f.getFactuurNummer()%></p>
		<br />

		<%
			for (Factuur f : facturen) {
		%>
		<p>Totaalprijs (zonder Btw):</p><p><%=f.getTotaalprijsExBtw()%></p>
		<br />
		<hr width="400" />
		<p>Totaalprijs (met Btw):</p><p><%=f.getTotaalprijs()%></p>
		<br />
		<p>Kortingsprecentage:</p><p><%=f.getKorting()%></p>
		<br />
		<p>Totaalprijs (met korting):</p><p><%=f.getTotaalprijsKorting()%></p>
		<br />

		<%
			}
		%>

	</div>
</body>
</html>