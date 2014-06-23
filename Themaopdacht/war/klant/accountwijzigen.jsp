<%@ page import="domein.klantenbinding.Klant"%>
<%@ page import="java.util.ArrayList;"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Wijzig accountgegevens" />
	<jsp:param name="css" value="accountwijzigen" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="register">
		<h2>Wijzig accountgegevens</h2>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klant> Users = (ArrayList<Klant>) application.getAttribute("alleUsers");//alle klanten ophalen
			Klant klant = null;//temp klant aan maken
			for (Klant k : Users) {
				if (k.getUsername().equals(session.getAttribute("Username"))) {//kijken of de klant gelijk is aan de ingelogde klant
					klant = k;//temp klant vullen met alle info
				}
			}
		%>

		<jsp:include page="../message.jsp" />
		<form action="AccountWijzigenServlet.do" method="get">
			<fieldset>

				<!-- wijzig gegevens -->
				<p id="text">Wijzig account gegevens (laat van de gegevens die correct zijn het veld ongewijzigd):</p>

				<label for="username">Username</label> 
					<input type="text" name="username" value="<%=klant.getUsername()%>" class="box" />

				<label for="Realname">Naam</label> 
					<input type="text" name="realname" value="<%=klant.getNaam()%>" class="box" /> 
				<label for="adres">Adres</label> 
					<input type="text" name="adres" value="<%=klant.getAdres()%>" class="box" /> 
				<label for="postcode">Postcode</label> 
					<input type="text" name="postcode" value="<%=klant.getPostcode()%>" class="box" /> 
					
					<!-- wijzig email -->
				<label for="newemail">(Nieuw) Email</label> 
					<input type="email" name="newemail" value="<%=klant.getEmail()%>" class="box" />
				<label for="newemail2">Nieuw email controle</label> 
					<input type="email" name="newemail2" class="box" />

				<!-- wijzig wachtwoord -->
				<label for="newpwd">Nieuw wachtwoord</label> 
					<input type="password" name="newpwd" placeholder="password" class="box" /> 
				<label for="newpwd2">Nieuw wachtwoord controle</label> 
					<input type="password" name="newpwd2" placeholder="password" class="box" />

				<!-- wachtwoord bevesteging -->

				<p id="text">Vul uw wachtwoord in ter bevesteging van de wijziging:</p>

				<label for="pwd">Huidige wachtwoord</label> 
					<input type="password" name="pwd" placeholder="password" class="box" /> 
				<input type="submit" value="Verzenden" class="down-afspraak" />
			</fieldset>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>