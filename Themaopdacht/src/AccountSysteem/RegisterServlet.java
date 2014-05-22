package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Database.Database;
import klantenbinding.Klant;

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[8];
		boolean error = false;

		userinfo[0] = req.getParameter("Username");
		userinfo[1] = req.getParameter("Realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("pwd2");
		userinfo[4] = req.getParameter("email");
		userinfo[5] = req.getParameter("email2");
		userinfo[6] = req.getParameter("Adress");
		userinfo[7] = req.getParameter("Postcode");

		for (int i = 0; i < 8; i++) {
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error = true;
			}
		}
		if (!userinfo[2].equals(userinfo[3])) {
			error = true;
		}
		if (!userinfo[4].equals(userinfo[5])) {
			error = true;
		}
		RequestDispatcher rd = null;
		if (error) {
			req.setAttribute("msgs",
					"Input was empty or password/email didn't match");
			rd = req.getRequestDispatcher("register.jsp");

		} else {
			Klant k = new Klant(userinfo[1], userinfo[6], userinfo[7],userinfo[4],userinfo[0],userinfo[2]);
			
			// werk voor sprint 3
			//Database.schrijfUserWeg(userinfo);
			
			@SuppressWarnings("unchecked")
			ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("allUsers");
			Users.add(k);

			rd = req.getRequestDispatcher("login.jsp");
		}

		rd.forward(req, resp);

	}
}
