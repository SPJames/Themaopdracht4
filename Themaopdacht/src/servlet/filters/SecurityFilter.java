package servlet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {
		/* Filter is being placed into service, do nothing. */
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r2 = (HttpServletRequest) req;
		if (r2.getSession().getAttribute("user") == null) {
			r2.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void destroy() {
		/* Filter is being taken out of service, do nothing. */
	}
}