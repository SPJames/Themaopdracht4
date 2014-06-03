
<div id="Menu">
	<ul>
		<%
			boolean ingelogd = false;
			String userName = "";
			String userType = "";
			String loc = "derp";

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
			loc = request.getParameter("naam");

			if (ingelogd && (userType.equals("Klant"))) {
		%>
		<li><a href='afspraakmaken.jsp'>Afspraak maken</a></li>
		<li><a href='LogoutServlet'>Uitloggen (<%=userName%>)</a></li>
		<li><a href='autos.jsp'> Auto overzicht </a></li>
		<li><a href='accountwijzigen.jsp'> Wijzig account </a></li>
		<%
			}
			if (ingelogd && (userType.equals("Monteur"))) {
				if(loc != null){
		%>
				<li><a href='monteur/klussenlijst.jsp'>Klussenlijst</a></li>
			<%}else{%>
				<li><a href='${param.path}klussenlijst.jsp'>Klussenlijst</a></li>
		<%}%>
		<li><a href='${param.path}LogoutServlet'>Uitloggen (<%=userName%>)</a></li>
			<%
			}
			if (ingelogd && (userType.equals("Admin"))) {
		%>
		<li><a href='${param.path}administratie/klussenlijstaf.jsp'>Factuur Maken</a></li>
		<li><a href='${param.path}LogoutServlet'>Uitloggen (<%=userName%>)</a></li>
		<li><a href='${param.path}monteur/registermonteur.jsp'>Nieuwe monteur toevoegen</a></li>
		<%
			}
			if (!ingelogd) {
		%>
		<li><a href='register.jsp'>Register</a></li>
		<li><a href='login.jsp'>Login</a></li>
		<%
			}
		%>
		<li><a href='/Themaopdracht4/index.jsp'>${param.name}</a></li>
	</ul>
</div>