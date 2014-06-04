<jsp:include page="Header.jsp">
	<jsp:param name="title" value="Login" />
	<jsp:param name="css" value="login" />
</jsp:include>
<body>
<jsp:include page="menu.jsp">
	<jsp:param name="name" value="Home" />
</jsp:include>
	<div id="login">
		<h2>Login</h2>
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
				
				String name = "";
				Object login = session.getAttribute("Username");
				if (login != null) {
					if (!(session.getAttribute("Username").equals(""))) {
						name = (String) session.getAttribute("Username");
					} 
				}else {
					name = "Username";
				}
			%>
		</div>
		<form action='LoginServlet.do' method='get'>
			<fieldset>
				<label for="username">Username</label><input type='text'
					name='username' placeholder="<%=name%>" class="box" /><br /> <label
					for="pwd">Password</label><input type='password' name='pwd'
					placeholder="Password" class="box" /><br /> <input type='submit'
					name='Go' class="down" /><br />
			</fieldset>
		</form>
	</div>
</body>
</html>