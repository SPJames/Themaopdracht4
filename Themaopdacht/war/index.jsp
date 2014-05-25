<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Login" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<div id="Menu">
		<ul>
			<%
				boolean ingelogd = false;
				String userName = "";
				String userType = "";

				Object login = session.getAttribute("Username");
				if (login != null) {
					
					if (!(session.getAttribute("Username").equals(""))) {
						userName = (String) session.getAttribute("Username");
						ingelogd = true;
					}
					if (!(session.getAttribute("Access").equals(""))) {
						userType = (String) session.getAttribute("Access");
						ingelogd = true;
					}
				}

				if (ingelogd && (userType.equals("Klant"))) {
					out.print("<li><a href='afspraakmaken.jsp'>Afspraak maken</a></li><li><a href='LogoutServlet' >Uitloggen "
							+ userName
							+ " </a></li><li><a href='autos.jsp'> Auto overzicht </a></li>");
				}
				if (ingelogd && (userType.equals("Monteur"))) {
					out.print("<li><a href='monteur/klussenlijst.jsp'>Klus updaten</a></li><li><a href='LogoutServlet' >Uitloggen "
							+ userName + " </a></li>");
				}
				if (ingelogd && (userType.equals("Admin"))) {
					out.print("<li><a href='administratie/klussenlijstaf.jsp'>Factuur Maken</a></li><li><a href='LogoutServlet' >Uitloggen "
							+ userName
							+ " </a></li><li><a href='monteur/registermonteur.jsp'>Nieuwe monteur toevoegen</a></li>");
				}
				if (!ingelogd) {
					out.print("<li><a href='register.jsp'>Register</a></li> <li><a href='login.jsp'>Login</a></li>");
				}
			%>
		</ul>
	</div>
	<div id="Content">hier text enzo voor de pagina weet ik veel wat.
	</div>
</body>
<html>