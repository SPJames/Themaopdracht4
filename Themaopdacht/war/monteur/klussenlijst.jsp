<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<%@ page import="domein.klusbeheer.Klus"%>
	<%@ page import="domein.klantenbinding.Klant"%>
	<%@ page import="domein.klusbeheer.Monteur"%>
	<%@ page import="java.util.ArrayList"%>
	<div id="klus">
		<h2>Klussen</h2>
		
		<div>
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
			}
		%>
		</div>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");
				for (Klus k : klussen) {
					if (session.getAttribute("Username").equals(k.getWerknemer()) && !k.isKlusafgerond()) {
						int id = k.getKlusNummer();
						
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {
								klantname = klant.getNaam();
							}
						}
						
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().dienstType();
						String commentaar = k.getBeschrijving();
						String parkeerplaats = "" + (k.getParkeerplaats() + 1);
						%>
					<p>Uw klussen:</p>
					<table>
						<tr>
							<th>Klus ID</th>
							<th>Klant naam</th>
							<th>Auto</th>
							<th>Diensttype</th>
							<th>Comments</th>
							<th>Parkeerplaats</th>
							<th>Manuren</th>
							<th>Gebruikte Onderdelen</th>
							<th>Gebruikte Brandstof</th>
							<th></th>
							<th></th>
						</tr>
						<tr>
							<td><%=id%></td>
							<td><%=klantname%></td>
							<td><%=auto%></td>
							<td><%=type%></td>
							<td><%=commentaar%></td>
							<td><%=parkeerplaats%></td>
							<td><%=k.getManuren()%></td>
							<td><%=k.getGebruikteOnderdelen().size()%></td>
							<td><%=k.getGebruikteBrandstof().size()%></td>
							<td><a href="klusaanpassen.jsp?id=<%=id%>">edit</a></td>
							<td><a href="KlusAfrondenServlet?id=<%=id%>">afronden</a></td>
						</tr>
					</table>
					<%
					}
					if(k.getWerknemer() == null && !k.isKlusafgerond()) {
						int id = k.getKlusNummer();
						
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {
								klantname = klant.getNaam();
							}
						}
						
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().dienstType();
						String commentaar = k.getBeschrijving();
						String parkeerplaats = "" + (k.getParkeerplaats() + 1);
						%>
					<p>beschikbare klussen</p>
					<table>
						<tr>
							<th>Klus ID</th>
							<th>Klant naam</th>
							<th>Auto</th>
							<th>Diensttype</th>
							<th>Comments</th>
							<th>Parkeerplaats</th>
						</tr>
						<tr>
							<td><%=id%></td>
							<td><%=klantname%></td>
							<td><%=auto%></td>
							<td><%=type%></td>
							<td><%=commentaar%></td>
							<td><%=parkeerplaats%></td>
							<td><a href="KlusUitkiezenServlet?id=<%=id%>">uitkiezen</a></td>
						</tr>
					</table>
						<%
					}
				}
			%>
	</div>
</body>
</html>