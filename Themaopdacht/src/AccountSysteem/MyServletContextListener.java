package AccountSysteem;

import java.util.ArrayList;

import javax.servlet.*;

import Klusbeheer.Klus;
import Klusbeheer.Monteur;
import klantenbinding.Klant;

public class MyServletContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent sce) {
		ArrayList<Klant> List = new ArrayList<Klant>();

		//users initaliseren
		
		sce.getServletContext().setAttribute("allUsers", List);
		
		ArrayList<Monteur> List2 = new ArrayList<Monteur>();

		//monteurs initaliseren
		
		sce.getServletContext().setAttribute("allMonteurs", List2);
		
		ArrayList<Klus> List3 = new ArrayList<Klus>();

		//Klussen initaliseren
		
		sce.getServletContext().setAttribute("allKlussen", List3);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}