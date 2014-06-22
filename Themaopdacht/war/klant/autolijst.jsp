<%@ page import="domein.klantenbinding.Auto"%>
<%@ page import="domein.klantenbinding.Klant"%>
<%@ page import="java.util.ArrayList"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Overzicht Auto's" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />

	<div id="Content">
		<h2>Auto Toevoegen</h2>

		<jsp:include page="../message.jsp" />

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");//alle users ophalen
			for (Klant k : klanten) {
				if (k.getId() == (Integer) session.getAttribute("ID")) {//kijken of het de ingelogde klant is
					ArrayList<Auto> autos = k.getAlleAutos();//alle autos van die klant
					if (autos.size() > 0) {//save guard voor als array leeg is
		%>
		<table>
			<tr>
				<th>Merk</th>
				<th>Kenteken</th>
			</tr>
			<%
				for (Auto a : autos) {
			%>
			<tr>
				<td><%=a.getMerk()%></td>
				<td><%=a.getKenteken()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {//als de array leeg is
		%>
		<p>U heeft nog geen auto's.</p>
		<%
			}
					break;
				}
			}
		%>
		<a href="autotoevoegen.jsp">Voeg een auto toe</a>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<html>