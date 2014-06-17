<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Factuur overzicht" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="klus">
		<h2>Afgeronde klussen</h2>

		<%@ page import="domein.financien.Factuur"%>
		<%@ page import="domein.klantenbinding.Klant"%>
		<%@ page import="domein.klusbeheer.Klus" %>
		<%@ page import="java.util.*"%>

		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
			%>
			<div id="msgs">
				<%
					out.println(msgs);
				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");
				if (klanten.size() > 0) {
			%>
			</div>
			<table>
				<tr>
					<th>ID</th>
					<th>Naam</th>
					<th></th>
				</tr>
				<%
					for (Klant k : klanten) {
							if (k.getId() == Integer.parseInt(request.getParameter("klantid"))){
				%>
				<tr>
					<td><%=k.getId()%></td>
					<td><%=k.getNaam()%></td>
				</tr>
				<%
					}
				}
				%>
			</table>
			
			<div>
				<%
					for(Klus k: klussen){
				%>
					<%=k.getHetType().dienstType()%><br />
					<%=k.getKlusNummer()%><br />
					<%=k.getAuto()%><br />
					<%=k.getBeschrijving()%><br />
					<%=k.getWerknemer() %><br />
					<%=k.getParkeerplaats() %><br />

				<%} %>
			</div>
			<%
				}else {
			%>
			<p>Er zijn nog geen facturen.</p>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>