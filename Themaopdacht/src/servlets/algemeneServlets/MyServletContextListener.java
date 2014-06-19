package servlets.algemeneServlets;

import java.util.ArrayList;

import javax.servlet.*;

import domein.financien.Factuur;
import domein.klantenbinding.Auto;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Monteur;
import domein.klusbeheer.Parkeerplaats;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

public class MyServletContextListener implements ServletContextListener {
	
	/**
	 *In deze servlet worden alle arraylisten geinitialiseert zodat elke andere servlet ze kan gebruiken.
	 *De geinitialiseerde lijsten worden ook meteen opgeslagen als attributen.
	 *
	 *Ook worden er enkele standaard gebruikers aangemaakt die wij als programmeurs kunnen gebruiken om
	 *dit programma te testen zonder dat we steeds opnieuw gebruikers aan moeten maken.
	 *
	 * Verder worden er ook een aantal onderdelen geinitialiseerd, zodat we deze meteen kunnen gebruiken bij het 
	 * testen van bepaalde klassen.
	 */
	public void contextInitialized(ServletContextEvent sce) {
		
		//arrays initialiseren
		ArrayList<Klant> List = new ArrayList<Klant>();
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();
		ArrayList<Klus> List3 = new ArrayList<Klus>();
		ArrayList<Auto> List4 = new ArrayList<Auto>();
		Parkeerplaats[] List5 = new Parkeerplaats[50];
		ArrayList<Onderdeel> List6 = new ArrayList<Onderdeel>();
		ArrayList<Factuur> List7 = new ArrayList<Factuur>();
		ArrayList<Brandstof> List8 = new ArrayList<Brandstof>();
		
		// users initaliseren
		Klant u = new Klant("James", "Straat 1", "3612AH", "test@test.com", "Test", "derp");
		Klant u2 = new Klant("Johnny Test", "Straat 2", "3613AH", "test@test.test", "Test2", "derp");
		List.add(u);
		List.add(u2);

		// monteurs initaliseren
		Monteur m = new Monteur("Klaas", "monteur1");
		Monteur m2 = new Monteur("Kees", "monteur2");
		List2.add(m);
		List2.add(m2);

		//onderdelen initialiseren
		Onderdeel o = new Onderdeel(30, "Wieldopje", 5.5);
		Onderdeel o2 = new Onderdeel(999, "Headlightfuel", 40.0);
		Onderdeel o3 = new Onderdeel(3, "Ramenlappers", 1.0);
		List6.add(o);
		List6.add(o2);
		List6.add(o3);
		
		//Brandstof initialiseren
		Brandstof b = new Brandstof("Euro95", 50, 1.0);
		Brandstof b2 = new Brandstof("Diesel", 20, 3.2);
		Brandstof b3 = new Brandstof("Benzine", 69, 0.1);
		List8.add(b);
		List8.add(b2);
		List8.add(b3);

		//attributen opslaan
		sce.getServletContext().setAttribute("alleUsers", List);
		sce.getServletContext().setAttribute("alleMonteurs", List2);
		sce.getServletContext().setAttribute("alleKlussen", List3);
		sce.getServletContext().setAttribute("alleAutos", List4);
		sce.getServletContext().setAttribute("alleParkeerplaatsen", List5);
		sce.getServletContext().setAttribute("alleOnderdelen", List6);
		sce.getServletContext().setAttribute("alleFacturen", List7);
		sce.getServletContext().setAttribute("alleBrandstof", List8);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}
