<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Onderdeel Toevoegen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Onderdeel"%>
	<div id="register">
		<h2>Onderdeel Toevoegen</h2>
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

		<form action="OnderdeelToevoegenServlet.do" method="get">
			<fieldset>
				<label for="artikelnaam">Artikel Naam</label>
				<input type="text"	name="artikelnaam" placeholder="ArtikelNaam" class="box"
					value="${param.artikelnaam}" />
				<label for="aantal">Aantal</label>
				<input type="number" name="aantal"  class="box" min="1"
					value="1" />
				<label for="PrijsArtikel">Prijs per Artikel</label>
				<input type="number" step="any" name="PrijsArtikel" class="box" min="1.50" value="1.50" />
				<input type="submit" value="Toevoegen" class="down"/>	
			</fieldset>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>