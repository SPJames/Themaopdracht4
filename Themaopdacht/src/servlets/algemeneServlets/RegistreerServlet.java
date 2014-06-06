package servlets.algemeneServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Database.Database;

import domein.klantenbinding.Klant;

public class RegistreerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[8];
		boolean error = false;

		userinfo[0] = req.getParameter("username");
		userinfo[1] = req.getParameter("realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("pwd2");
		userinfo[4] = req.getParameter("email");
		userinfo[5] = req.getParameter("email2");
		userinfo[6] = req.getParameter("adres");
		userinfo[7] = req.getParameter("postcode");

		// checken of alle 8 de velden zijn ingevuld
		for (int i = 0; i < 8; i++) {
			if (userinfo[i] == null) {
				error = true;
			} else if (userinfo[i].equals("")){
				error = true;
			}
		}

		// checken of password en email overeen komen
		if (!(userinfo[2].equals(userinfo[3])) && !(userinfo[4].equals(userinfo[5]))) {
			error = true;
		}
		
		// foutmelding
		if (error) {
			req.setAttribute("msgs", "Enkele velden waren leeg en/of het wachtwoord/email matchte niet.");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		} else {
			// klant opslaan
			Klant k = new Klant(userinfo[1], userinfo[6], userinfo[7], userinfo[4], userinfo[0], userinfo[2]);

			@SuppressWarnings("unchecked")
			ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
			Users.add(k);

			resp.sendRedirect("login.jsp");
		}
	}
}
