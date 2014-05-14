<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style-login.css" />
</head>
<body>
	<div id="login">
		<h2>Login</h2>
		<div>
			<%
				Object msgs = request.getAttribute("msgs");
				 	if(msgs != null){
				 		out.println(msgs);
				 	}
			%>
			<%
				Cookie[] cookies = null;
				 	cookies = request.getCookies();
				 	if(cookies!=null){
					 	for (Cookie c : cookies) { 
					 		if (c.getName().equals("C_Usertype") && c.getValue().equals("Klant")) { 
					 			response.sendRedirect("index.jsp");
					 		 	break; 
					 		} 
					 	} 
				 	}
			%>
		</div>
		<form action='LoginServlet.do' method='get'>
			<fieldset>
				<label for="username">Username</label><input type='text'
					name='username' placeholder="Username" class="box" /><br /> <label
					for="pwd">Password</label><input type='password' name='pwd'
					placeholder="Password" class="box" /><br /> <input type='submit'
					name='Go' class="down" /><br />
			</fieldset>
		</form>

		<a href="index.jsp">home</a>
	</div>
</body>
</html>