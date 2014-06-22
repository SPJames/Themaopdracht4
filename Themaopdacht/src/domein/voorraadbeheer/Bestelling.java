package domein.voorraadbeheer;

import java.util.ArrayList;

/**
 * in deze klasse worden de gegevens van een bestelling ingevuld/bijgewerkt
 */
public class Bestelling {
	private String leveringsDatum;
	private int bestellingsNr;
	private ArrayList<Brandstof> alleBrandstof = new ArrayList<Brandstof>();
	private ArrayList<Onderdeel> alleOnderdelen = new ArrayList<Onderdeel>();

	/**
	 * met deze methode wordt de bestelling aangemaakt er wordt een leveringsdatum en 
	 * een bestellingsnummer ingevuld
	 * @param lD de leveringsdatum
	 * @param bN het bestellingsnummer
	 */
	public Bestelling(String lD, int bN) {
		leveringsDatum = lD;
		bestellingsNr = bN;
	}
	

	/**
	 * deze methode vraagt de leveringsdatum op
	 * @return de leveringsdatum
	 */
	public String getLeveringsDatum() {
		return leveringsDatum;
	}

	/**
	 * deze methode vraagt het bestellingsnummer op
	 * @return het bestellingsnummer
	 */
	public int getBestellingsNr() {
		return bestellingsNr;
	}

	/**
	 * deze methode vult de leveringsdatum in
	 * @param lD de leveringsdatum
	 */
	public void setLeveringsDatum(String lD) {
		leveringsDatum = lD;
	}

	/**
	 * deze methode vult het bestellingsnummer in
	 * @param bN het bestellingsnummer
	 */
	public void setBestellingsNr(int bN) {
		bestellingsNr = bN;
	}
	
	/**
	 * deze methode geeft een string terug die aangeeft hoeveel er van welke onderdelen
	 * in voorraad zijn en besteld zijn en hoeveel liters benzien er van welke soort
	 * aanwezig zijn en hoeveel er besteld is
	 * @return een string met de huidige voorraad en bestelde hoeveelheid onderdelen/benzine
	 */
	public String toString() {
		String deonderdelen = "";
		for (Onderdeel o : alleOnderdelen) {
			deonderdelen = deonderdelen + "\n" + o;
		}

		String debrandstof = "";
		for (Brandstof b : alleBrandstof) {
			debrandstof = debrandstof + "\n" + b;
		}

		String s = "";
		s = "\nLeverings datum: " + getLeveringsDatum() + " Bestelnummer: "
				+ getBestellingsNr();

		if (alleOnderdelen.size() >= 1) {
			s = s + "\nDeze bestelling heeft de volgende onderdelen"
					+ deonderdelen;
		}
		if (alleBrandstof.size() >= 1) {
			s = s + "\nDeze bestelling heeft de volgende brandstoffen"
					+ debrandstof;
		}

		if (alleOnderdelen.size() < 1 && !(alleBrandstof.size() >= 1)) {
			s = s + "\nEr zijn geen Onderdelen besteld";
		}
		if (alleBrandstof.size() < 1 && !(alleOnderdelen.size() >= 1)) {
			s = s + "\nEr is geen brandstof besteld";
		}

		return s;
	}
}
