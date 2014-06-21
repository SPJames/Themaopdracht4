<%@ page import="domein.klusbeheer.Klus"%>
<%@ page import="java.util.ArrayList"%>

<jsp:include page="header.jsp">
	<jsp:param name="title" value="Error" />
	<jsp:param name="css" value="home" />
</jsp:include>
<body>
	<jsp:include page="menu.jsp" />

	<div id="Content">
		<h2>Uh oh! Er ging iets mis.</h2>
		<%
			Object error = request.getAttribute("error");
			if (error != null) {
		%>
		<div>
		<%=error%>
		</div>
		<%
			}
		%>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
<html>