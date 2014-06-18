<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Afgeronde klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<div id="klus">
		<h2>Afgeronde klussen</h2>
		
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
		
		<table>
			<tr>
				<th>Klus ID</th>
				<th>Klant naam</th>
				<th>Auto</th>
				<th>Diensttype</th>
				<th>Comments</th>
				<th>Parkeerplaats</th>
			</tr>
			<%@ page import="domein.klusbeheer.Klus"%>
			<%@ page import="domein.klantenbinding.Klant"%>
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="domein.financien.Factuur"%>
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur>facturen = (ArrayList<Factuur>) application.getAttribute("alleFacturen");
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");
			@SuppressWarnings("unchecked")
			ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");
				for (Klus k : klussen) {
					if (k.isKlusafgerond()) {
						int id = k.getKlusNummer();
						int klantid = k.getKlantID();	
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {
								klantname = klant.getNaam();
							}
						}
							
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
							<td><a href="KlusFacturerenServlet?klusid=<%=id%>">factureren</a></td>
						</tr>
						<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>