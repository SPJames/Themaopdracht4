<!DOCTYPE>
<html>
<head>
<title>Auto Toevoegen</title>
<link rel="stylesheet" type="text/css" href="style-home.css" />
</head>
<body>
	<%!String id = "";%>
	<%@ page import="klantenbinding.Auto"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("C_ID")) {
					id = c.getValue();
					break;
				}
			}
		}
	%>

	<h2>Auto Toevoegen</h2>
	<table>
		<tr>
			<th>Merk</th>
			<th>Kenteken</th>
		</tr>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) getServletContext()
					.getAttribute("allAutos");
			if (Autos.size() != 0) {
				for (Auto a : Autos) {
					if (a.getKlantid().equals(id)) {
						out.println("<tr>");
						out.println("<td>");
						out.prinln(a.getMerk());
						out.println("</td>");
						out.println("<td>");
						out.prinln(a.getKenteken());
						out.println("</td>");
						out.println("</tr>");
					}
				}
			}
		%>
	</table>
	<a href="autotoevoegen.jsp">Voeg een auto toe</a>
</body>
<html>