<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Klus Aanpassen" />
	<jsp:param name="css" value="register" />
	<jsp:param name="path" value="../" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp" >
	<jsp:param name="path" value="../" />
	<jsp:param name="name" value="Home" />
</jsp:include>
		<%@ page import="Klusbeheer.Klus"%>
		<%@ page import="java.util.ArrayList"%>
	<h2>Klus aanpassen</h2>
	<div>
		<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
	</div>
	<%
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("allKlussen");
				for (Klus k : klussen) {
					if (Integer.parseInt(request.getParameter("id")) == k.getKlusNummer()) {
						String id = "" + k.getKlusNummer();
						
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().toString();
						String commentaar = k.getBeschrijving();
						//String parkeerplaats = "" + k.getParkeerplaats();
						
						%>
						
		<form action="../KlusBijwerkenServlet.do" method="get">
		<input type="hidden" name="klusid" value="<%= id %>" />
		<input type="text" name="auto" value="<%= auto %>" readonly="readonly" />
		<!-- diensttype -->
		<select name="diensttype" autofocus="<%= type %>">
			<option value="Onderhoud">Reparatie/Onderhoud/APK</option>
			<option value="Parkeren">Parkeren</option>
			<option value="Tanken">Tanken</option>
		</select>
		<!-- beschrijving klus -->
		<textarea rows="10" cols="50" name="comments"><%= commentaar %></textarea>
		<input type="submit" value="Verzenden" />
		</form>
						
						<%
					}
				}
	
	%>
	
</body>
</html>