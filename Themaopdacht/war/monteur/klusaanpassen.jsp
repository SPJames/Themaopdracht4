<jsp:include page="../header.jsp">
	<jsp:param name="title" value="Klus Aanpassen" />
	<jsp:param name="css" value="register" />
</jsp:include>
<body>
<jsp:include page="../menu.jsp"/>
	<%@ page import="domein.klusbeheer.Klus"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="domein.voorraadbeheer.Onderdeel" %>
	<%@ page import="domein.voorraadbeheer.Brandstof" %>
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
	<div>
		<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
				}
			%>
	</div>
	<%
				@SuppressWarnings("unchecked")
				ArrayList<Klus> klussen = (ArrayList<Klus>) application.getAttribute("alleKlussen");
				@SuppressWarnings("unchecked")
				ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) application.getAttribute("alleOnderdelen");
				@SuppressWarnings("unchecked")
				ArrayList<Brandstof> brandstof = (ArrayList<Brandstof>) application.getAttribute("alleBrandstof");
				for (Klus k : klussen) {
					if (Integer.parseInt(request.getParameter("id")) == k.getKlusNummer()) {
						String id = "" + k.getKlusNummer();
						
						String auto = k.getAuto().getKenteken();
						String type = k.getHetType().toString();
						String commentaar = k.getBeschrijving();
						%>
						
	<form action="KlusBijwerkenServlet.do" method="get">
		<input type="hidden" name="klusid" value="<%= id %>" />
		<input type="text" name="auto" value="<%= auto %>" readonly="readonly" />
		<!-- diensttype -->
		<select name="diensttype" autofocus="<%= type %>">
			<option value="Onderhoud">Reparatie/Onderhoud/APK</option>
			<option value="Parkeren">Parkeren</option>
			<option value="Tanken">Tanken</option>
		</select>
		<!-- beschrijving klus -->
		<textarea rows="10" cols="50" name="comments"><%= commentaar %></textarea>
		<input type="number" name="manuren" value="<%= k.getManuren() %>" />
		<br />
		
		<!-- onderdelen -->
		<div id="onderdelen">
		<%for(int i =0; i<onderdelen.size();i++){ %>
			<div id="onderdeel<%=i%>" style="display:none;">
				<select name="onderdeel<%=i%>">
					<% for(Onderdeel o: onderdelen){%>
							<option value="<%=o.getNaam()%>"><%=o.getNaam()%></option>				
						<%}%>
				</select><br />
				<input type="number" name="aantal<%=i%>" min="0" value="0"><br />
				<button type="button" onClick="showNext(<%=i%>)">Show next</button><br />
			</div>
		<%} %>
		</div>
		
		<!-- brandstof -->
		<%for(int i =0; i<brandstof.size();i++){ %>
			<div id="brandstof<%=i%>" style="display:none;">
				<select name="brandstof<%=i%>">
					<% for(Brandstof b: brandstof){%>
							<option value="<%=b.getBrandstofType()%>"><%=b.getBrandstofType()%></option>				
						<%}%>
				</select><br />
				<input type="number" step="any" name="liters<%=i%>" min="0" value="0"><br />
				<button type="button" onClick="showNext2(<%=i%>)">Show next</button><br />
			</div>
		<%} %>
		</div>
		
		<input type="submit" value="Verzenden" />
	</form>
						
						<%
					}
				}
				%>
</body>
</html>