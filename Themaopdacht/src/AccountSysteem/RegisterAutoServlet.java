package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import klantenbinding.Auto;

public class RegisterAutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String merk = req.getParameter("Merk");
		String kt = req.getParameter("Kenteken");
		String id = req.getParameter("klantid");
		boolean error = false;

		if (merk.equals("") || merk.equals(null)) {
			error = true;
		}
		if (kt.equals("") || kt.equals(null)) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (error) {
			req.setAttribute("msgs",
					"Input was empty or password/email didn't match");
			rd = req.getRequestDispatcher("register.jsp");

		} else {
			Auto a = new Auto(kt, merk, id);
			
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) req.getServletContext().getAttribute("allAutos");
			Autos.add(a);
			
			rd = req.getRequestDispatcher("login.jsp");
		}

		rd.forward(req, resp);

	}
}
