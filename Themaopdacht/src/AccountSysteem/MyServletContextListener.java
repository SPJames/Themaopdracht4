package AccountSysteem;

//import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;

import financien.Factuur;
import Klus.Parkeerplaats;
//import Database.Database;
import Klusbeheer.Klus;
import Klusbeheer.Monteur;
import klantenbinding.Auto;
import klantenbinding.Klant;
import voorraadbeheer.Onderdeel;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {

		// users initaliseren
		ArrayList<Klant> List = new ArrayList<Klant>();

		Klant u = new Klant("James", "Straat 1", "3612AH", "test@test.com",
				"Test", "derp");
		List.add(u);
		Klant u2 = new Klant("Johnny Test", "Straat 2", "3613AH",
				"test@test.test", "Test2", "derp");
		List.add(u2);

		sce.getServletContext().setAttribute("allUsers", List);

		// monteurs initaliseren
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();

		Monteur m = new Monteur("Klaas", "monteur1");
		List2.add(m);
		Monteur m2 = new Monteur("Kees", "monteur2");
		List2.add(m2);

		sce.getServletContext().setAttribute("allMonteurs", List2);

		// Klussen initaliseren
		ArrayList<Klus> List3 = new ArrayList<Klus>();

		sce.getServletContext().setAttribute("allKlussen", List3);

		// Auto initaliseren
		ArrayList<Auto> List4 = new ArrayList<Auto>();

		sce.getServletContext().setAttribute("allAutos", List4);

		// Parkeerplaats initialiseren
		Parkeerplaats[] List5 = new Parkeerplaats[50];

		sce.getServletContext().setAttribute("allParkeerplaatsen", List5);
		
		//onderdelen initialiseren en 3 test waarde toevoegen
		ArrayList<Onderdeel> List6 = new ArrayList<Onderdeel>();
		Onderdeel o = new Onderdeel(1, 30, "Wieldopje", 5.5);
		Onderdeel o2 = new Onderdeel(2, 999, "Headlightfuel", 40.0);
		Onderdeel o3 = new Onderdeel(3, 3, "Ramenlappers", 1.0);
		List6.add(o);
		List6.add(o2);
		List6.add(o3);
		sce.getServletContext().setAttribute("alleOnderdelen", List6);

		
		// facturen initialiseren
		ArrayList<Factuur> List7 = new ArrayList<Factuur>();

		sce.getServletContext().setAttribute("alleFacturen", List7);

		// lees bestaande users in
		// Werk voor sprint 3
		// try {
		// Database.leesUsersIn(List);
		// System.out.println("succes");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}
