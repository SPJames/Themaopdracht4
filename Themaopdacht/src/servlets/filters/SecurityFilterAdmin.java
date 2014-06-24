package servlets.filters;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Deze servlet zorgt voor de filters voor de paginas die alleen door de admin bezocht mogen worden
 */
public class SecurityFilterAdmin implements Filter {
	
	/**
	 * Deze methode zorgt dat het filter geplaatst wordt
	 */
	public void init(FilterConfig arg0) throws ServletException {
		/* Filter is being placed into service, do nothing. */
	}

	/**
	 * De methode controleert of de gebruiker de goede Access rang heeft om de opgevraagde pagina te bezoeken.
	 * Als de gebruiker de goede rang heeft wordt de pagina getoond.
	 * Als de gebruiker de goede rang niet heeft wordt een foutmelding getoond
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		// Alleen admins mogen bij admin pagina's/servlets komen
		if (r2.getSession().getAttribute("Access") != null) {
			if (!r2.getSession().getAttribute("Access").equals("Admin")) {
				r2.setAttribute("error", "U heeft geen toegang tot deze pagina");
				Logger.getLogger("atd").info("Gebruiker op het IP '"+r2.getRemoteAddr()+"' zocht toegang naar een pagina waar hij geen rechten heeft");
				r2.getRequestDispatcher("../error.jsp").forward(req, resp);
			} else {
				chain.doFilter(req, resp);
			}
		} else {
			r2.setAttribute("error", "U moet inloggen om bij deze pagina te komen");
			Logger.getLogger("atd").info("Gast op het IP '"+r2.getRemoteAddr()+"' zocht toegang naar een pagina waar hij geen rechten heeft");
			r2.getRequestDispatcher("../error.jsp").forward(req, resp);
		}
	}

	/**
	 * Deze methode kan de filter verwijderen.
	 */
	public void destroy() {
		/* Filter is being taken out of service, do nothing. */
	}
}