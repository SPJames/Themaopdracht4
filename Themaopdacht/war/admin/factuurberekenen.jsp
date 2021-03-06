<%@ page import="domein.financien.Factuur"%>
<%@ page import="domein.klantenbinding.Klant"%>
<%@ page import="domein.klusbeheer.Klus"%>
<%@ page import="java.util.*"%>

<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Factuur Berekenen</h2>

		

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur> facturen = (ArrayList<Factuur>) application.getAttribute("alleFacturen");//alle facturen ophalen
		%>
		<%
			for (Factuur f : facturen) {
				if(f.getFactuurNummer() == (Integer) request.getAttribute("id")) {
		%>
		<p>Factuur ID</p>
		<p><%=f.getFactuurNummer()%></p>
		<br />
		<p>Manuren prijs:</p>
		<p>
			&euro;<%=f.getManurenprijs()%></p>
		<br />
		<p>Onderdelen:</p>
		<p>
			<%=f.getOnderdelenprijs()%></p>
		<br />
		<p>Brandstof:</p>
		<p>
			<%=f.getBrandstofprijs()%></p>
		<br />
		<hr width="400" />
		<p>Totaalprijs (zonder Btw):</p>
		<p>
			&euro;<%=f.getTotaalprijsExBtw()%></p>
		<br />
		<p>Totaalprijs (met Btw):</p>
		<p>
			&euro;<%=f.getTotaalprijs()%></p>
		<br />
		<p>Kortingsprecentage:</p>
		<form method="post" action="KortingWijzigen.do">
			Korting: 
			<input type="hidden" name="id" value=<%=f.getFactuurNummer()%> />
			<input type="number" name="korting" min="0" max="100" />
			<input type="Submit" value="Voeg Korting Toe" />
		</form>
		<p>
			%<%=f.getKorting()%></p>
		<br />
		<p>Totaalprijs (met korting):</p>
		<p>
			&euro;<%=f.getTotaalprijsKorting()%></p>
		<br />

		<%
				}
			}
		%>

	</div>
</body>
</html>