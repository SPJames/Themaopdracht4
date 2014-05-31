package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import klantenbinding.Auto;
//import Database.Database;
import klantenbinding.Klant;

public class AccountWijzigenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Klant wordt de huidige gebruiker.
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("allUsers");
		Klant klant = null;
		for(Klant k : Users) {
			if(k.getUsername().equals(req.getSession().getAttribute("Username"))) {
				klant = k;
			}
		}
		
		String[] userinfo = new String[6];
		boolean error1 = false; //empty data check
		boolean error2 = false; //wrong password check

		userinfo[0] = req.getParameter("Username");
		userinfo[1] = req.getParameter("Realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("email");
		userinfo[4] = req.getParameter("Adress");
		userinfo[5] = req.getParameter("Postcode");

		//check of alles is ingevuld
		for (int i = 0; i < 6; i++) {
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error1 = true;
			}
		}
		//check of het wachtwoord correct is
		if(!(userinfo[2].equals(klant.getPassword()))) {
			error2 = true;
		}
		
		//fout melding teruggeven
		RequestDispatcher rd = null;
		if (error1) {
			req.setAttribute("msgs", "Invoer was leeg");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");

		} else if(error2) {
			req.setAttribute("msgs", "Wachtwoord is incorrect");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		} else { //sla nieuwe klant op, als invoer correct is
			Klant newKlant = new Klant(userinfo[1],userinfo[4],userinfo[5],userinfo[3],userinfo[0],userinfo[2]);
			
			// werk voor sprint 3
			//Database.schrijfUserWeg(userinfo);
			int id = klant.getId();
			Calendar laatstbezocht = klant.getLaatstBezochtRaw();
			ArrayList<Auto> autos = klant.getAlleAutos();
			Users.remove(klant);
			Users.add(newKlant);
			newKlant.setId(id);
			newKlant.setAlleAutos(autos);
			newKlant.setLaatstBezocht(laatstbezocht);
			
			req.setAttribute("msgs", "Gegevens succesvol opgeslagen!");
			
			req.getSession().setAttribute("Access", "Klant");
			req.getSession().setAttribute("Username", newKlant.getUsername());
			req.getSession().setAttribute("ID", klant.getId());
			
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		}

		rd.forward(req, resp);

	}
}
