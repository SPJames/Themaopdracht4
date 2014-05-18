package Monteur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Klusbeheer.Monteur;

public class LoginMonteurServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("username");
		String password = req.getParameter("pwd");
		boolean error = false;
		@SuppressWarnings("unchecked")
		ArrayList<Monteur> Monteurs = (ArrayList<Monteur>) req.getServletContext()
				.getAttribute("allMonteurs");
		
		if(username.equals("") || username.equals(null)){
			error = true;
		}
		if(password.equals("") || password.equals(null)){
			error = true;
		}
		RequestDispatcher rd = null;
		if(Monteurs.size() == 0){
			req.setAttribute("msgs",
					"Er zijn nog geen monteurs in het systeem.");
			rd = req.getRequestDispatcher("/monteur/registermonteur.jsp");
		}
		if(error){
			req.setAttribute("msgs", "Input was empty");
			rd = req.getRequestDispatcher("/monteur/loginmonteur.jsp");
		}else{
			for (Monteur m : Monteurs) {
				if (m.getNaam().equals(username)
						&& m.getPassword().equals(password)) {
					Cookie c = new Cookie("C_Username", username);
					c.setMaxAge(3600 * 24 * 365);
					resp.addCookie(c);
					Cookie c2 = new Cookie("C_Usertype", "Monteur");
					c2.setMaxAge(3600 * 24 * 365);
					resp.addCookie(c2);
					rd = req.getRequestDispatcher("index.jsp");
					break;
				} else {
					req.setAttribute("msgs", "Unknown username/password combo");
					rd = req.getRequestDispatcher("login.jsp");
				}

			}

		}
		rd.forward(req,resp);
	}

}
