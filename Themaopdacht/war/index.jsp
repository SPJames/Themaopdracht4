<%@ page import="domein.klusbeheer.Klus"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Home pagina" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="menu.jsp">
		<jsp:param name="home" value="home" />
	</jsp:include>

	<div id="Content">
		<jsp:include page="message.jsp" />
		<img src="/atd/images/atd-logo.png" class="logo" alt="atd-logo" />

		<p>
			Welkom bij de garage van <b>Auto Totaal Diensten.</b><br /> Bij ons
			hoeft u niet te bellen en te overleggen om een afspraak te maken.<br />
			Door een account aan te maken kunt u in één keer een afspraak maken.
			 <br />Tijdens het maken van de afspraak kunt u
			aangeven of u uw auto wilt laten repareren en/of wil tanken.<br /> U kunt
			doorgeven wat voor problemen u waarneemt met uw auto. <br />Na het
			maken van de afspraak hoeft u alleen maar uw auto af te leveren in de
			aan u toegewezen parkeerplaats in onze beveiligde en overdekte
			parkeergarage. <br /> <br />Er wordt contact met u opgenomen
			wanneer u uw auto weer op kan halen.
		</p>
		<hr />

		<!-- openstaande klussen van klant, zodat hij/zij voortgang kan volgen-->

		<%
			if ((session.getAttribute("Access") != null) && (session.getAttribute("Access").equals("Klant"))) {
				@SuppressWarnings("unchecked")
				ArrayList<Klus> Klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");
				if (Klussen.size() > 0) {
		%>
		<p>Uw openstaande klussen:</p>
		<table>
			<tr>
				<th>Auto</th>
				<th>Diensttype</th>
				<th>Parkeerplek</th>
				<th>Voortgang</th>
			</tr>
			<%
					for (Klus k : Klussen) {
						if ((k.getKlantID() == (Integer) session.getAttribute("ID"))) {
							String afgerond = "In behandeling";
							if (k.isKlusafgerond()) {
								afgerond = "Afgerond";
							}
			%>
			<tr>
				<td><%=k.getAuto().getKenteken()%></td>
				<td><%=k.getHetType().dienstType()%></td>
				<td><%=k.getParkeerplaats() + 1%></td>
				<td><%=afgerond%></td>
			</tr>
			<%
						}
					}
			%>
		</table>
		<%
				} else {
		%>
		<p>Er staan op dit moment geen klussen op uw naam.</p>
		<%
				}
			}
		%>

		<!-- einde openstaande klussen klanten -->

	</div>
	<jsp:include page="footer.jsp"/>
</body>
<html>