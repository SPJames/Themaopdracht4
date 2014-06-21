package servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilterAdmin implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		/* Filter is being placed into service, do nothing. */
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		// Alleen admins mogen bij admin pagina's/servlets komen
		if (r2.getSession().getAttribute("Access") != null) {
			if (!r2.getSession().getAttribute("Access").equals("Admin")) {
				r2.setAttribute("error", "U heeft geen toegang tot deze pagina");
				r2.getRequestDispatcher("../error.jsp").forward(req, resp);
			} else {
				chain.doFilter(req, resp);
			}
		} else {
			r2.setAttribute("error", "U moet inloggen om bij deze pagina te komen");
			r2.getRequestDispatcher("../error.jsp").forward(req, resp);
		}
	}

	public void destroy() {
		/* Filter is being taken out of service, do nothing. */
	}
}