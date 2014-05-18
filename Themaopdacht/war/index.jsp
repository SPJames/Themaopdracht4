<!DOCTYPE>
<html>
<head>
<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="style-home.css" />
</head>
<body>
	<div id="Menu">
		<ul>
			<%
				boolean ingelogd = false;
				String userName = "";
				String userType = "";
				Cookie[] cookies = null;
				cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie c : cookies) {
						if (c.getName().equals("C_Username")) {
							userName = c.getValue();
							ingelogd = true;
						}
						if (c.getName().equals("C_Usertype")){
							userType = c.getValue();
							ingelogd = true;
							break;
						}
					}
				}
				
				 
				if (ingelogd && (userType.equals("Klant"))) {
					out.print("<li><a href='afspraakmaken.jsp'>Afspraak maken</a></li><li><a href='LogoutServlet' >Uitloggen "
							+ userName + " </a></li><li><a href='autos.jsp'> Auto overzicht </a></li>");
				}
				if (ingelogd && (userType.equals("Monteur"))) {
					out.print("<li><a href='monteur/klussenlijst.jsp'>Klus updaten</a></li><li><a href='LogoutMonteurServlet' >Uitloggen "
							+ userName + " </a></li>");
				}
				if (ingelogd && (userType.equals("Admin"))) {
					out.print("<li><a href='administratie/klussenlijstaf.jsp'>Factuur Maken</a></li><li><a href='LogoutMonteurServlet' >Uitloggen "
							+ userName + " </a></li>");
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