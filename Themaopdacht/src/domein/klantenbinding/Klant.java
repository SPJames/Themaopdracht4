package domein.klantenbinding;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * in deze klasse kunnen de gegevens van een klant ingevuld en gewijzigd worden
 */
public class Klant implements Serializable{
	private static final long serialVersionUID = 1L;
	private String naam;
	private String adres;
	private String postcode;
	private String email;
	private String username;
	private String password;

	private Calendar laatstBezocht;
	private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	private static int getal = 1;
	private int id;

	/**
	 * met deze methode wordt een klant aangemaakt met een naam, adres, postcode,
	 * email adres, gebruikersnaam en wachtwoord.
	 * er wordt een klantid aangemaakt die automatisch wordt opgehoogd als er een nieuwe klant wordt aangemaakt
	 * 
	 * @param nm de volledig naam van de klant
	 * @param ad het woonadres van de klant
	 * @param pc de postcode van de klant
	 * @param em het emailadres van de klant
	 * @param un de gebruikersnaam van de klant voor op de site
	 * @param pw het wachtwoord van de klant voor op de site
	 */
	public Klant(String nm, String ad, String pc, String em, String un,	String pw) {
		setNaam(nm);
		setAdres(ad);
		setPostcode(pc);
		setEmail(em);
		setUsername(un);
		setPassword(pw);
		id = getal++;	//het automatisch ophogen van klantid
	}

	/**
	 * deze methode vraagt de gebruikersnaam van de klant op
	 * 
	 * @return de gebruikersnaam
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * deze methode vult de gebruikersnaam van de klant in
	 * 
	 * @param username de gebruikersnaam
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * deze methode vraagt het wachtwoord van de klant op
	 * 
	 * @return het wachtwoord
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * deze methode vult het wachtwoord van de klant in
	 *
	 * @param password het wachtwoord
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * deze methode vraagt de naam van de klant op
	 * 
	 * @return de naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * deze methode vult de naam van de klant in
	 * 
	 * @param nm de naam
	 */
	public void setNaam(String nm) {
		naam = nm;
	}

	/**
	 * deze methode vraagt het woonadres van de klant op
	 * 
	 * @return het woonadres
	 */
	public String getAdres() {
		return adres;
	}

	/**
	 * deze methode vult het woonadres van de klant in
	 * 
	 * @param ad het woonadres
	 */
	public void setAdres(String ad) {
		adres = ad;
	}

	/**
	 * deze methode vraagt de postcode van de klant op
	 * 
	 * @return de postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * deze methode vult de postcode van de klant in
	 * 
	 * @param pc de postcode
	 */
	public void setPostcode(String pc) {
		postcode = pc;
	}

	/**
	 * deze methode vraagt het emailadres van de klant op
	 * 
	 * @return het emailadres
	 */
	public String getEmail() {
		return email;
	}

	/** 
	 * deze methode vult het emailadres van de klant in
	 * 
	 * @param em het emailadres
	 */
	public void setEmail(String em) {
		email = em;
	}

	/**
	 * deze methode vraagt de datum van het laatse bezoek op in de vorm van een string
	 * 
	 * @return de datum als deze er is
	 */
	public String getLaatstBezocht() {
		if (laatstBezocht != null) {
			return df.format(laatstBezocht.getTime());
		} else {
			String s = "Geen datum beschikbaar";
			return s;
		}
	}

	/**
	 * deze methode vraagt het klantid van de klant op
	 * 
	 * @return de klantid
	 */
	public int getId() {
		return id;
	}

	/**
	 * deze methode vult de klantid van de klant in
	 * 
	 * @param id de klantid
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * deze methode vult de datum van het laatste bezoek in
	 * 
	 * @param nd de datum van het laatste bezoek
	 */
	public void setLaatstBezocht(Calendar nd) {
		laatstBezocht = nd;
	}

	/**
	 * deze methode vraagt de datum van het laatste bezoek op in calendar vorm
	 * @return de datum van het laatste bezoek
	 */
	public Calendar getLaatstBezochtRaw() {
		return laatstBezocht;
	}

	/**
	 * deze methode vraagt de arraylist met autos op
	 * elke klant heeft een eigen arraylist autos
	 * 
	 * @return alle autos van de klant
	 */
	public ArrayList<Auto> getAlleAutos() {
		return alleAutos;
	}

	/**
	 * Als een klant aangepast wordt wordt deze methode gebruikt om
	 * te zorgen dat de klant de autos behoud
	 * 
	 * @param alleAutos de arraylist van alle autos van de klant
	 */
	public void setAlleAutos(ArrayList<Auto> alleAutos) {
		this.alleAutos = alleAutos;
	}

	/**
	 * deze methode voegt een auto toe aan de arraylist
	 * er wordt mbv methode heeftAuto gekeken of de auto al in de lijst staat
	 * er wordt gecontroleert op kenteken
	 * 
	 * @param nwA de toe te voegen auto
	 */
	public void voegAutoToe(Auto nwA) {
		if (!heeftAuto(nwA.getKenteken())) { // auto kan alleen toegevoegd
												// worden als deze nog niet
												// geregistreerd is
			alleAutos.add(nwA);
		}
	}

	/**
	 * deze methode gebruikt de methode zoekauto om te kijken of de auto al in de lijst staat
	 * er wordt gezocht op kenteken
	 * 
	 * @param kt het kenteken van de gezochte auto
	 * @return een boolean die aangeeft of de auto in de lijst staat of niet
	 */
	public boolean heeftAuto(String kt) {
		boolean result = false;
		if (zoekAuto(kt) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode zoekt naar een auto met een opgegeven kenteken in de arraylist alleAutos
	 * 
	 * @param kt het kenteken waar op gezocht wordt
	 * @return als er een auto is wordt die teruggegeven anders niks
	 */
	public Auto zoekAuto(String kt) {
		Auto result = null;
		for (Auto a : alleAutos) {
			if (a.getKenteken().equals(kt)) {
				result = a;
			}
		}
		return result;
	}

	/**
	 * deze methode wordt gebruikt om een auto te verwijderen uit de lijst alleAutos
	 * met de methode heeftAuto wordt gekeken of de auto ook echt in de lijst zit
	 * 
	 * @param exA de te verwijderen auto
	 * @return een boolean die aangeeft of de auto verwijdert is
	 */
	public boolean verwijderAuto(Auto exA) { // auto kan alleen verwijdert
												// worden als deze geregistreerd
												// is
		boolean result = false;
		if (heeftAuto(exA.getKenteken())) {
			result = true;
			alleAutos.remove(exA);
		}
		return result;
	}

	/**
	 * deze methode geeft weer hoeveel autos deze klant heeft
	 * 
	 * @return het aantal autos dat de klant heeft
	 */
	public int aantalAutos() {
		if (alleAutos.size() != 0) {
			return alleAutos.size();
		} else {
			return 0;
		}
	}
}