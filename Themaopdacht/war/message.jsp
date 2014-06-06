<!-- gebruiken voor fout/informatie meldingen -->
<div id="message">
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
		}
	%>
</div>