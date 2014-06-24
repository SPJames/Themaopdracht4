package servlets.monteurServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.klantenbinding.Auto;
import domein.klusbeheer.Klus;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

/**
 * In deze servlet kan een klus bijgewerkt worden.
 */
public class KlusBijwerkenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Eerst wordt de klus opgehaalt.
	 * 
	 * Aan het eind wordt gecontroleert of alle velden zijn ingevuld. Zo niet dan wordt de monteur
	 * teruggestuurd naar deze pagina en wordt er een foutmelding weergegeven.
	 * 
	 * Als alle velden zijn ingevuld worden de nieuwe gegevens opgeslagen en wordt de monteur
	 * teruggestuurd naar de klussenlijst en wordt daar een melding weergegeven dat de wijzigingen
	 * doorgevoert zijn.
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext sc = req.getServletContext();
		
		boolean error = false; //lege velden
		
		String[] userinfo = new String[3];
		@SuppressWarnings("unchecked")
		ArrayList<Klus> Klussen = (ArrayList<Klus>) sc.getAttribute("alleKlussen");
		@SuppressWarnings("unchecked")
		ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) sc.getAttribute("alleOnderdelen");
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstof = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");

		userinfo[0] = req.getParameter("klusid");// klusid voor foreign key
		userinfo[1] = req.getParameter("diensttype");
		userinfo[2] = req.getParameter("comments");
		Auto auto = null;
		
		int manuren = Integer.parseInt(req.getParameter("manuren"));
		
		//onderdelen
		String[] onderdeelnaam = new String[onderdelen.size()];
		for(int i=0; i<onderdelen.size(); i++) {
			onderdeelnaam[i] = req.getParameter("onderdeel"+i);
		}
		int[] onderdeelaantal = new int[onderdelen.size()];
		for(int i=0; i<onderdelen.size(); i++) {
			onderdeelaantal[i] = Integer.parseInt(req.getParameter("aantal"+i));
		}
		
		//brandstof
		String[] brandstofnaam = new String[brandstof.size()];
		for(int i=0; i<brandstof.size(); i++) {
			brandstofnaam[i] = req.getParameter("brandstof"+i);
		}
		double[] brandstofliters = new double[brandstof.size()];
		for(int i=0; i<brandstof.size(); i++) {
			brandstofliters[i] = Double.parseDouble(req.getParameter("liters"+i));
		}

		Klus klus = null;
		for (Klus k : Klussen) {
			// klus invoer ophalen
			if (k.getKlusNummer() == Integer.parseInt(userinfo[0])) {
				klus = k;
			}
		}

		@SuppressWarnings("unchecked")
		ArrayList<Auto> autos = (ArrayList<Auto>) sc.getAttribute("alleAutos");
		for (Auto a : autos) {
			if (a.getKenteken().equals(req.getParameter("auto"))) {
				auto = a;
			}
		}

		RequestDispatcher rd = null;
		for (int i = 0; i < 3; i++) {
			// foutmelding
			if (userinfo[i].equals("") || userinfo[i].equals(null)) {
				req.setAttribute("error", "Sommige velden waren leeg.");
				rd = req.getRequestDispatcher("klusaanpassen.jsp");
				error = true;
				break;
			} else {
				if (i == 1) {
					klus.setHetType(userinfo[1]);
				} else if (i == 2) {
					klus.setBeschrijving(userinfo[2]);
					req.setAttribute("msgs", "Klus succesvol aangepast.");
					Logger.getLogger("atd").info("Klus "+userinfo[0]+" is succesvol bijgewerkt");
					rd = req.getRequestDispatcher("klussenlijst.jsp");
					auto.setInReparatie(true);
				}
			}
		}
		if(!error) {
			if(manuren != 0) {
				klus.addManuren(manuren);
			}
			
			//brandstof
			for(int i=0;i < brandstof.size(); i++) {
				if (!(brandstofnaam[i].equals("")) && !(brandstofliters[i] == 0)) {
					Brandstof br = null;
					for(Brandstof b : brandstof) {
						if(b.getBrandstofType().equals(brandstofnaam[i])) {
							br = b;
						}
					}
					klus.addBrandstof(br, brandstofliters[i]);
				}
			}
			
			//onderdelen
			for(int i=0;i < onderdelen.size(); i++) {
				if (!(onderdeelnaam[i].equals("")) && !(onderdeelaantal[i] == 0)) {
					Onderdeel ond = null;
					for(Onderdeel o : onderdelen) {
						if(o.getNaam().equals(onderdeelnaam[i])) {
							ond = o;
						}
					}
					klus.addOnderdeel(ond, onderdeelaantal[i]);
				}
			}
		}
		rd.forward(req, resp);
	}
}