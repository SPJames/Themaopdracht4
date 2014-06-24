<%@ page import="domein.klantenbinding.Klant"%>
<%@ page import="domein.klantenbinding.Auto"%>
<%@ page import="java.util.ArrayList"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Afspraak maken" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="register">
		<h2>Afspraak maken</h2>
		<jsp:include page="../message.jsp" />
		
		<%
			String id = "" + (Integer) session.getAttribute("ID");//id locaal opslaan
			String name = (String) session.getAttribute("Username");//username locaal opslaan
			//allebij "hidden" in vullen in de form zodat we ze straks kunnen gebruiken
		%>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klant> klanten = (ArrayList<Klant>) application.getAttribute("alleUsers");//alle users ophalen
			for (Klant k : klanten) {
				if (k.getId() == (Integer.parseInt(id))) {//kijken of de klant id gelijk is aan de ingelogde klant id
					ArrayList<Auto> autos = k.getAlleAutos();//alle autos van die klant
					if (autos.size() > 0) {//save guard voor als hij leeg is
		%>

		<form action="KlusAanmakenServlet.do" method="post">
			<input type="hidden" name="klantid" value="<%=id%>" /> 
			<input type="hidden" name="name" value="<%=name%>" />

			<div id="select">
			<!-- Auto -->
			<label for="auto">Auto: </label>
			<select name="auto" class="box">
				<%
					for (Auto a : autos) {
						if (!a.isInReparatie()) {//als auto in reparatie is(aka in de winkel) kan hij niet opnieuw als een klus worden aan gemaakt
				%>
				<option value="<%=a.getKenteken()%>"><%=a.getKenteken()%></option>
				<%
									}
								}
							
				%>
			</select>
			<br />
			<!-- diensttype -->
			<label for="diensttype">Dienst Type: </label>
			<select name="diensttype" class="box">
				<option value="rep">Reparatie/Onderhoud/APK</option>
				<option value="park">Parkeren</option>
				<option value="tank">Tanken</option>
			</select>
		
			</div>
			
			<!-- beschrijving klus -->
			<label for="comments">Comments: </label>
			<textarea rows="10" cols="50" name="comments"></textarea><br />
			<input class="down-afspraak" type="submit" value="Verzenden" />
		</form>
		<%
					}
					else{%>
						nog geen auto's geregistreed!
						<a href="autotoevoegen.jsp">Voeg nu een auto toe</a>	
					
					<%}
					break;
				}
			}
		
		%>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>