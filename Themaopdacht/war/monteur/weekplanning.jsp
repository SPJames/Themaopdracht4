<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klussen lijst" />
	<jsp:param name="css" value="klussenlijst" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<div>
	<script type="text/JavaScript" src="/atd/scripts/Calendar.js"></script>
		<table>
			<thead>
				<tr>
					<td> Weeknummer: <span id="weeknr"></span></td>
				</tr>
			</thead>
			<tbody>
			
			<% 
			for(int i = 0; i < 25; i++) {
			%>
				<tr>
					<td onClick="klusaanpassen.jsp?id=">klusdingfiguur</td>
				</tr>
			<%
			}
			%>
			</tbody>
		</table>
	</div>
</body>
</html>