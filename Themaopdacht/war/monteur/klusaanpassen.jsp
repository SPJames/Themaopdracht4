<%@ page import="domein.klusbeheer.Klus"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domein.voorraadbeheer.Onderdeel"%>
<%@ page import="domein.voorraadbeheer.Brandstof"%>
<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klus Aanpassen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
	<jsp:include page="../menu.jsp" />
	
	<div id="register">
	
	<div id="klus">
		<h2>Klus aanpassen</h2>
		<script>
	$(document).ready(function(){$("#onderdeel0").css("display","inline");$("#brandstof0").css("display","inline");});
	function showNext(num){
		$("#onderdeel"+(num+1)).css("display","inline");
	}
	function showNext2(num){
		$("#brandstof"+(num+1)).css("display","inline");
	}
	</script>
		<jsp:include page="../message.jsp" />
		<%
			@SuppressWarnings("unchecked")
			ArrayList<Klus> klussen = (ArrayList<Klus>) application
					.getAttribute("alleKlussen");
			@SuppressWarnings("unchecked")
			ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) application
					.getAttribute("alleOnderdelen");
			@SuppressWarnings("unchecked")
			ArrayList<Brandstof> brandstof = (ArrayList<Brandstof>) application
					.getAttribute("alleBrandstof");
			for (Klus k : klussen) {
				if (Integer.parseInt(request.getParameter("id")) == k
						.getKlusNummer()) {
		%>
				
			<form action="KlusBijwerkenServlet.do" method="post">
				<input type="hidden" name="klusid" value="<%="" + k.getKlusNummer()%>" /> 
				<label for="auto">Auto: </label>
				<input type="text" name="auto" value="<%=k.getAuto().getKenteken()%>" readonly="readonly" class="box" />
				<!-- diensttype -->
				<label for="diensttype">Dienst Type: </label><br />
				<select name="diensttype"
					autofocus="<%=k.getHetType().dienstType()%>" class="box">
					<option value="Onderhoud">Reparatie/Onderhoud/APK</option>
					<option value="Parkeren">Parkeren</option>
					<option value="Tanken">Tanken</option>
				</select>
				<!-- beschrijving klus -->
				<label for="comments">Comments: </label><br />
				<textarea rows="10" cols="50" name="comments"><%=k.getBeschrijving()%></textarea><br />
				<label for="manuren">Manuren: </label>
				<input type="number" name="manuren" class="box" />
				<br />

				<!-- onderdelen -->
				<div id="onderdelen">
					<%
						for (int i = 0; i < onderdelen.size(); i++) {
					%>
					<div id="onderdeel<%=i%>" style="display: none;">
						<label for="onderdeel<%=i%>">Onderdeel nr <%=i %>: </label>
						<select name="onderdeel<%=i%>" class="box">
							<%
								for (Onderdeel o : onderdelen) {
							%>
							<option value="<%=o.getNaam()%>"><%=o.getNaam()%></option>
							<%
								}
							%>
						</select><br /> 
						<label for="aantal<%=i %>">Hoeveelheid: </label>
						<input type="number" name="aantal<%=i%>" min="0" value="0" class="box"><br />
						<button type="button" onClick="showNext(<%=i%>)">Show
							next</button>
						<br />
					</div>
					<%
						}
					%>
				</div>

				<!-- brandstof -->
				<%
					for (int i = 0; i < brandstof.size(); i++) {
				%>
				<div id="brandstof<%=i%>" style="display: none;">
					<label for="brandstof<%=i %>">Brandstof <%=i %>: </label>
					<select name="brandstof<%=i%>" class="box">
						<%
							for (Brandstof b : brandstof) {
						%>
						<option value="<%=b.getBrandstofType()%>"><%=b.getBrandstofType()%></option>
						<%
							}
						%>
					</select><br />
					<label for="liters">Aantal Liters: </label>
					<input type="number" step="any" name="liters<%=i%>" min="0"
						value="0" class="box"><br />
					<button type="button" onClick="showNext2(<%=i%>)">Show
						next</button>
					<br />
				</div>
				<%
					}
				%>

				<br />
				<input type="submit" value="Verzenden" />
			</form>
		</div>
		<%
			}
			}
		%>

	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>