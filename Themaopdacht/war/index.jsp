<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Index" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="menu.jsp" />

	<%@ page import="Klusbeheer.Klus"%>
	<%@ page import="java.util.ArrayList"%>

	<div id="Content"><p>Welkom bij <b>AutoTotaalDiensten!</b></p>
	
	<!-- openstaande klussen van klant, zodat hij/zij voortgang kan volgen-->
	
	<% if ((session.getAttribute("Access") != null) && (session.getAttribute("Access").equals("Klant"))) {%>
	
	<p>Uw openstaande klussen:</p>
		
	<table>
		<tr>
			<th>Auto</th>
			<th>Diensttype</th>
			<th>Parkeerplek</th>
			<th>Voortgang</th>
		</tr>
		<%
			System.out.println("inlog ID: " + session.getAttribute("ID"));
			@SuppressWarnings("unchecked")
			ArrayList<Klus> Klussen = (ArrayList<Klus>) application.getAttribute("allKlussen");
			if (Klussen.size() > 0) {
				for (Klus k : Klussen) {
					System.out.println("klus klant ID: " + k.getKlantID());
					if ((k.getKlantID() == (int) session.getAttribute("ID"))) {
						String afgerond = "In behandeling";
						if (k.isKlusafgerond()) {
							afgerond = "Afgerond";
						}
						%>
					
							<tr><td> <%=k.getAuto().getKenteken()%> </td><td> <%=k.getHetType().dienstType()%></td> <td> <%=k.getParkeerplaats() + 1%></td> <td> <%=afgerond%></td></tr>
					
						<%
					}
				}
			}
		%>
	</table>
	<% } %>
	
	<!-- einde openstaande klussen klanten -->
	
 	</div>
 	
 	<%
		Object plek = request.getAttribute("plek");
	
		if((plek != null) && ((int) plek > 0)) {%>
			<script type="text/javascript">alert("De klus is geregistreerd! Uw plek is <%= plek %>");</script>
		<%}
	%>
</body>
<html>