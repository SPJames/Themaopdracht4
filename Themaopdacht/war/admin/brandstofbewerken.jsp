<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Brandstof Bewerken" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Brandstof"%>
	<%@ page import="java.util.ArrayList"%>

	<div id="Content">
		<h2>Brandstof Bewerken</h2>

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
				ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) application
						.getAttribute("alleBrandstof");
				if (brandstoffen.size() > 0) {
					for(Brandstof b : brandstoffen){
						if(b.getTsic() == Integer.parseInt(request.getParameter("id"))){
							int id = b.getTsic();
							String naam = b.getBrandstofType();
							int aantal = b.getLiter();
							double prijs = b.getPrijsPerLiter();
			%>
			<form action="BrandstofBewerkenServlet.do" method="get">
				<fieldset>
					<input type="hidden" name="artikelid" value="<%= id %>" />
					<label for="type">Brandstof Type</label>
					<input type="text"	name="type"  class="box"
						value="<%= naam %>" readonly="readonly" />
					<label for="aantal">Aantal Liters</label>
					<input type="number" name="aantal"  class="box" min="1"
						value="<%=aantal %>" />
					<label for="PrijsLiter">Prijs per Liter</label>
					<input type="number" step="any" name="PrijsLiter" class="box" min="1.50" value="<%= prijs %>" />
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