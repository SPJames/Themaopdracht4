<%@ page import="domein.financien.Factuur"%>
<%@ page import="java.util.*"%>
<%@ page import="domein.voorraadbeheer.Onderdeel"%>
<%@ page import="domein.voorraadbeheer.Brandstof"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Wijzig Factuur" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	<div id="register">
		<h2>Wijzig Factuur</h2>

		<%
			@SuppressWarnings("unchecked")
			ArrayList<Factuur> facturen = (ArrayList<Factuur>) application.getAttribute("alleFacturen");//alle facturen ophalen
			for(Factuur f: facturen){
				if(f.getFactuurNummer() == Integer.parseInt(request.getParameter("id"))){
					
					
		
		%>
		<jsp:include page="../message.jsp"/>
		<form action="WijzigFactuur.do" method="post">
			<input type="hidden" name="id" value="<%=f.getFactuurNummer() %>" />
			<label for="auto">Auto: </label>
			<input type="text" name="auto" value="<%=f.getKlus().getAuto().getKenteken()%>" readonly="readonly" class="box" />
			<!-- diensttype -->
			<label for="diensttype">Dienst Type: </label><br />
			<select name="diensttype"
				autofocus="<%=f.getKlus().getHetType().dienstType()%>" class="box">
				<option value="Onderhoud">Reparatie/Onderhoud/APK</option>
				<option value="Parkeren">Parkeren</option>
				<option value="Tanken">Tanken</option>
			</select>
			<!-- beschrijving klus -->
			<label for="comments">Comments: </label><br />
			<textarea rows="10" cols="50" name="comments"><%=f.getKlus().getBeschrijving()%></textarea><br />
			<label for="manuren">Manuren: </label>
			<input type="number" name="manuren" value="<%=f.getKlus().getManuren() %>" class="box" />
			<br />

			<!-- onderdelen -->
			<div id="onderdelen">
				<%
				int i =0;
					for(Map.Entry<Onderdeel, Integer> entry: f.getKlus().getGebruikteOnderdelen().entrySet()){
						i++;
				%>
						<label for="Okey<%=i %>">Onderdeel: </label>
						<input type="text" name="Okey<%=i %>" value="<%=entry.getKey().getNaam() %>" readonly="readonly" class="box" /><br />
						<label for="Ovalue<%=i %>">Aantal: </label>
						<input type="number" name="Ovalue<%=i %>" value="<%=entry.getValue() %>" class="box" /><br /><br />
						<a href="VerwijderOnderdeelBrandstof?id=<%=f.getFactuurNummer() %>&OofB=O&key=<%=entry.getKey().getNaam()%>">Verwijder dit onderdeel</a>
				<%
					}
				%>
			</div>

			<!-- brandstof -->
			<div id="brandstof">
				<%
				int j = 0;
					for(Map.Entry<Brandstof, Double> entry: f.getKlus().getGebruikteBrandstof().entrySet()){
						j++;
						%>
						<label for="Bkey<%=i %>">Brandstof: </label>
						<input type="text" name="Bkey<%=j %>" value="<%=entry.getKey().getBrandstofType() %>" readonly="readonly" class="box" /><br />
						<label for="Bkey<%=j %>"></label>
						<input type="number" name="Bvalue<%=j %>" step="any" value="<%=entry.getValue() %>" class="box" /><br />
						<a href="VerwijderOnderdeelBrandstof?id=<%=f.getFactuurNummer() %>&OofB=B&key=<%=entry.getKey().getBrandstofType()%>">Verwijder dit onderdeel</a>
						<%
					}
				%>
			</div>
			
			<label for="korting">Korting: </label>
			<input type="number" name="korting" value="<%=f.getKorting() %>" min="0" max="100" /><br />
			<input type="submit" value="Wijzig" />
		</form>
		<%
				}
			}	
		%>
	</div>
</body>
</html>