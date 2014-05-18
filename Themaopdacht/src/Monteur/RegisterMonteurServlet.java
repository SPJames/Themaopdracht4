package Monteur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Monteur;

public class RegisterMonteurServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[3];
		boolean error = false;
		@SuppressWarnings("unchecked")
		ArrayList<Monteur> Monteurs = (ArrayList<Monteur>) req.getServletContext()
				.getAttribute("allMonteurs");

		userinfo[0] = req.getParameter("Realname");
		userinfo[1] = req.getParameter("pwd");
		userinfo[2] = req.getParameter("pwd2");

		for (int i = 0; i < 3; i++) {
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error = true;
			}
		}
		if (!userinfo[1].equals(userinfo[2])) {
			error = true;
		}
		RequestDispatcher rd = null;
		
		if (error) {
			req.setAttribute("msgs",
					"Input was empty or password/email didn't match");
			rd = req.getRequestDispatcher("/monteur/registermonteur.jsp");

		} else {
			Monteur m = new Monteur(userinfo[0], userinfo[1]);
			m.schrijfWeg(userinfo);
			Monteurs.add(m);

			rd = req.getRequestDispatcher("/monteur/loginmonteur.jsp");

		}
		rd.forward(req, resp);

	}

}
