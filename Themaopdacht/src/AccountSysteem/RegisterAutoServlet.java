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
		boolean error2 = false;

		if (merk.equals("") || merk.equals(null)) {
			error = true;
		}
		if (kt.equals("") || kt.equals(null)) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (error) {
			req.setAttribute("msgs", "Een of meerdere velden waren leeg.");
			rd = req.getRequestDispatcher("autotoevoegen.jsp");
		} else {
			Auto a = new Auto(kt, merk, id);
			@SuppressWarnings("unchecked")
			ArrayList<Auto> Autos = (ArrayList<Auto>) req.getServletContext().getAttribute("allAutos");
			for(Auto auto : Autos) {
				if (auto.getKenteken().equals(kt)) {
					req.setAttribute("msgs", "Deze auto bestaat al.");
					rd = req.getRequestDispatcher("autotoevoegen.jsp");
					error2 = true;
					break;
				}
			}
			if(!error2) {
				Autos.add(a);
				req.setAttribute("msgs", "Auto succesvol toegevoegd!");
				rd = req.getRequestDispatcher("autos.jsp");
			}
		}
		rd.forward(req, resp);
	}
}
