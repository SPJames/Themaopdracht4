<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>Klussenlijst</title>
<link rel="stylesheet" type="text/css" href="style-klussenlijst.css" />
</head>
<body>
	<div id="klus">
		<h2>Klussen</h2>

		<table>
			<tr>
				<th>Klus ID</th>
				<th>Klant ID</th>
				<th>Klant naam</th>
				<th>Klant title</th>
				<th>Diensttype</th>
				<th>Comments</th>
			</tr>
			<%@ page import="java.io.BufferedReader"%>
			<%@ page import="java.io.FileReader"%>
			<%
				BufferedReader br = new BufferedReader(new FileReader(
						"C:/xampp/tomcat/webapps/AccountSysteem/klussenaf.dat"));
				String str = "";
				while ((str = br.readLine()) != null) {
					if (str.length() > 0) {
						int endID = str.indexOf(":");
						int endKlantID = str.indexOf(";");
						int endKlantName = str.indexOf(",");
						int endTitle = str.indexOf(".");
						int endType = str.indexOf("|");
						int end = str.indexOf("/");
						String id = str.substring(0, (endID));
						String klantid = str.substring((endID + 1), (endKlantID));
						String klantname = str.substring((endKlantID + 1),
								(endKlantName));
						String title = str
								.substring((endKlantName + 1), (endTitle));
						String type = str.substring((endTitle + 1), (endType));
						String comments = str.substring((endType + 1), (end));

						out.print("<tr>");
						out.print("<td>" + id + "</td>");
						out.print("<td>" + klantid + "</td>");
						out.print("<td>" + klantname + "</td>");
						out.print("<td>" + title + "</td>");
						out.print("<td>" + type + "</td>");
						out.print("<td>" + comments + "</td>");
						out.print("<td><a href='../KlusFacturerenServlet?id=" + id
								+ "'>factuur maken</a></td>");
						out.print("</tr>");
					}
				}
				br.close();
			%>
		</table>
		<a href="../index.jsp">home</a>
	</div>
</body>
</html>