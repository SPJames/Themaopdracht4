<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Klus aanpassen</title>
</head>
<body>
	<%@ page import="java.io.BufferedReader"%>
	<%@ page import="java.io.FileReader"%>
	<h2>Klus aanpassen</h2>
	<div>
		<%
			Object msgs = request.getAttribute("msgs");
			if (msgs != null) {
				out.println(msgs);
			}
		%>
	</div>
	<%!String id = "";
	String klantid = "";
	String klantname = "";
	String title = "";
	String type = "";
	String comments = "";
	static int factuurid = 0;%>
	<%
		//lezen uit file gegevens
		BufferedReader br = new BufferedReader(
				new FileReader(
						"C:/xampp/tomcat/webapps/AccountSysteem/factuurgemaakt.dat"));
		String str = "";
		while ((str = br.readLine()) != null) {
			if (str.length() > 0) {
				int endID = str.indexOf(":");
				int endKlantID = str.indexOf(";");
				int endKlantName = str.indexOf(",");
				int endTitle = str.indexOf(".");
				int endType = str.indexOf("|");
				int end = str.indexOf("/");
				id = str.substring(0, (endID));
				klantid = str.substring((endID + 1), (endKlantID));
				klantname = str.substring((endKlantID + 1), (endKlantName));
				title = str.substring((endKlantName + 1), (endTitle));
				type = str.substring((endTitle + 1), (endType));
				comments = str.substring((endType + 1), (end));
				if (request.getAttribute("ID").equals(id)) {
					break;
				}
			}
		}
		br.close();
	%>
	<p>
		Dit is Factuur nummer: 
		<%=factuurid++%><br />

		Het is voor klant: <%=klantname%><br />
		met nummer: <%=id%><br />

		Title van het probleem: <%=title%><br />
		Type van het probleem: <%=type%><br />

		Eventuele commentaar: 
		<%=comments%></p>

	<a href="testpage.html">Home</a>
</body>
</html>