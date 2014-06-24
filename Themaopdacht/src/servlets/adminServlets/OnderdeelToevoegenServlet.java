package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.voorraadbeheer.Onderdeel;

/**
 * In deze klasse kan de admin een nieuw onderdeel toevoegen aan de lijst onderdelen
 */
public class OnderdeelToevoegenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Als er een vak leeg is wordt de gebruiker teruggestuurd naar dit scherm en wordt er een foutmelding
	 * weergegeven.
	 * als het onderdeel al in de lijst stond wordt de gebruiker naar dit scherm teruggestuurd
	 * en wordt er een foutmelding gegeven.
	 * als er geen foutmeldingen gegeven zijn wordt het onderdeel aan de lijst toegevoegd en wordt
	 * de gebruiker teruggestuurd naar voorraadoverzicht.jsp waar een melding gegeven wordt
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[3];
		
		//de meegegeven gegevens
		userinfo[0] = req.getParameter("artikelnaam");
		userinfo[1] = req.getParameter("aantal");
		userinfo[2] = req.getParameter("PrijsArtikel");
		Onderdeel onderdeel = null;
		
		boolean error = false;	//leeg veld
		boolean error2 = false;	//bestaat al
		
		//controleer of alle velden zijn ingevuld
		for(int i = 0;  i < 3; i++){
			if(userinfo[i].equals(null) || userinfo[i].equals("")){
				error = true;
			}
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) sc.getAttribute("alleOnderdelen");
		
		// controleren of het onderdeel al bestaat
		RequestDispatcher rd = null;
		for(Onderdeel o : onderdelen){
			if(o.getNaam().equals(userinfo[0]))
			{
				error2 = true;
			}
		}
		
		//een nieuw onderdeel aanmaken met de ingevoerde gegevens
		onderdeel = new Onderdeel(Integer.parseInt(userinfo[1]), userinfo[0], Double.parseDouble(userinfo[2]));
		if(error){ //eerste error bericht, er was een veld leeg
			req.setAttribute("error", "��n of meerdere velden waren leeg");
			rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
		}
		if(error2){//tweede error bericht, het onderdeel is al in voorraad
			req.setAttribute("error", "Dit onderdeel bestaat al, ga naar onderdeel wijzigen om dit onderdeel aan te passen");
			rd = req.getRequestDispatcher("onderdeeltoevoegen.jsp");
		}
		if(!error && !error2){ //geen errors, alles kan doorgevoerd worden
			onderdelen.add(onderdeel);
			req.setAttribute("msgs", "Onderdeel succesvol toegevoegd!");
			Logger.getLogger("atd").info("Onderdeel <"+onderdeel.getNaam()+"> is toegevoegd");
			rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
		}
		rd.forward(req,resp);
	}
}