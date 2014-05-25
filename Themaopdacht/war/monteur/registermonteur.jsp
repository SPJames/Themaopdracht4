<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Register Monteur" />
	<jsp:param name="css" value="register" />
	<jsp:param name="path" value="../" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp" >
	<jsp:param name="path" value="../" />
	<jsp:param name="name" value="Home" />
</jsp:include>
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
	</div>
</body>
</html>