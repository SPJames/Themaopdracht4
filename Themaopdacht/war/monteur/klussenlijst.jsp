<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
	<jsp:param name="path" value="/Themaopdracht4/monteur/" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp" >
	<jsp:param name="path" value="/Themaopdracht4/monteur/" />
	<jsp:param name="name" value="Home" />
</jsp:include>
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
			<%@ page import="Klusbeheer.Monteur"%>
			<%@ page import="java.util.ArrayList"%>
			<%
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("allUsers");
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("allKlussen");
				for (Klus k : klussen) {
					if (session.getAttribute("Username").equals(k.getWerknemer()) && !k.isKlusafgerond()) {
						String id = "" + k.getKlusNummer();
						
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {
								klantname = klant.getNaam();
							}
						}
						
						String auto = k.getAuto().getKenteken();
						
						//fout met type formatting!
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
							<td><a href="klusaanpassen.jsp?id=<%=id%>">edit</a></td>
							<td><a href="../KlusAfrondenServlet?id=<%= id %>">afronden</a></td>
						</tr>
					<%
					}
				}
				for (Klus k : klussen) {
					if(k.getWerknemer() == null && !k.isKlusafgerond()) {
						String id = "" + k.getKlusNummer();
						
						String klantname = "";
						for(Klant klant : klanten) {
							if(klant.getId() == k.getKlantID()) {
								klantname = klant.getNaam();
							}
						}
						
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().toString();
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
							<td><a href="../KlusUitkiezenServlet?id=<%=id%>">uitkiezen</a></td>
						</tr>
						<%
					}
				}
			%>
		</table>
	</div>
</body>
</html>