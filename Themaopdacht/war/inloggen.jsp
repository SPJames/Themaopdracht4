<jsp:include page="header.jsp">
	<jsp:param name="title" value="Inloggen" />
	<jsp:param name="css" value="login" />
</jsp:include>
<body>
<jsp:include page="menu.jsp" />
	<div id="login">
		<h2>Login</h2>
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
		</div>
		<form action='InlogServlet.do' method='get'>
			<fieldset>
				<label for="username">Username</label>
				<input type='text' name='username' placeholder="Username" class="box" value="${param.username}"/><br /> 
				
				<label for="pwd">Password</label>
				<input type='password' name='pwd' placeholder="Password" class="box" /><br /> 
				
				<input type='submit' name='Go' class="down" /><br />
			</fieldset>
		</form>
	</div>
</body>
</html>