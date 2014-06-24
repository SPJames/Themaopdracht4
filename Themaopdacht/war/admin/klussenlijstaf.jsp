<%@ page import="domein.klusbeheer.Klus"%>
<%@ page import="domein.klantenbinding.Klant"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domein.financien.Factuur"%>

<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Afgeronde klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<div id="klus">
		<h2>Afgeronde klussen</h2>
		
		<jsp:include page="../message.jsp"/>
		
		<table>
			<tr>
				<th>Klus ID</th>
				<th>Klant naam</th>
				<th>Auto</th>
				<th>Diensttype</th>
				<th>Comments</th>
				<th>Parkeerplaats</th>
			</tr>
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur>facturen = (ArrayList<Factuur>) application.getAttribute("alleFacturen");//alle facturen ophalen
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");//alle users ophalen
			@SuppressWarnings("unchecked")
			ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");//alle klussen ophalen
				for (Klus k : klussen) {
					if (k.isKlusafgerond()) {//boolean voor als de klus klaar is voor facturatie
						//pak alle klus gegevens
						int id = k.getKlusNummer();
						int klantid = k.getKlantID();	
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {//kijken of het klantid wat bij de klus het zelfde is als het id van de klant
								klantname = klant.getNaam();//pak de naam van die klant
							}
						}
						//nog meer gegevens van de klus	
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().dienstType();
						String commentaar = k.getBeschrijving();
						int parkeerplaats = k.getParkeerplaats() + 1;
						%>
						<tr>
							<td><%=id%></td>
							<td><%=klantname%></td>
							<td><%=auto%></td>
							<td><%=type%></td>
							<td><%=commentaar%></td>
							<td><%=parkeerplaats%></td>
							<td><a href="KlusFacturerenServlet?klusid=<%=id%>">factureren</a></td><!-- de klus door sturen naar facturatie met het id van de klus -->
						</tr>
						<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>