<!-- gebruiken voor fout/informatie meldingen -->
<div id="message">
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
		}
		
		Object error = request.getAttribute("error");
		if (error != null) {
			out.println(error);
		}
	%>
</div>