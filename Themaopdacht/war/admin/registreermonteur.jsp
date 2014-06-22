<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Register Monteur" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<div id="register">
		<h2>Register</h2>
		<jsp:include page="../message.jsp"/>
		<form action="RegistreerMonteurServlet.do" method="get">
			<fieldset>
				<label for="Realname">Naam</label><input type="text" name="Realname"
					placeholder="Realname" class="box" />
				<label for="pwd">Password</label><input type="password" name="pwd" 
					placeholder="password" class="box" />
				<label for="pwd2">Re-enter password</label><input type="password"
					name="pwd2" placeholder="password" class="box" />
				<input type="submit" value="Verzenden" class="down" />
			</fieldset>
		</form>
	</div>
</body>
</html>