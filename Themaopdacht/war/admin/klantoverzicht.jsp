<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Overzicht Auto's" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.klantenbinding.Klant"%>
	<%@ page import="java.util.ArrayList"%>

	<div id="Content">
		<h2>Klanten overzicht</h2>

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

				@SuppressWarnings("unchecked")
				ArrayList<Klant> klanten = (ArrayList<Klant>) application
						.getAttribute("alleUsers");
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
			%>
			<tr>
				<td><%=k.getId()%></td>
				<td><%=k.getNaam()%></td>
				<td><a href="/atd/KiezenEmail.do?id=<%=k.getId()%>&sort=herinnering">Stuur Lang niet geweest-email</a></td>
				<td><a href="/atd/KiezenEmail.do?id=<%=k.getId()%>&sort=betaald">Stuur Niet betaald-email</a></td>
				<td><a href="/atd/KiezenEmail.do?id=<%=k.getId()%>&sort=auto">Stuur Auto controlen-email</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<%
			} else {
		%>
		<p>Er zijn nog geen klanten.</p>
		<%
			}
		%>
	</div>
</body>
<html>