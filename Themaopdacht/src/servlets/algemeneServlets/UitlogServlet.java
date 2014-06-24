package servlets.algemeneServlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Via deze server kan een gebruiker uitloggen.
 */
public class UitlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * De attributen die waren opgeslagen bij het inloggen worden leeggemaakt en de 
	 * gebruiker wordt doorgestuurd naar de hoofdpagina.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// attributen leeg maken, bij uitloggen
		Logger.getLogger("atd").info("Gebruiker <" + req.getSession().getAttribute("Username") + "> is uitgelogd");
		req.getSession().setAttribute("Access", "");
		req.getSession().setAttribute("Username", "");
		req.getSession().setAttribute("ID", "");
		req.getSession().invalidate();
		
		resp.sendRedirect("index.jsp");
	}
}