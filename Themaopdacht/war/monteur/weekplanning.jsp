<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div>
		<script type="text/JavaScript" src="/atd/scripts/Calendar.js"></script>

		<%!int dag;
	String dagtekst;%>

		<div id="klus">
			<table>
				<thead>
					<tr>
						<td>Weeknummer: <span id="weeknr"></span></td>
						<%
							//dagen
							for (int i = 1; i < 7; i++) {
								dag = i;

								switch (dag) {
								case 1:
									dagtekst = "maandag";
									break;
								case 2:
									dagtekst = "dinsdag";
									break;
								case 3:
									dagtekst = "woensdag";
									break;
								case 4:
									dagtekst = "donderdag";
									break;
								case 5:
									dagtekst = "vrijdag";
									break;
								case 6:
									dagtekst = "zaterdag";
									break;
								default:
									break;
								}
						%>

						<td><%=dagtekst%></td>
						<%
							}
						%>
					</tr>

				</thead>
				<tbody>

					<%!int tijd;
					String tijdtekst;%>
					<%
						//tijdsblokken
						for (int i = 1; i < 12; i++) {
							tijd = i;

							switch (tijd) {
							case 1:
								tijdtekst = "8:00";
								break;
							case 2:
								tijdtekst = "9:00";
								break;
							case 3:
								tijdtekst = "10:00";
								break;
							case 4:
								tijdtekst = "11:00";
								break;
							case 5:
								tijdtekst = "12:00";
								break;
							case 6:
								tijdtekst = "13:00";
								break;
							case 7:
								tijdtekst = "14:00";
								break;
							case 8:
								tijdtekst = "15:00";
								break;
							case 9:
								tijdtekst = "16:00";
								break;
							case 10:
								tijdtekst = "17:00";
								break;
							case 11:
								tijdtekst = "18:00";
								break;
							default:
								break;
							}
					%>
					<tr>
						<td><%=tijdtekst%></td>
					</tr>
					<%
						}
					%>

					<%-- <%!int klusnr = 1;%>

					<%
						for (int i = 0; i < 25; i++) {
					%>
					<tr>
						<td onClick="klusaanpassen.jsp?id=">Klus nr: <%=klusnr++%>
						</td>
					</tr>
					<%
						}
					%> --%>

				</tbody>
			</table>
		</div>
</body>
</html>