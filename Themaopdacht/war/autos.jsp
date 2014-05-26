<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Overzicht Auto's" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
<jsp:include page="menu.jsp">
	<jsp:param name="name" value="Home" />
</jsp:include>
	<%@ page import="klantenbinding.Auto"%>
	<%@ page import="java.util.ArrayList"%>
	<%!String id = "";%>
	<%
		id = "" + (int) session.getAttribute("ID");
	%>

<div id="Content">
	<h2>Auto Toevoegen</h2>
	
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
		}
	%>
	
	<table>
		<tr>
			<th>Merk</th>
			<th>Kenteken</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) application.getAttribute("allAutos");
			System.out.println(Autos.size());
			if (Autos.size() > 0) {
				for (Auto a : Autos) {
					if (a.getKlantid().equals(id)) { %>
					
						<tr><td> <%=a.getMerk()%> </td> <td> <%=a.getKenteken()%></td> </tr>
					
					<%}
				}
			}
		%>
	</table>
	<a href="autotoevoegen.jsp">Voeg een auto toe</a>
</div>
</body>
<html>