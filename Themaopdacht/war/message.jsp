<!-- gebruiken voor fout/informatie meldingen -->
<div id="message">
			<!-- message -->
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
			%>
			<div id="msgs">
				<%
					out.println(msgs);
				%>
			</div>
			<%
				}
			%>
			<!-- error -->
			<%
				Object error = request.getAttribute("error");
				if (msgs != null) {
			%>
			<div id="error">
				<%
					out.println(msgs);
				%>
			</div>
			<%
				}
			%>

</div>