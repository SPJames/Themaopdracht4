<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Overzicht Voorraad" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Onderdeel"%>
	<%@ page import="domein.voorraadbeheer.Brandstof" %>
	<%@ page import="java.util.ArrayList"%>
	<script type="text/javascript" src="/atd/scripts/verwissel.js"></script>

	<div id="Content">
		<h2>Voorraad overzicht</h2>

		<%-- <jsp:include page="../messages.jsp" /> --%>
		<!-- deze buttons roepen de script verwissel aan (war/scripts/verwissel.js) -->
		<button onClick="swap('onderdelen','brandstof')">Onderdelen</button>
		<button onClick="swap('brandstof', 'onderdelen')">Brandstof</button>
		
		<div id="onderdelen">	<!-- In deze div staat een tabel met alle aanwezige onderdelen -->
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) application.getAttribute("alleOnderdelen");
			if (onderdelen.size() > 0) {
		%>
		
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
		<% } else{ %>
		<p>Er zijn geen onderdelen in voorraad.</p>
		<% } %>
		<a href='onderdeeltoevoegen.jsp'>Nieuw Onderdeel Toevoegen</a>
		</div>
		
		<!-- In deze div staat de tabel voor alle aanwezige brandstof -->
		<div id="brandstof" style="display:none"> 
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) application.getAttribute("alleBrandstof");
			if (brandstoffen.size() > 0) {
		%>
		
		<table>
			<tr>
				<th>tsic</th>
				<th>Brandstof Type</th>
				<th>Liters</th>
				<th>Prijs per liter</th>
				<th></th>
			</tr>
			<%
				for (Brandstof b : brandstoffen) {
			%>
			<tr>
				<td><%=b.getTsic()%></td>
				<td><%=b.getBrandstofType()%></td>
				<td><%=b.getLiter()%></td>
				<td><%=b.getPrijsPerLiter()%></td>
				<td><a href="brandstofbewerken.jsp?id=<%=b.getTsic()%>">Wijzigen</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<% } else{ %>
		<p>Er is geen brandstof in voorraad.</p>
		<% } %>
		<a href='brandstoftoevoegen.jsp'>Nieuw Brandstof Toevoegen</a>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<html>