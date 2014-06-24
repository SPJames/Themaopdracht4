package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.voorraadbeheer.Brandstof;

/**
 * In deze klasse kan de administrator een nieuw brandstoftype toevoegen
 */
public class BrandstofToevoegenServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	/**
	 * In deze methode wordt het nieuwe brandstoftype toegevoegd aan de lijst bestaande brandstoftypes
	 * Als er een veld leeg was wordt de gebruiker terug gestuurd naar deze pagina en wordt er een 
	 * foutmelding weergegeven
	 * als het brandstoftype al bestaat wordt de gebruiker teruggestuurd naar deze pagina en wordt
	 *  er een foutmelding weergegeven
	 * Als er geen errors zijn wordt het nieuwe brandstoftype toegevoegd aan de lijst bestaande brandstoffen
	 * en wordt de gebruiker teruggestuurd naar voorraadoverzicht.jsp en wordt er een melding gegeven.
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		String[] userinfo = new String[3];
		
		//de ingevoerde gegevens
		userinfo[0] = req.getParameter("type");
		userinfo[1] = req.getParameter("aantal");
		userinfo[2] = req.getParameter("PrijsLiter");
		Brandstof brandstof = null;
		
		boolean error = false;	//leeg veld
		boolean error2 = false;	//bestaat al
		
		//controleren of een veld leeg is
		for(int i = 0;  i < 3; i++){
			if(userinfo[i].equals(null) || userinfo[i].equals("")){
				error = true;
			}
		}
		
		//alle aanwezige brandstof opvragen
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstoffen = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");
		
		//controleren of de brandstof al in voorraad is
		RequestDispatcher rd = null;
		for(Brandstof b : brandstoffen){
			if(b.getBrandstofType().equals(userinfo[0]))
			{
				error2 = true;
			}
		}
		
		//nieuwe brandstof aanmaken met ingevoerde gegevens
		brandstof = new Brandstof(userinfo[0], Double.parseDouble(userinfo[1]), Double.parseDouble(userinfo[2]));
		if(error){//error 1, er was een leeg veld
			req.setAttribute("error", "één of meerdere velden waren leeg");
			rd = req.getRequestDispatcher("brandstoftoevoegen.jsp");
		}
		if(error2){//error 2, deze brandstof bestond al
			req.setAttribute("error", "Dit brandstoftype bestaat al, ga naar brandstof wijzigen om dit type aan te passen");
			rd = req.getRequestDispatcher("brandstoftoevoegen.jsp");
		}
		if(!error && !error2){ //geen errors de brandstof is toegevoegd
			brandstoffen.add(brandstof);
			req.setAttribute("msgs", "Brandstof succesvol toegevoegd!");
			rd = req.getRequestDispatcher("voorraadoverzicht.jsp");
		}
		rd.forward(req,resp);
	}
}