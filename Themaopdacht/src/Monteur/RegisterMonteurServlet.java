package Monteur;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterMonteurServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static int id = 1;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] userinfo = new String[3];
		boolean error = false;

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
			FileWriter fw = new FileWriter(
					"C:/xampp/tomcat/webapps/AccountSysteem/monteur/monteurs.dat",
					true);

			fw.write("\n" + id++ + " " + userinfo[0] + ":" + userinfo[1] + ";");
			fw.flush();
			fw.close();

			rd = req.getRequestDispatcher("/monteur/loginmonteur.jsp");

		}
		rd.forward(req, resp);

	}

}
