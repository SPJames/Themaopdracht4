package servlets.klantServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Klant;

/**
 * In deze servlet kan een klant de gegevens van zijn/haar account wijzigen.
 */
public class AccountWijzigenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//de huidige gebruiker wordt opgezocht in de klantenlijst
		@SuppressWarnings("unchecked")
		ArrayList<Klant> Users = (ArrayList<Klant>) req.getServletContext().getAttribute("alleUsers");
		Klant klant = null;
		for(Klant k : Users) {
			if(k.getUsername().equals(req.getSession().getAttribute("Username"))) {
				klant = k;
			}
		}
		
		String[] userinfo = new String[9];
		boolean error1 = false; //lege velden
		boolean error2 = false; //het ingevoerde wachtwoord is niet correct
		boolean error3 = false; //de nieuwe wachtwoorden zijn niet aan elkaar gelijk
		boolean error4 = false; //de emailadressen zijn niet aan elkaar gelijk
		boolean pwd = false; //er is een nieuw wachtwoord ingevoerd

		userinfo[0] = req.getParameter("username");
		userinfo[1] = req.getParameter("realname");
		userinfo[2] = req.getParameter("pwd");
		userinfo[3] = req.getParameter("newemail");
		userinfo[4] = req.getParameter("adres");
		userinfo[5] = req.getParameter("postcode");
		userinfo[6] = req.getParameter("newpwd");
		userinfo[7] = req.getParameter("newpwd2");
		userinfo[8] = req.getParameter("newemail2");

		//controleren of alles is ingevuld
		for (int i = 0; i < 6; i++) {
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				error1 = true;
			}
		}
		//controleren of het correcte wachtwoord is ingevuld
		if(!(userinfo[2].equals(klant.getPassword()))) {
			error2 = true;
		}
		
		//controleren of er een nieuw wachtwoord is opgegeven
		if ((userinfo[6] != null) || (userinfo[7] != null)) {
			if (!(userinfo[6].equals("")) || !(userinfo[7].equals(""))) {
				if (userinfo[6].equals(userinfo[7])) {
					pwd = true;
				} else {
					error3 = true;
				}
			}
		}
		
		//controleren of er een nieuw emailadress is opgegeven
		if((userinfo[8] != null) && !(userinfo[8].equals("")))
		{
			if(!(userinfo[3].equals(userinfo[8]))){
				error4 = true;
			}
		}
		
		//fout melding teruggeven
		RequestDispatcher rd = null;
		if (error1) {
			req.setAttribute("error", "Invoer was leeg of incorrect");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		} else if(error2) {
			req.setAttribute("error", "Wachtwoord is incorrect");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		}else if(error3){
			req.setAttribute("error", "Nieuwe wachtwoorden komen niet overeen");
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		}else if(error4){
			req.setAttribute("error", "Emailaddressen komen niet overeen");
			rd= req.getRequestDispatcher("accountwijzigen.jsp");
		}else { //sla nieuwe klant op, als invoer correct is
			klant.setUsername(userinfo[0]);
			klant.setNaam(userinfo[1]);
			klant.setPassword(userinfo[2]);
			klant.setEmail(userinfo[3]);
			klant.setAdres(userinfo[4]);
			klant.setPostcode(userinfo[5]);
			if(pwd) {
				klant.setPassword(userinfo[6]); //het nieuwe wachtwoord opslaan
			}
			
			req.setAttribute("msgs", "Gegevens succesvol opgeslagen!");
			Logger.getLogger("atd").info("Gebruiker <" + klant.getNaam() + "> is succesvol gewijzigd");
			req.getSession().setAttribute("Access", "Klant");
			req.getSession().setAttribute("Username", klant.getUsername());
			req.getSession().setAttribute("ID", klant.getId());
			
			//kunnen we niet beter naar het klant hoofdmenu gaan?
			rd = req.getRequestDispatcher("accountwijzigen.jsp");
		}
		rd.forward(req, resp);
	}
}