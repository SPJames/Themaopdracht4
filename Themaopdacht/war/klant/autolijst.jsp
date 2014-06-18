<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Overzicht Auto's" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.klantenbinding.Auto"%>
	<%@ page import="domein.klantenbinding.Klant"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		int id = (Integer) session.getAttribute("ID");
	%>

	<div id="Content">
		<h2>Auto Toevoegen</h2>

		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
			%>
			<div id="msgs">
				<%
					out.println(msgs);
				%>
			</div>
			<%
				}
			%>
		</div>


		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application
					.getAttribute("alleUsers");
			for (Klant k : klanten) {
				if (k.getId() == id) {
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
</body>
<html>