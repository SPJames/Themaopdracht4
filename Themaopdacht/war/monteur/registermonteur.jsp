<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Register</title>
<link rel="stylesheet" type="text/css" href="style-register.css" />
</head>
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
		<form action="../RegisterMonteurServlet.do" method="get">
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

		<a href="../index.jsp">home</a>
	</div>
</body>
</html>