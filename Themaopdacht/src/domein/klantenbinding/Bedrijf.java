package domein.klantenbinding;

import java.util.ArrayList;

import domein.klusbeheer.Planner;
import domein.voorraadbeheer.Voorraad;
/**
 * deze klasse houdt de lijst van met alle klanten bij
 * de naam van het bedrijf kan ingevuld/gewijzigd worden
 * in deze klasse worden andere klasse met arraylists geinitialiseerd 
 * zodat overal met dezelfde arraylists gewerkt wordt
 */
public class Bedrijf {
	private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
	private String bedrijfsNaam;
	private Planner dePlanner;
	private Voorraad deVoorraad;

	/**
	 * het bedrijf wordt aangemaakt en de bedrijfsnaam wordt opgegeven
	 * @param nm de bedrijfsnaam
	 */
	public Bedrijf(String nm) {
		setNaam(nm);
	}

	/**
	 * de lijst met alle klanten wordt opgevraagt
	 * @return de inhoud van de ArrayList alleKlanten
	 */
	public ArrayList<Klant> getAlleKlanten() {
		return alleKlanten;
	}

	/**
	 * deze methode voegt een klant toe aan de klantenlijst als deze er nog niet in stond
	 * of een klant al in de lijst staat wordt gecontroleert dmv de methode heeftKlant()
	 * @param nwK de toe te voegen klant
	 * @return een boolean om aan te geven of het toevoegen gelukt is
	 */
	public boolean voegKlantToe(Klant nwK) {
		if (heeftKlant(nwK.getEmail())) {
			return false;
		} else { // klant kan alleen worden toegevoegd als deze nog niet
					// geregistreerd is
			alleKlanten.add(nwK);
			return true;
		}
	}

	/**
	 * er wordt mbv een emailadres en de methode zoekKlant() gekeken 
	 * of een klant al in de klantenlijst staat
	 * @param em het emailadres waar naar gezocht moet worden
	 * @return een boolean om aan te geven of de klant in de ArrayList staat
	 */
	public boolean heeftKlant(String em) {
		boolean result = false;
		if (zoekKlant(em) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode wordt gebruikt om een klant te zoeken mbv het emailadres
	 * @param em het emailadres van de te zoeken klant
	 * @return de klant met het gezochte emailadres als de klant in de ArrayList staat
	 */
	public Klant zoekKlant(String em) {
		Klant result = null;
		for (Klant k : alleKlanten) {
			if (k.getEmail().equals(em)) {
				result = k;
			}
		}
		return result;
	}

	/**
	 * deze methode wordt gebruikt om een klant uit de ArrayList te halen
	 * @param exk de te verwijderen klant
	 * @return een boolean om aan te geven of het verwijderen gelukt is.
	 */
	public boolean verwijderKlant(Klant exk) {
		boolean resultaat = false;
		if (heeftKlant(exk.getEmail())) {// Klant kan alleen verwijdert worden
											// als deze geregistreerd is
			alleKlanten.remove(exk);
			resultaat = true;
		}
		return resultaat;
	}

	/**
	 * deze methode geeft weer hoeveel klanten er in de ArrayList alleKlanten staan
	 * @return het aantal klanten
	 */
	public int aantalKlanten() {
		if (alleKlanten.size() != 0) {
			return alleKlanten.size();
		} else {
			return 0;
		}

	}

	/**
	 * deze methode vraagt de bedrijfsnaam op
	 * @return de bedrijfsnaam
	 */
	public String getNaam() {
		return bedrijfsNaam;
	}

	/**
	 * deze methode vult de bedrijfsnaam in
	 * @param nm de bedrijfsnaam
	 */
	public void setNaam(String nm) {
		bedrijfsNaam = nm;
	}

	//in de onderstaande methoden worden de klassen waarin arraylists worden gemaakt geinitialiseerd
	//zodat er in elke klasse met dezelfde arraylists gewerkt worden
	public Planner getDePlanner() {
		return dePlanner;
	}

	public void setDePlanner(Planner p) {
		dePlanner = p;
	}

	public Voorraad getDeVoorraad() {
		return deVoorraad;
	}

	public void setDeVoorraad(Voorraad v) {
		deVoorraad = v;
	}

	public Planner getDeFinancien() {
		return dePlanner;
	}
	
	//het initialiseren is gestopt missen we niet een setDeFinancien?

	/**
	 * deze methode geeft een string weer waarin alle klanten worden weergegeven en 
	 * hoeveel klanten er zijn
	 * @return een string
	 */
	public String toString() {
		String i = "";
		for (Klant k : alleKlanten) {
			i += "" + k.toString();
		}
		String s = "Het aantal contacten is: " + aantalKlanten()
				+ "\nDeze contacten zijn: \n" + i;
		return s;
	}

}
