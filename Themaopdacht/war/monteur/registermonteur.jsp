<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Register Monteur" />
	<jsp:param name="css" value="register" />
	<jsp:param name="path" value="monteur/" />
</jsp:include>
<body>
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
		<form action="/Themaopdracht4/RegisterMonteurServlet.do" method="get">
			<fieldset>
				<label for="Realname">Naam</label><input type="text" name="Realname"
					placeholder="Realname" class="box" />
				<label for="pwd">Password</label><input type="password" name="pwd" 
					placeholder="password" class="box" />
				<label for="pwd2]">Re-enter password</label><input type="password"
					name="pwd2" placeholder="password" class="box" />
				<input type="submit" value="Verzenden" class="down" />
			</fieldset>
		</form>

		<a href="/Themaopdracht4/index.jsp">home</a>
	</div>
</body>
</html>