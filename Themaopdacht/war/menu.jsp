<!-- menu gebruikt door alle jsp's -->
<div id="Menu">
	<ul>
		<%
			//home alleen weergeven wanneer je niet op de homepage bent
			if (request.getParameter("home") == null) {
		%>
		<li><a href='/atd/index.jsp'>Home</a></li>
		<%
			}

			boolean ingelogd = false;
			String username = "";
			String usertype = "";

			Object login = session.getAttribute("Username");
			if (login != null) {

				if (!(session.getAttribute("Username").equals(""))) {
					username = (String) session.getAttribute("Username");
					ingelogd = true;
				}
				if (!(session.getAttribute("Access").equals(""))) {
					usertype = (String) session.getAttribute("Access");
					ingelogd = true;
				}
			}

			if (ingelogd) {
				if (usertype.equals("Klant")) {%>
				<li><a href='/atd/klant/afspraakmaken.jsp'>Afspraak Maken</a></li>
				<li><a href='/atd/klant/autolijst.jsp'> Auto Overzicht </a></li>
				<li><a href='/atd/klant/accountwijzigen.jsp'> Account Wijzigen </a></li>
		<%}
				if (usertype.equals("Monteur")) {%>
					<li><a href='/atd/monteur/klussenlijst.jsp'>Klussen Lijst</a></li>
					<li><a href='/atd/monteur/weekplanning.jsp'>Week planning</a></li>
		<%}
				if (usertype.equals("Admin")) {%>
					<li><a href='/atd/admin/klussenlijstaf.jsp'>Factuur Maken</a></li>
					<li><a href='/atd/admin/facturen.jsp'>Factuur overzicht</a></li>
					<li><a href='/atd/admin/klantoverzicht.jsp'>Klanten overzicht</a></li>
					<li><a href='/atd/admin/registreermonteur.jsp'>Nieuwe Monteur Toevoegen</a></li>
					<li><a href='/atd/admin/voorraadoverzicht.jsp'>Vo0rraad Overzicht</a></li>
		<%//uitlog knop is bij iedereen zichtbaar als laatste optie wanneer je ingelogd bent
				}%>
				<li><a href='/atd/UitlogServlet'>Uitloggen (<%=username%>)
				</a></li>
		<%} else if (!ingelogd) {%>
			<li><a href='/atd/registreren.jsp'>Registreer</a></li>
			<li><a href='/atd/inloggen.jsp'>Log in</a></li>
		<%}%>
	</ul>
</div>