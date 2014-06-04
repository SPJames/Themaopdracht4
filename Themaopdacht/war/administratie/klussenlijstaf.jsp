<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Afgeronde klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
	<jsp:param name="path" value="/Themaopdracht4/monteur/" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp" >
	<jsp:param name="path" value="/Themaopdracht4/" />
	<jsp:param name="name" value="Home" />
</jsp:include>
	<div id="klus">
		<h2>Afgeronde klussen</h2>
		
		<div>
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
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
			<%@ page import="Klusbeheer.Klus"%>
			<%@ page import="klantenbinding.Klant"%>
			<%@ page import="java.util.ArrayList"%>
			<%@ page import="financien.Factuur"%>
			<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur>facturen = (ArrayList<Factuur>) application.getAttribute("alleFacturen");
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("allUsers");
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("allKlussen");
				for (Klus k : klussen) {
					for(Factuur f : facturen) {
						if (f.getKlus().getKlusNummer() == k.getKlusNummer()) {
						} else if (k.isKlusafgerond()) {
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
							<tr>
								<td><%=id%></td>
								<td><%=klantname%></td>
								<td><%=auto%></td>
								<td><%=type%></td>
								<td><%=commentaar%></td>
								<td><%=parkeerplaats%></td>
								<td><a href="KlusFacturerenServlet?id=<%=id%>">factureren</a></td>
							</tr>
						<%
						}
					}
				}
			%>
		</table>
	</div>
</body>
</html>