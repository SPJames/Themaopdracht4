<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Register" />
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
		<form action="RegisterServlet.do" method="get">
			<fieldset>
				<label for="Username">Username</label><input type="text"
					name="Username" placeholder="username" class="box" />
				<label for="Realname">Realname</label><input type="text" name="Realname"
					placeholder="Realname" class="box" />
				<label for="pwd">Password</label><input type="password" name="pwd" 
					placeholder="password" class="box" />
				<label for="pwd2]">Re-enter password</label><input type="password"
					name="pwd2" placeholder="password" class="box" />
				<label for="email">Email</label><input type="email" name="email"
					placeholder="example@example.com" class="box" /> 
				<label for="email2">Re-enter email</label><input type="email"
					name="email2" placeholder="example@example.com" class="box" />
				<label for="Adress">Adress</label><input type="text" name="Adress"
					placeholder="Adress" class="box" />
				<label for="Postcode">Postcode</label><input type="text" name="Postcode" 
					placeholder="Postcode" class="box" />
				<input type="submit" value="Verzenden" class="down" />
			</fieldset>
		</form>

		<a href="index.jsp">home</a>
	</div>
</body>
</html>