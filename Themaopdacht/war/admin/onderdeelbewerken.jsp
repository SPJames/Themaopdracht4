<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Onderdeel Bewerken" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Onderdeel"%>
	<%@ page import="java.util.ArrayList"%>

	<div id="Content">
		<h2>Onderdeel Bewerken</h2>

		<jsp:include page="../message.jsp"/>
			<%
				//gegevens van het meegegeven onderdeel worden opgevraagd
				@SuppressWarnings("unchecked")
				ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) application
						.getAttribute("alleOnderdelen");//alle onderdelen ophalen
				if (onderdelen.size() > 0) {
					for(Onderdeel o : onderdelen){
						if(o.getArtikelNr() == Integer.parseInt(request.getParameter("id"))){//pak het onderdeel die gelijk staat aan de geselecteerde id
							//pak alle gegevens van het onderdeel
							int id = o.getArtikelNr();
							String naam = o.getNaam();
							int aantal = o.getAantal();
							double prijs = o.getPrijsArtikel();
			%>
			<!-- van het meegegeven onderdeel kunnen aantal en prijs per artikel worden gewijzigd -->
			<form action="OnderdeelBewerkenServlet.do" method="post">
				<fieldset>
					<input type="hidden" name="artikelid" value="<%= id %>" />
					<label for="artikelnaam">Artikel Naam</label>
					<input type="text"	name="artikelnaam"  class="box"
						value="<%= naam %>" readonly="readonly" />
					<label for="aantal">Aantal</label>
					<input type="number" name="aantal"  class="box" min="1"
						value="<%=aantal %>" />
					<label for="PrijsArtikel">Prijs per Artikel</label>
					<input type="number" step="any" name="PrijsArtikel" class="box" min="1.50" value="<%= prijs %>" />
					<input type="submit" value="Veranderen" class="down"/>	
				</fieldset>
			</form>	
			<%
						}
					}
				} else {//als de array nog leeg is
			%>
			<p>Er is nog geen voorraad.</p>
			<%
				}
			%>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<html>