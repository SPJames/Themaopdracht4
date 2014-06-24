<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Brandstof Toevoegen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<%@ page import="domein.voorraadbeheer.Brandstof"%>
	<div id="register">
		<h2>Brandstof Toevoegen</h2>
		<jsp:include page="../message.jsp"/>
	<!-- Hier worden de gegevens van de nieuwe brandstof ingevoerd -->
		<form action="BrandstofToevoegenServlet.do" method="post">
			<fieldset>
				<label for="type">Brandstof Type</label>
				<input type="text"	name="type" placeholder="Brandstof Type" class="box"
					value="${param.artikelnaam}" />
				<label for="aantal">Aantal Liters</label>
				<input type="number" name="aantal"  class="box" min="1"
					value="1" />
				<label for="PrijsLiter">Prijs per Liter</label>
				<input type="number" step="any" name="PrijsLiter" class="box" min="1.00" value="1.50" />
				<input type="submit" value="Toevoegen" class="down"/>	
			</fieldset>
		</form>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>