package AccountSysteem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;

import Database.Database;
import Klusbeheer.Klus;
import Klusbeheer.Monteur;
import klantenbinding.Auto;
import klantenbinding.Klant;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ArrayList<Klant> List = new ArrayList<Klant>();
		
		//lees bestaande users in
		
		//ERROR, onbekend waarom. Oorsprong ligt waarschijnlijk in database.java
		try {
			Database.leesUsersIn(List);
			System.out.println("succes");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//users initaliseren
		
		sce.getServletContext().setAttribute("allUsers", List);
		
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();

		//monteurs initaliseren
		
		sce.getServletContext().setAttribute("allMonteurs", List2);
		
		ArrayList<Klus> List3 = new ArrayList<Klus>();

		//Klussen initaliseren
		
		sce.getServletContext().setAttribute("allKlussen", List3);
		
		ArrayList<Auto> List4 = new ArrayList<Auto>();

		//Auto initaliseren
		
		sce.getServletContext().setAttribute("allAuto", List4);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}