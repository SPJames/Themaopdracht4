<jsp:include page="header.jsp">
	<jsp:param name="title" value="Registreren" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="menu.jsp" />
	<div id="register">
		<h2>Register</h2>
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
		</div>
		<form action="RegistreerServlet.do" method="get">
			<fieldset>
				<label for="username">Username</label>
				<input type="text" name="username" placeholder="Username" class="box" value="${param.username}"/>
				
				<label for="realname">Naam</label>
				<input type="text" name="realname" placeholder="Naam" class="box" value="${param.realname}"/>
				
				<label for="pwd">Wachtwoord</label>
				<input type="password" name="pwd" placeholder="Wachtwoord" class="box"/>
				
				<label for="pwd2">Wachtwoord controle</label>
				<input type="password" name="pwd2" placeholder="Wachtwoord" class="box"/>
				
				<label for="email">Email</label>
				<input type="email" name="email" placeholder="example@example.com" class="box" value="${param.email}"/> 
				
				<label for="email2">Email controle</label>
				<input type="email" name="email2" placeholder="example@example.com" class="box"/>
				
				<label for="adres">Adres</label>
				<input type="text" name="adres" placeholder="Adres" class="box" value="${param.adres}"/>
				
				<label for="postcode">Zipcode</label>
				<input type="text" name="postcode" placeholder="Postcode" class="box" value="${param.postcode}"/>
					
				<input type="submit" value="Verzenden" class="down" />
			</fieldset>
		</form>
	</div>
</body>
</html>