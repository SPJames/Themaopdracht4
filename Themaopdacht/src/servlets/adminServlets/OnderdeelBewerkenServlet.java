package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.voorraadbeheer.Onderdeel;

/**
 * In deze klasse kan de admin de prijs en/of de hoeveelheid aanwezige onderdelen wijzigen
 */
public class OnderdeelBewerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	/**
	 * Er wordt gecontroleert of alle vakken ingevuld zijn, zoniet dan wordt de gebruiker 
	 * teruggestuurd naar dit scherm en wordt er een foutmelding weergegeven.
	 * als alles ingevuld is worden de gewijzigde gegevens opgeslagen en wordt de gebruiker terug
	 * gestuurd naar voorraadoverzicht.jsp en wordt er een melding weergegeven
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[4];
			
		@SuppressWarnings("unchecked")
		ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) sc.getAttribute("alleOnderdelen");
		
		userinfo[0] = req.getParameter("artikelid");
		userinfo[1] = req.getParameter("artikelnaam");
		userinfo[2] = req.getParameter("aantal");
		userinfo[3] = req.getParameter("PrijsArtikel");
	
		Onderdeel onderdeel = null;
		RequestDispatcher rd = null;
			
		for(Onderdeel o : onderdelen){
			if(o.getArtikelNr() == Integer.parseInt((userinfo[0])))
			{
				onderdeel = o;
			}
		}
			
		for (int i = 0; i < 4; i++) {
			// foutmelding
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("error", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("onderdeelbewerken.jsp");
				break;
			} else {
				if (i == 2) {
					onderdeel.setAantal(Integer.parseInt(userinfo[2]));
				} else if (i==3) {
					onderdeel.setPrijsArtikel(Double.parseDouble(userinfo[3]));
					req.setAttribute("msgs", "Onderdeel succesvol aangepast!");
					rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
				}
			}
		}
		rd.forward(req,resp);
	}
}