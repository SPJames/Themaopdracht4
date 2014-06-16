package servlets.algemeneServlets;

import java.util.ArrayList;

import javax.servlet.*;

import domein.financien.Factuur;
import domein.klantenbinding.Auto;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Monteur;
import domein.klusbeheer.Parkeerplaats;
import domein.voorraadbeheer.Onderdeel;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		
		//arrays initialiseren
		ArrayList<Klant> List = new ArrayList<Klant>();
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();
		ArrayList<Klus> List3 = new ArrayList<Klus>();
		ArrayList<Auto> List4 = new ArrayList<Auto>();
		Parkeerplaats[] List5 = new Parkeerplaats[50];
		ArrayList<Onderdeel> List6 = new ArrayList<Onderdeel>();
		ArrayList<Factuur> List7 = new ArrayList<Factuur>();
		
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
		Onderdeel o = new Onderdeel(1, 30, "Wieldopje", 5.5);
		Onderdeel o2 = new Onderdeel(2, 999, "Headlightfuel", 40.0);
		Onderdeel o3 = new Onderdeel(3, 3, "Ramenlappers", 1.0);
		List6.add(o);
		List6.add(o2);
		List6.add(o3);

		//attributen opslaan
		sce.getServletContext().setAttribute("alleUsers", List);
		sce.getServletContext().setAttribute("alleMonteurs", List2);
		sce.getServletContext().setAttribute("alleKlussen", List3);
		sce.getServletContext().setAttribute("alleAutos", List4);
		sce.getServletContext().setAttribute("alleParkeerplaatsen", List5);
		sce.getServletContext().setAttribute("alleOnderdelen", List6);
		sce.getServletContext().setAttribute("alleFacturen", List7);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}