<jsp:include page="../Header.jsp">
	<jsp:param name="title" value="Klus Aanpassen" />
	<jsp:param name="css" value="register" />
	<jsp:param name="path" value="../" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp" >
	<jsp:param name="path" value="../" />
</jsp:include>
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
	<%! String id = "";
		String klantid ="";
		String klantname="";
		String title="";
		String type="";
		String comments="";
	%>
	<%
	//lezen uit file gegevens
	BufferedReader br = new BufferedReader(new FileReader("C:/xampp/tomcat/webapps/AccountSysteem/afspraken.dat"));
			String str = "";
			while((str=br.readLine())!=null){
				int endID = str.indexOf(":");
				int endKlantID = str.indexOf(";");
				int endKlantName = str.indexOf(",");
				int endTitle = str.indexOf(".");
				int endType = str.indexOf("|");
				int end = str.indexOf("/");
				id = str.substring(0, (endID));
				klantid = str.substring((endID+1), (endKlantID));
				klantname = str.substring((endKlantID+1), (endKlantName));
				title = str.substring((endKlantName+1), (endTitle));
				type = str.substring((endTitle+1), (endType));
				comments = str.substring((endType+1), (end));
				if(request.getParameter("id").equals(id)){
					break;
				}
			}
	br.close();
	
	%>
	<form action="../KlusAanmakenServlet.do" method="get">
		<input type="hidden" name="klantid" value="<%= id %>" />
		<input type="hidden" name="name" value="<%= klantname %>" />
		<input type="text" name="title" value="<%= title %>" />
		<!-- diensttype -->
		<select name="diensttype" autofocus="<%= type %>">
			<option value="rep">Reparatie/Onderhoud/APK</option>
			<option value="park">Parkeren</option>
			<option value="tank">Tanken</option>
		</select>
		<!-- beschrijving klus -->
		<textarea rows="10" cols="50" name="comments"><%= comments %></textarea>
		<input type="submit" value="Verzenden" />
	</form>


	<a href="testpage.html">Home</a>
</body>
</html>