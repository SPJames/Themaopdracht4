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

				if (ingelogd && (userType.equals("Klant"))) { %>
					<li><a href='${param.path}afspraakmaken.jsp'>Afspraak maken</a></li><li><a href='${param.path}LogoutServlet' >Uitloggen <%=userName%></a></li><li><a href='autos.jsp'> Auto overzicht </a></li>
				<%}
				if (ingelogd && (userType.equals("Monteur"))) {%>
				<li><a href='${param.path}monteur/klussenlijst.jsp'>Klus updaten</a></li><li><a href='${param:path}LogoutServlet' >Uitloggen <%=userName%> </a></li>
				<%}
				if (ingelogd && (userType.equals("Admin"))) {%>
					<li><a href='${param.path}administratie/klussenlijstaf.jsp'>Factuur Maken</a></li><li><a href='${param.path}LogoutServlet' >Uitloggen <%=userName%></a></li><li><a href='${param.path}monteur/registermonteur.jsp'>Nieuwe monteur toevoegen</a></li>
				<%}
				if (!ingelogd) {%>
					<li><a href='${param.path}register.jsp'>Register</a></li> <li><a href='${param.path}login.jsp'>Login</a></li>
				<%}
			%>
		</ul>
	</div>