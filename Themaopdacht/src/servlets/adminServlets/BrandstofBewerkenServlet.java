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

import domein.voorraadbeheer.Brandstof;

/**
 * In deze klasse kan de administrator de hoeveelheid en/of prijs van brandstof aanpassen
 */
public class BrandstofBewerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * In deze methode worden de gewijzigde gegevens opgeslagen bij het juiste brandstoftype
	 * Als er velden leegwaren wordt de gebruiker teruggestuurd naar deze pagina en wordt er een
	 * foutmelding gegeven.
	 * Als alles was ingevuld worden de gegevens gewijzigd en wordt de gebruiker doorgestuurd naar
	 * voorraadoverzicht.jsp en wordt er een bericht weergegeven.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[4];
			
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");
		
		//de doorgegeven/gewijzigde gegevens
		userinfo[0] = req.getParameter("artikelid");
		userinfo[1] = req.getParameter("type");
		userinfo[2] = req.getParameter("aantal");
		userinfo[3] = req.getParameter("PrijsLiter");
		Brandstof brandstof = null;
		RequestDispatcher rd = null;
			
		//de aan te passen brandstof opzoeken
		for(Brandstof b : brandstoffen){
			if(b.getTsic() == Integer.parseInt(userinfo[0]))
			{
				brandstof = b;
			}
		}
			
		for (int i = 0; i < 4; i++) {
			// er was een vak leeg
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("error", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("brandstofbewerken.jsp");
				break;
			} else {
				if (i == 2) {//aantal liters opslaan
					brandstof.setLiter(Double.parseDouble(userinfo[2]));
				} else if (i==3) {//prijs per liter opslaan
					brandstof.setPrijsPerLiter(Double.parseDouble(userinfo[3]));
					req.setAttribute("msgs", "Brandstof succesvol aangepast!");
					Logger.getLogger("atd").info("Brandstof <"+brandstof.getBrandstofType()+"> succesvol bijgewerkt");
					rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
				}
			}
		}
		rd.forward(req,resp);
	}
}