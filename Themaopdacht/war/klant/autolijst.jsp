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
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");
			for (Klant k : klanten) {
				if (k.getId() == (Integer) session.getAttribute("ID")) {
					ArrayList<Auto> autos = k.getAlleAutos();
					if (autos.size() > 0) {
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
			} else {
		%>
		<p>U heeft nog geen autos.</p>
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