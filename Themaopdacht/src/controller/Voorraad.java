package controller;

import java.util.ArrayList;

import controller.Bestelling;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;
/**
 * deze klasse houdt de arrayListen voor de soorten brandstof, onderdelen en bestellingen bij
 * deze lijsten kunnen hier ingevult/gewijzigd worden
 */
public class Voorraad {

	private ArrayList<Brandstof> alleBrandstof = new ArrayList<Brandstof>();
	private ArrayList<Onderdeel> alleOnderdelen = new ArrayList<Onderdeel>();
	private ArrayList<Bestelling> alleBestellingen = new ArrayList<Bestelling>();

	// de klasse wordt geinitialiseerd
	public Voorraad() {

	}

	// BRANDSTOF

	/**
	 * deze methode vraagt de lijst met alle brandstofsoorten op
	 * @return de lijst alleBrandstof
	 */
	public ArrayList<Brandstof> getAlleBrandstof() {
		return alleBrandstof;
	}

	/**
	 * deze methode kijkt of een brandstof soort in de lijst alleBrandstof staat
	 * de methode zoekBrandstof wordt gebruikt
	 * @param tp het brandstoftype (diesel, euro)
	 * @return een boolean die aangeeft of de brandstof in de lijst staat of niet
	 */
	public boolean heeftBrandstof(String tp) {
		boolean result = false;
		if (zoekBrandstof(tp) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode zoekt naar een brandstoftype in de lijst alleBrandstof
	 * @param tp het gezochte brandstoftype
	 * @return het gezochte brandstoftype als het in de lijst staat
	 */
	public Brandstof zoekBrandstof(String tp) {
		// zoeken op brandstofType
		Brandstof result = null;
		for (Brandstof b : alleBrandstof) {
			if (b.getBrandstofType().equals(tp)) {
				result = b;
			}
		}
		return result;
	}

	/**
	 * deze methode voegt brandstof toe aan de lijst alleBrandstof
	 * @param nwB de toe te voegen brandstof
	 * @return een boolean die aangeeft of het toevoegen gelukt is
	 */
	public boolean voegBrandstofToe(Brandstof nwB) {
		// Brandstof toevoegen aan voorraad, dit kunnen meer van het zelfde type
		// zijn!
		alleBrandstof.add(nwB);
		return true;
	}

	/**
	 * deze methode verwijdert een brandstoftype uit de lijst als deze erin staat
	 * de methode heeftBrandstof wordt gebruikt om te kijken of deze in de lijst staat
	 * @param exB de te verwijderen brandstof
	 * @return een boolean die aangeeft of het verwijderen gelukt is
	 */
	public boolean verwijderBrandstof(Brandstof exB) {
		// kan alleen worden verwijderd als het type bestaat
		boolean result = false;
		if (heeftBrandstof(exB.getBrandstofType())) {
			result = true;
			alleBrandstof.remove(exB);
		}
		return result;
	}

	/**
	 * deze methode geeft weer hoeveel brandstofsoorten er in de lijst alleBrandstof staan
	 * @return hoeveelheid brandstofsoorten (kunnen meer van dezelfde zijn)
	 */
	public int aantalBrandstof() {
		if (alleBrandstof.size() != 0) {
			return alleBrandstof.size();
		} else {
			return 0;
		}
	}

	// ONDERDEEL

	/**
	 * deze methode vraagt de lijst met alle onderdelen op
	 * @return de lijst alleOnderdelen
	 */
	public ArrayList<Onderdeel> getAlleOnderdelen() {
		return alleOnderdelen;
	}

	/**
	 * deze methode kijkt of een onderdeel in de lijst alleOnderdelen staat
	 * de methode zoekOnderdeel wordt gebruikt om de lijst te doorzoeken
	 * @param aN het artikelnummer van het te zoeken onderdeel
	 * @return een boolean die aangeeft of het onderdeel in de lijst staat
	 */
	public boolean heeftOnderdeel(int aN) {
		boolean result = false;
		if (zoekOnderdeel(aN) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode zoekt een onderdeel in de lijst alleOnderdelen
	 * @param aN het artikelnummer van het te zoeken onderdeel
	 * @return het onderdeel als het in de lijst staat
	 */
	public Onderdeel zoekOnderdeel(int aN) {
		// zoeken op artikelnr
		Onderdeel result = null;
		for (Onderdeel o : alleOnderdelen) {
			if (o.getArtikelNr() == (aN)) {
				result = o;
			}
		}
		return result;
	}

	/**
	 * deze methode voegt een onderdeel aan de lijst toe
	 * als het onderdeel nog niet in de lijst stond wordt het toegevoegd
	 * als het er al wel in stond wordt het aantal van dat onderdeel verhoogd
	 * @param nwO het toe te voegen onderdeel
	 * @return een boolean die aangeeft of het gelukt is of niet
	 */
	public boolean voegOnderdeelToe(Onderdeel nwO) {
		// Onderdeel toevoegen aan voorraad, dit kunnen meer van het zelfde
		// artikelnr zijn!
		if (!heeftOnderdeel(nwO.getArtikelNr())) {
			alleOnderdelen.add(nwO);
		}
		// als het artikelnr er is moet het aantal van het nieuwe artikel erbij
		// opgeteld worden
		if (heeftOnderdeel(nwO.getArtikelNr())) {
			int erbij = nwO.getAantal();
			int aN = 0;
			for (Onderdeel o : alleOnderdelen) {
				if (o.getArtikelNr() == (aN)) {
					o.setAantal(o.getAantal() + erbij);
				}
			}
		}
		return true;
	}

	/**
	 * deze methode verwijdert een onderdeel uit de lijst alleOnderdelen
	 * de methode heeftOnderdeel wordt gebruikt om te kijken of het onderdeel in de lijst staat
	 * @param exO het te verwijderen onderdeel
	 * @return een boolean die aangeeft of het onderdeel verwijdert is of niet
	 */
	public boolean verwijderOnderdeel(Onderdeel exO) {
		// kan alleen worden verwijderd als het artikelNr bestaat
		boolean result = false;
		if (heeftOnderdeel(exO.getArtikelNr())) {
			result = true;
			alleOnderdelen.remove(exO);
		}
		return result;
	}

	/**
	 * deze methode wordt gebruikt om het aantal verschillende onderdelen 
	 * in de lijst alleOnderdelen op te vragen
	 * @return het aantal verschillende onderdelen
	 */
	public int aantalOnderdelen() {
		if (alleOnderdelen.size() != 0) {
			return alleOnderdelen.size();
		} else {
			return 0;
		}
	}

	// BESTELLING

	/**
	 * deze methode vraagt de lijst met alle bestellingen op
	 * @return de lijst alleBestellingen
	 */
	public ArrayList<Bestelling> getAlleBestellingen() {
		return alleBestellingen;
	}

	//kunnen we hier niet zoekbestellling aanroepen?
	/**
	 * deze methode kijkt of een bestelling in de lijst alleBestellingen zit
	 * @param bN het bestellingsnummer waarop gezocht wordt
	 * @return een boolean die aangeeft of de bestelling in de lijst staat of niet
	 */
	public boolean heeftBestelling(int bN) {
		boolean result = false;
		for (Bestelling b : alleBestellingen) {
			if (b.getBestellingsNr() == bN) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * deze methode zoekt een bestelling in de lijst alleBestelingen
	 * @param bN het bestelnummer van de gezochte bestelling
	 * @return de bestelling als deze in de lijst zit
	 */
	public boolean zoekBestelling(int bN) {
		// zoeken op bestelnr
		Boolean result = false;
		for (Bestelling o : alleBestellingen) {
			if (o.getBestellingsNr() == (bN)) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * deze methode voegt een bestelling toe aan de lijst alleBestellingen
	 * de methode heeftBestelling wordt gebruikt om te kijken of de bestelling in de lijst staat
	 * @param nwBe de toe te voegen bestelling
	 * @return een boolean die weergeeft of de bestelling toegevoegd is
	 */
	public boolean voegBestellingToe(Bestelling nwBe) {
		// kan alleen worden toegevoegd als bestelNr niet bestaat!
		if (!heeftBestelling(nwBe.getBestellingsNr())) {
			alleBestellingen.add(nwBe);
			return true;
		}
		return false;
	}

	/**
	 * met deze methode wordt een bestelling uit de lijst alleBestellingen verwijdert
	 * de methode heeftBestelling wordt gebruikt om te kijken of de bestelling in de lijst staat
	 * @param exBe de te verwijderern bestelling
	 * @return een boolean die aangeeft of de bestelling verwijdert is
	 */
	public boolean verwijderBestelling(Bestelling exBe) {
		// kan alleen worden verwijderd als het bestelNr bestaat
		boolean result = false;
		if (heeftBestelling(exBe.getBestellingsNr())) {
			result = true;
			alleBestellingen.remove(exBe);
		}
		return result;
	}

	/**
	 * deze methode vraagt op hoeveel bestellingen er in de lijst alleBestellingen zijn
	 * @return het aantal bestellingen in lijst alleBestellingen
	 */
	public int aantalBestellingen() {
		if (alleBestellingen.size() != 0) {
			return alleBestellingen.size();
		} else {
			return 0;
		}
	}

	/**
	 * deze methode geeft een string weer die afdrukt hoeveel en welke
	 *  onderdelen/brandstofsoorten er zijn
	 *  @return een string met hoeveel en welke onderdelen en brandstofsoorten
	 */
	public String toString() {
		String i = "";
		String j = "";
		for (Onderdeel o : alleOnderdelen) {
			i += "" + o.toString();
		}
		for (Brandstof b : alleBrandstof) {
			j += "" + b.toString();
		}
		String s = "Het aantal soorten onderdelen is: " + aantalOnderdelen()
				+ "\nDeze onderdelen zijn: \n" + i
				+ "\nHet aantal soorten brandstof is: " + aantalBrandstof()
				+ "\nDeze brandstoffen zijn: \n " + j;
		return s;
	}
}
