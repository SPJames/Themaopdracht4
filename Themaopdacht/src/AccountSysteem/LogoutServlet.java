package AccountSysteem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getSession().setAttribute("Access", "");
		req.getSession().setAttribute("Username", "");
		req.getSession().setAttribute("ID", "");
		resp.sendRedirect("index.jsp");
	}
	
}
