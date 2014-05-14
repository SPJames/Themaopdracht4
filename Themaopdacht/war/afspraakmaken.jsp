<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
	<title>Afspraak maken</title>
</head>
<body>

	<h2>Afspraak maken</h2>
	<div>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
		</div>
	<%
	String id = "";
	String name = "";
	for (Cookie c : request.getCookies()) { 
 		if (c.getName().equals("C_ID")) { 
 			id = c.getValue();
 		} 
 		if (c.getName().equals("C_Username")) { 
 			name = c.getValue(); 
 		} 
 	}  %>


	<form action="KlusAanmakenServlet.do" method="get">
		<input type="hidden" name="klantid" value="<%= id %>" />
		<input type="hidden" name="name" value="<%= name %>" />
		<input type="text" name="title" />
		<!-- diensttype -->
		<select name="diensttype">
			<option value="rep">Reparatie/Onderhoud/APK</option>
			<option value="park">Parkeren</option>
			<option value="tank">Tanken</option>
		</select>
		<!-- beschrijving klus -->
		<textarea rows="10" cols="50" name="comments"></textarea>
		<input type="submit" value="Verzenden" />
	</form>


	<a href="testpage.html">Home</a>
</body>
</html>