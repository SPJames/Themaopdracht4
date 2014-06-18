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
					for(Onderdeel o : onderdelen){
						if(o.getArtikelNr() == Integer.parseInt(request.getParameter("id"))){
							int id = o.getArtikelNr();
							String naam = o.getNaam();
							int aantal = o.getAantal();
							double prijs = o.getPrijsArtikel();
			%>
			<form action="OnderdeelBewerkenServlet.do" method="get">
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
				} else {
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