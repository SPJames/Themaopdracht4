package servlets.algemeneServlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import database.Database;
import domein.financien.Factuur;
import domein.klantenbinding.Auto;
import domein.klantenbinding.Klant;
import domein.klusbeheer.Klus;
import domein.klusbeheer.Monteur;
import domein.klusbeheer.Parkeerplaats;
import domein.klusbeheer.Weekplanning;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

import java.util.Calendar;
import java.text.SimpleDateFormat;


public class MyServletContextListener implements ServletContextListener {
	private Database d = new Database();
	
	private ArrayList<Klant> List = new ArrayList<Klant>();
	private ArrayList<Monteur> List2 = new ArrayList<Monteur>();
	private ArrayList<Klus> List3 = new ArrayList<Klus>();
	private ArrayList<Auto> List4 = new ArrayList<Auto>();
	private Parkeerplaats[] List5 = new Parkeerplaats[50];
	private ArrayList<Onderdeel> List6 = new ArrayList<Onderdeel>();
	private ArrayList<Factuur> List7 = new ArrayList<Factuur>();
	private ArrayList<Brandstof> List8 = new ArrayList<Brandstof>();
	private Weekplanning planning = new Weekplanning();
	
	private HashMap<String, Integer> ids = new HashMap<String, Integer>();
	
	private Logger logger = Logger.getLogger("atd");
	
	private File currentDirectory = new File(new File(".").getAbsolutePath()).getParentFile();
	private String directory = currentDirectory.getParent() + "/logs/";
	
	private FileHandler fh = null;
	
	private String DATE_FORMAT_NOW = "yyyy-MM-dd HH-mm-ss";
	
	/**
	 * In deze servlet worden alle arraylisten geinitialiseert zodat elke andere
	 * servlet ze kan gebruiken. De geinitialiseerde lijsten worden ook meteen
	 * opgeslagen als attributen.
	 * 
	 * Ook worden er enkele standaard gebruikers aangemaakt die wij als
	 * programmeurs kunnen gebruiken om dit programma te testen zonder dat we
	 * steeds opnieuw gebruikers aan moeten maken.
	 * 
	 * Verder worden er ook een aantal onderdelen geinitialiseerd, zodat we deze
	 * meteen kunnen gebruiken bij het testen van bepaalde klassen.
	 */
	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent sce) {
		HashMap<String, Object> map = null;
		try {
			if(!d.isLeeg()) {
				map = d.leesIn();
				List = (ArrayList<Klant>) map.get("List");
				List2 = (ArrayList<Monteur>) map.get("List2");
				List3 = (ArrayList<Klus>) map.get("List3");
				List4 = (ArrayList<Auto>) map.get("List4");
				List5 = (Parkeerplaats[]) map.get("List5");
				List6 = (ArrayList<Onderdeel>) map.get("List6");
				List7 = (ArrayList<Factuur>) map.get("List7");
				List8 = (ArrayList<Brandstof>) map.get("List8");
				planning = (Weekplanning) map.get("planning");
				ids = (HashMap<String, Integer>) map.get("ids");
			} else {
				//standaard waarden!
				
				//ids initialiseren (alle waarden op 1 zetten als 'database' leeg is)
				ids.put("userID", 3);
				ids.put("monteurID", 3);
				ids.put("factuurID", 1);
				ids.put("onderdeelID", 4);
				ids.put("brandstofID", 4);
				
				// users initaliseren
				Klant u = new Klant("James", "Straat 1", "3612AH", "test@test.com", "Test", "derp", 1);
				Klant u2 = new Klant("Johnny Test", "Straat 2", "3613AH", "test@test.test", "Test2", "derp", 2);
				List.add(u);
				List.add(u2);

				// monteurs initaliseren
				Monteur m = new Monteur("Klaas", "monteur1", 1);
				Monteur m2 = new Monteur("Kees", "monteur2", 2);
				List2.add(m);
				List2.add(m2);

				// onderdelen initialiseren
				Onderdeel o = new Onderdeel(30, "Wieldopje", 5.5, 1);
				Onderdeel o2 = new Onderdeel(999, "Headlightfuel", 40.0, 2);
				Onderdeel o3 = new Onderdeel(3, "Ramenwissers", 1.0, 3);
				List6.add(o);
				List6.add(o2);
				List6.add(o3);

				// Brandstof initialiseren
				Brandstof b = new Brandstof("Euro95", 50, 1.0, 1);
				Brandstof b2 = new Brandstof("Diesel", 20, 3.2, 2);
				Brandstof b3 = new Brandstof("Benzine", 69, 0.1, 3);
				List8.add(b);
				List8.add(b2);
				List8.add(b3);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// attributen opslaan
		sce.getServletContext().setAttribute("alleUsers", List);
		sce.getServletContext().setAttribute("alleMonteurs", List2);
		sce.getServletContext().setAttribute("alleKlussen", List3);
		sce.getServletContext().setAttribute("alleAutos", List4);
		sce.getServletContext().setAttribute("alleParkeerplaatsen", List5);
		sce.getServletContext().setAttribute("alleOnderdelen", List6);
		sce.getServletContext().setAttribute("alleFacturen", List7);
		sce.getServletContext().setAttribute("alleBrandstof", List8);
		sce.getServletContext().setAttribute("planning", planning);
		sce.getServletContext().setAttribute("ids", ids);

		// Logger
		try {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
			
			fh = new FileHandler((directory + "atd-logs " + sdf.format(cal.getTime()) + ".log"));
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		logger.setLevel(Level.ALL);
		logger.info("Logger initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		try {
			d.schrijfWeg(List, List2, List3, List4, List5, List6, List7, List8, planning, ids);
			logger.info("Logger ended");
			logger.setLevel(Level.OFF);
			logger.removeHandler(fh);
			fh.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}