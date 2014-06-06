package domein.klusbeheer;

import java.util.ArrayList;

/**
 * in deze klasse kunnen de gegevens van een weekplanning ingevuld/bewerkt worden
 * in deze klasse wordt ook de arraylists van klussen en monteurs bijgehouden/bewerkt
 */
public class Weekplanning {
	private int weeknummer;
	private ArrayList<Klus> alleKlussen = new ArrayList<Klus>();
	private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();

	/**
	 * de weekplanning wordt aangemaakt en krijgt een weeknummer mee
	 * de weekplanning is voor de week van het meegegeven weeknummer
	 * @param wn het weeknummer
	 */
	public Weekplanning(int wn) {
		weeknummer = wn;
	}

	// Klus
	/**
	 * deze methode vraagt de lijst alleKlussen op
	 * @return de lijst alleKlussen
	 */
	public ArrayList<Klus> getAlleKlussen() {
		return alleKlussen;
	}

	/**
	 * deze methode kijkt of er al een klus met hetzelfde klusnummer bestaat
	 * hiervoor wordt gezocht op het klusnummer
	 * ook wordt de methode zoekklus() gebruikt
	 * @param kn het klusnummer waarop gezocht wordt
	 * @return een boolean die aangeeft of het klusnummer al in gebruik is of niet
	 */
	public boolean heeftKlus(int kn) {
		boolean result = false;
		if (zoekKlus(kn) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * met deze methode wordt een klus opgezocht dmv het klusnummer
	 * @param kn het klusnummer van de gezochte klus
	 * @return de klus als die bestaat anders een lege klus
	 */
	public Klus zoekKlus(int kn) {
		// zoeken op klusnummer
		Klus result = null;
		for (Klus k : alleKlussen) {
			if (k.getKlusNummer() == kn) {
				result = k;
			}
		}
		return result;
	}

	/**
	 * deze methode voegt een klus toe aan de lijst alleKlussen als deze er nog niet in staat
	 * de methode heeftKlus wordt gebruikt om te kijken of de klus in de lijst staat
	 * @param nwK de toe te voegen klus
	 * @return een boolean die aangeeft of het toevoegen gelukt is
	 */
	public boolean voegKlusToe(Klus nwK) {
		if (heeftKlus(nwK.getKlusNummer())) {
			return false;
		} else {
			alleKlussen.add(nwK);
			return true;
		}
	}

	/**
	 * deze methode verwijdert een klus uit de lijst alleKlussen als deze erin staat
	 * de methode heeftKlus wordt gebruikt om te kijken of de klus in de lijst staat
	 * @param exK de te verwijderen klus
	 * @return een boolean die aangeeft of het verwijderen gelukt is
	 */
	public boolean verwijderKlus(Klus exK) {
		boolean result = false;
		if (heeftKlus(exK.getKlusNummer())) {
			result = true;
			alleKlussen.remove(exK);
		}
		return result;
	}

	/**
	 * deze methode geeft weer hoeveel klussen er in de arraylist alleKlussen staan
	 * @return het aantal klussen in de arraylist alleKlussen
	 */
	public int aantalKlussen() {
		if (alleKlussen.size() != 0) {
			return alleKlussen.size();
		} else {
			return 0;
		}
	}

	// Monteur

	/**
	 * deze methode vraagt de lijst met alle monteuraccounts op
	 * @return de lijst met alle monteuraccounts
	 */
	public ArrayList<Monteur> getAlleMonteurs() {
		return alleMonteurs;
	}

	/**
	 * deze methode kijkt of een monteur in de lijst alleMonteurs zit
	 * hiervoor wordt gebruikgemaakt van de methode zoekMonteur en de gebruikersnaam
	 * @param nm de gebruikersnaam van de monteurs
	 * @return een boolean die aangeeft of de monteur in de lijst zit
	 */
	public boolean heeftMonteur(String nm) {
		boolean result = false;
		if (zoekMonteur(nm) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode zoekt in de lijst alleMonterus naar een monteur
	 * @param nm de gebruikersnaam
	 * @return de monteur als deze in de lijst alleMonteurs staat
	 */
	public Monteur zoekMonteur(String nm) {
		// zoeken op naam
		Monteur result = null;
		for (Monteur m : alleMonteurs) {
			if (m.getNaam().equals(nm)) {
				result = m;
			}
		}
		return result;
	}

	//moeten we hier nog een check toevoegen of de monteur al in de lijst zit?
	/**
	 * deze methode voegt een monteur aan de lijst alleMonteurs toe
	 * @param nwM de toe te voegen monteur
	 * @return een boolean die aangeeft of de monteur toegevoegd is of niet
	 */
	public boolean voegMonteurToe(Monteur nwM) {
		alleMonteurs.add(nwM);
		return true;
	}

	/**
	 * deze methode verwijdert een monteur uit de lijst alleMonteurs
	 * de methode heeftMonteur wordt gebruikt om te kijken of de monteur in de lijst zit
	 * @param exM de te verwijderen montuer
	 * @return een boolean die aangeeft of de monteur verwijdert is of niet
	 */
	public boolean verwijderMonteur(Monteur exM) {
		boolean result = false;
		if (heeftMonteur(exM.getNaam())) {
			result = true;
			alleKlussen.remove(exM);
		}
		return result;
	}

	// weekplanning

	/**
	 * deze methode vraagt het weeknummer op
	 * @return het weeknummer
	 */
	public int getWeeknummer() {
		return weeknummer;
	}

	/**
	 * deze methode vult het weeknummer in
	 * @param wn het weeknummer
	 */
	public void setWeeknummer(int wn) {
		weeknummer = wn;
	}

	/**
	 * deze methode maakt een string die aangeeft voor welke week de planning is
	 * @return een string die aangeeft voor welke week de planning is
	 */
	public String toString() {
		String s = "Planning voor week " + getWeeknummer();
		return s;
	}
}
