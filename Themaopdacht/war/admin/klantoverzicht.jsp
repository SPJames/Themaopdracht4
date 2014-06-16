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
	
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
		}
		
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");
			if(klanten.size() > 0) {
				%>
				<table>
				<tr>
					<th>ID</th>
					<th>Naam</th>
					<th></th>
				</tr>
				<%
				for(Klant k : klanten) {
				%>
				<tr>
					<td><%= k.getId() %></td>
					<td><%= k.getNaam() %></td>
					<td><a href="#">Stuur mail</a></td>
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