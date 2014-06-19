package servlets.klantServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Klant;

public class AccountWijzigenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * In deze servlet kan een klant de gegevens van zijn/haar account wijzigen.
	 * Eerst wordt de klant opgezocht.
	 * 
	 * Na het veranderen wordt gecontroleert of alle vakjes ingevuld zijn, zoniet wordt
	 * de klant teruggestuurd naar deze pagina met een foutmelding.
	 * 
	 * Als alles ingevult is wort gecontroleert of het wachtwoord is verandert en zoja of beide
	 * ingevulde wachtwoorden met elkaar overeenkomen. zoniet wordt de klant teruggestuurd naar deze
	 * pagina met een foutmelding.
	 * 
	 * Als er geen foutmeldingen zijn worden de nieuwe gegevens opgeslagen en wordt de klant doorgestuurd
	 * naar deze pagina met de melding dat de gegevens zijn gewijzigd.
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//Klant wordt de huidige gebruiker.
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
		Klant klant = null;
		for(Klant k : Users) {
			if(k.getUsername().equals(req.getSession().getAttribute("Username"))) {
				klant = k;
			}
		}
		
		String[] userinfo = new String[8];
		boolean error1 = false; //empty data check
		boolean error2 = false; //wrong password check
		boolean pwd = false;

		userinfo[0] = req.getParameter("username");
		userinfo[1] = req.getParameter("realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("email");
		userinfo[4] = req.getParameter("adres");
		userinfo[5] = req.getParameter("postcode");
		
		userinfo[6] = req.getParameter("newpwd");
		userinfo[7] = req.getParameter("newpwd2");

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
		
		//check of er een nieuw wachtwoord is opgegeven
		if ((userinfo[6] != null) && (userinfo[7] != null)) {
			if (!(userinfo[6].equals("")) && !(userinfo[7].equals(""))) {
				if (userinfo[6].equals(userinfo[7])) {
					pwd = true;
				} else {
					error1 = true;
				}
			}
		}
		
		//nog controle toevoegen voor nieuw emailadress
		
		//fout melding teruggeven
		RequestDispatcher rd = null;
		if (error1) {
			req.setAttribute("error", "Invoer was leeg of incorrect");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		} else if(error2) {
			req.setAttribute("error", "Wachtwoord is incorrect");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		} else { //sla nieuwe klant op, als invoer correct is
			klant.setUsername(userinfo[0]);
			klant.setNaam(userinfo[1]);
			klant.setPassword(userinfo[2]);
			klant.setEmail(userinfo[3]);
			klant.setAdres(userinfo[4]);
			klant.setPostcode(userinfo[5]);
			if(pwd) {
				klant.setPassword(userinfo[6]);
			}
			
			req.setAttribute("msgs", "Gegevens succesvol opgeslagen!");
			
			req.getSession().setAttribute("Access", "Klant");
			req.getSession().setAttribute("Username", klant.getUsername());
			req.getSession().setAttribute("ID", klant.getId());
			
			//kunnen we niet beter naar het klant hoofdmenu gaan?
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		}

		rd.forward(req, resp);

	}
}
