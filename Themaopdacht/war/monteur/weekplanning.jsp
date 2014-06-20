<%@ page import="domein.klusbeheer.Weekplanning" %>
<%@ page import="domein.klusbeheer.Klus" %>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
		<script type="text/JavaScript" src="/atd/scripts/Calendar.js"></script>

		<%!int dag;
		String dagtekst;%>
		
		<%
			Weekplanning week = (Weekplanning) application.getAttribute("planning");
			Klus[][][] klussen = week.getKlussen();
			
		%>

		<div id="klus">
			<table>
				<thead>
					<tr>
						<td>Weeknummer: <%= week.getWeekNr() %></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<%
							//dagen
							for (int i = 0; i < 7; i++) {
								dag = i;
							
								if(dag == 0) {
									dagtekst = "zondag";
								} else if(dag == 1) {
									dagtekst = "maandag";
								} else if(dag == 2) {
									dagtekst = "dinsdag";
								} else if(dag == 3) {
									dagtekst = "woensdag";
								} else if(dag == 4) {
									dagtekst = "donderdag";
								} else if(dag == 5) {
									dagtekst = "vrijdag";
								} else if(dag == 6) {
									dagtekst = "zaterdag";
								} else {}
						%>

						<tr>
							<td><%=dagtekst%></td>
							<%
							boolean leeg = true;
							String result = "";
							for(int j=0; j<6; j++) {
								if(klussen[j][dag][week.getWeekNr()] != null) {
									result = result + klussen[j][dag][week.getWeekNr()].getKlusNummer()+" ";
									leeg = false;
								}
							}
							if(leeg) {
								%>
								<td>geen klus</td>
								<%
							} else {
								%>
								<td><%=result%></td>
								<%
							}
							%>
						</tr>
						<%
							}
						%>					
				</tbody>
			</table>
		</div>
</body>
</html>