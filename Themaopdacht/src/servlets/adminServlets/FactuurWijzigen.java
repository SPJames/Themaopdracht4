package servlets.adminServlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domein.financien.Factuur;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

/**
 * In deze klasse kan een factuur gewijzigd worden
 */
public class FactuurWijzigen extends HttpServlet{

	/**
	 * Deze methode vraagt alle gegevens van de doorgegeven factuurid op
	 * De gegevens van de klus kunnen gewijzigd worden en worden meteen gecontroleerd op correcte invoer
	 * 
	 * Als er incorrecte invoer is wordt de gebruiker teruggestuurd naar dit scherm en wordt er een
	 * foutmelding weergegeven.
	 * 
	 * Als er geen errors zijn worden de gegevens opgeslagen
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ServletContext sc = req.getServletContext();
		int id = Integer.parseInt(req.getParameter("id"));
		String factuurinfo[] = new String[4];
		factuurinfo[0] = req.getParameter("auto");
		factuurinfo[1] = req.getParameter("diensttype");
		factuurinfo[2] = req.getParameter("comments");
		factuurinfo[3] = req.getParameter("manuren");
		int korting = Integer.parseInt(req.getParameter("korting"));
		RequestDispatcher rd = null;
		@SuppressWarnings("unchecked")
		ArrayList<Onderdeel> onderdelen = (ArrayList<Onderdeel>) sc.getAttribute("alleOnderdelen");
		@SuppressWarnings("unchecked")
		ArrayList<Brandstof> brandstof = (ArrayList<Brandstof>) sc.getAttribute("alleBrandstof");
		@SuppressWarnings("unchecked")
		ArrayList<Factuur> facturen = (ArrayList<Factuur>) sc.getAttribute("alleFacturen");
		//onderdelen
		String[] onderdeelnaam = new String[onderdelen.size()];
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				for(int i=0; i<f.getKlus().getGebruikteOnderdelen().size(); i++) {
					onderdeelnaam[i] = req.getParameter("Okey"+(i+1));
				}
			}
			
		}
		int[] onderdeelaantal = new int[onderdelen.size()];
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				for(int i=0; i<f.getKlus().getGebruikteOnderdelen().size(); i++) {
					onderdeelaantal[i] = Integer.parseInt(req.getParameter("Ovalue"+(i+1)));
				}
			}
		}
		
		//brandstof
		String[] brandstofnaam = new String[brandstof.size()];
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				for(int i=0; i<f.getKlus().getGebruikteBrandstof().size(); i++) {
					brandstofnaam[i] = req.getParameter("Bkey"+(i+1));
				}
			}
		}
		double[] brandstofliters = new double[brandstof.size()];
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				for(int i=0; i<f.getKlus().getGebruikteBrandstof().size(); i++) {
					brandstofliters[i] = Double.parseDouble(req.getParameter("Bvalue"+(i+1)));
				}
			}
		}
		
		HashMap<Onderdeel, Integer> newOnderdelen = new HashMap<Onderdeel, Integer>();
		HashMap<Brandstof, Double> newBrandstof = new HashMap<Brandstof, Double>();
		
		for(int i = 0; i<onderdelen.size(); i++){
			if(!(onderdeelnaam.equals("")) && !(onderdeelaantal[i] == 0)){
				Onderdeel ond = null;
				for(Onderdeel o : onderdelen) {
					if(o.getNaam().equals(onderdeelnaam[i])) {
						ond = o;
					}
				}
				newOnderdelen.put(ond, onderdeelaantal[i]);
			}
		}
		for(int i = 0; i<brandstof.size(); i++){
			if(!(brandstofnaam.equals("")) && !(brandstofliters[i] == 0)){
				Brandstof br = null;
				for(Brandstof b : brandstof) {
					if(b.getBrandstofType().equals(brandstofnaam[i])) {
						br = b;
					}
				}
				newBrandstof.put(br, brandstofliters[i]);
			}
		}
		
		for(Factuur f: facturen){
			if(f.getFactuurNummer() == id){
				f.getKlus().setHetType(factuurinfo[1]);
				f.getKlus().setBeschrijving(factuurinfo[2]);
				f.getKlus().setManuren(Integer.parseInt(factuurinfo[3]));
				f.getKlus().setGebruikteOnderdelen(newOnderdelen);
				f.getKlus().setGebruikteBrandstof(newBrandstof);
				f.setKorting(korting);
			}
		}
		rd = req.getRequestDispatcher("overzichtfacturen.jsp");
		Logger.getLogger("atd").info("Factuur <"+id+"> is gewijzigd");
		rd.forward(req, resp);
	}
	
}
