package servlets.algemeneServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UitlogServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Via deze server kan een gebruiker uitloggen.
	 * De attributen die waren opgeslagen bij het inloggen worden leeggemaakt en de 
	 * gebruiker wordt doorgestuurd naar de hoofdpagina.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// attributen leeg maken, bij uitloggen
		req.getSession().setAttribute("Access", "");
		req.getSession().setAttribute("Username", "");
		req.getSession().setAttribute("ID", "");
		req.getSession().invalidate();
		resp.sendRedirect("index.jsp");
	}
}