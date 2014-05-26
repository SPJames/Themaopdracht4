package AccountSysteem;

//import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;

import Klus.Parkeerplaats;
//import Database.Database;
import Klusbeheer.Klus;
import Klusbeheer.Monteur;
import klantenbinding.Auto;
import klantenbinding.Klant;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		
		ArrayList<Klant> List = new ArrayList<Klant>();
		
		//lees bestaande users in
		//Werk voor sprint 3
//		try {
//			Database.leesUsersIn(List);
//			System.out.println("succes");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		//users initaliseren
		Klant u = new Klant("James","Straat 1","3612AH","test@test.com","Test","derp");
		List.add(u);
		sce.getServletContext().setAttribute("allUsers", List);
		
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();

		//monteurs initaliseren
		Monteur m = new Monteur("Klaas","monteur1");
		List2.add(m);
		
		sce.getServletContext().setAttribute("allMonteurs", List2);
		
		ArrayList<Klus> List3 = new ArrayList<Klus>();

		//Klussen initaliseren
		
		sce.getServletContext().setAttribute("allKlussen", List3);
		
		ArrayList<Auto> List4 = new ArrayList<Auto>();

		//Auto initaliseren
		
		sce.getServletContext().setAttribute("allAutos", List4);
		
		Parkeerplaats[] List5 = new Parkeerplaats[30];
		
		sce.getServletContext().setAttribute("allParkeerplaatsen", List5);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}