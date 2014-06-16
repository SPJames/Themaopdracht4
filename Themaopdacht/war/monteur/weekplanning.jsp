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
					<td> Ma: <span id="ma"></span></td>
					<td> Di: <span id="di"></span></td>
					<td> Wo: <span id="wo"></span></td>
					<td> Do: <span id="do"></span></td>
					<td> Vr: <span id="vr"></span></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>8:00 - 10:00</td>
					<td onClick="voegKlusToe.jsp?day=ma&num=1"></td>
					<td onClick="voegKlusToe.jsp?day=di&num=1"></td>
					<td onClick="voegKlusToe.jsp?day=wo&num=1"></td>
					<td onClick="voegKlusToe.jsp?day=do&num=1"></td>
					<td onClick="voegKlusToe.jsp?day=vr&num=1"></td>
				</tr>
				<tr>
					<td>10:00 - 12:00</td>
					<td onClick="voegKlusToe.jsp?day=ma&num=2"></td>
					<td onClick="voegKlusToe.jsp?day=di&num=2"></td>
					<td onClick="voegKlusToe.jsp?day=wo&num=2"></td>
					<td onClick="voegKlusToe.jsp?day=do&num=2"></td>
					<td onClick="voegKlusToe.jsp?day=vr&num=2"></td>
				</tr>
				<tr>
					<td>12:00 - 14:00</td>
					<td onClick="voegKlusToe.jsp?day=ma&num=3"></td>
					<td onClick="voegKlusToe.jsp?day=di&num=3"></td>
					<td onClick="voegKlusToe.jsp?day=wo&num=3"></td>
					<td onClick="voegKlusToe.jsp?day=do&num=3"></td>
					<td onClick="voegKlusToe.jsp?day=vr&num=3"></td>
				</tr>
				<tr>
					<td>14:00 - 16:00</td>
					<td onClick="voegKlusToe.jsp?day=ma&num=4"></td>
					<td onClick="voegKlusToe.jsp?day=di&num=4"></td>
					<td onClick="voegKlusToe.jsp?day=wo&num=4"></td>
					<td onClick="voegKlusToe.jsp?day=do&num=4"></td>
					<td onClick="voegKlusToe.jsp?day=vr&num=4"></td>
				</tr>
				<tr>
					<td>16:00 - 18:00</td>
					<td onClick="voegKlusToe.jsp?day=ma&num=5"></td>
					<td onClick="voegKlusToe.jsp?day=di&num=5"></td>
					<td onClick="voegKlusToe.jsp?day=wo&num=5"></td>
					<td onClick="voegKlusToe.jsp?day=do&num=5"></td>
					<td onClick="voegKlusToe.jsp?day=vr&num=5"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>