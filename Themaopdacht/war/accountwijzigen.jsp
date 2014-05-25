<jsp:include page="Header.jsp">
	<jsp:param name="title" value="wijzig accountgegevens" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="menu.jsp" />
	<div id="register">
		<h2>Wijzig accountgegevens</h2>
		
		<%@ page import="klantenbinding.Klant"%>
		<%@ page import="java.util.ArrayList;" %>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klant> Users = (ArrayList<Klant>) application.getAttribute("allUsers");
			Klant klant = null;
			for(Klant k : Users) {
				if(k.getUsername().equals(session.getAttribute("Username"))) {
					klant = k;
				}
			}
		%>
		
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
		</div>
		<form action="AccountWijzigenServlet.do" method="get">
			<fieldset>
			
				<!-- change regular data -->
				<p id="text">Wijzig account gegevens (laat van de gegevens die correct zijn het veld ongewijzigd):</p>
				
				<label for="Username">Username</label><input type="text" name="Username" 
					value="<%= klant.getUsername() %>" class="box" />
					
				<label for="Realname">Realname</label><input type="text" name="Realname"
					value="<%= klant.getNaam() %>" class="box" />
					
				<label for="Adress">Adress</label><input type="text" name="Adress"
					value="<%= klant.getAdres() %>" class="box" />
					
				<label for="Postcode">Postcode</label><input type="text" name="Postcode" 
					value="<%= klant.getPostcode() %>" class="box" />
					
				<label for="email">Email</label><input type="email" name="email"
					value="<%= klant.getEmail() %>" class="box" /> 
					
				<!-- change password -->
					
				<p id="text">Vul uw wachtwoord in ter bevesteging van de wijziging:</p>
				
				<label for="pwd">Password</label><input type="password" name="pwd" 
					placeholder="password" class="box" />
					
				<input type="submit" value="Verzenden" class="down" />
			</fieldset>
		</form>

		<a href="index.jsp">home</a>
	</div>
</body>
</html>