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

	//WAAROM STAAT DIT HIER? DIT STAAT AL IN KLASSE VOORRAAD?
	// BRANDSTOF

	public ArrayList<Brandstof> getAlleBrandstof() {
		return alleBrandstof;
	}

	public boolean heeftBrandstof(String tp) {
		boolean result = false;
		if (zoekBrandstof(tp) != null) {
			result = true;
		}
		return result;
	}

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

	public boolean voegBrandstofToe(Brandstof nwB) {
		// Brandstof toevoegen aan voorraad, dit kunnen meer van het zelfde type
		// zijn!
		alleBrandstof.add(nwB);
		return true;
	}

	public boolean verwijderBrandstof(Brandstof exB) {
		// kan alleen worden verwijderd als het type bestaat
		boolean result = false;
		if (heeftBrandstof(exB.getBrandstofType())) {
			result = true;
			alleBrandstof.remove(exB);
		}
		return result;
	}

	public int aantalBrandstof() {
		if (alleBrandstof.size() != 0) {
			return alleBrandstof.size();
		} else {
			return 0;
		}
	}

	// ONDERDEEL

	public ArrayList<Onderdeel> getAlleOnderdelen() {
		return alleOnderdelen;
	}

	public boolean heeftOnderdeel(int aN) {
		boolean result = false;
		if (zoekOnderdeel(aN) != null) {
			result = true;
		}
		return result;
	}

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

	public boolean verwijderOnderdeel(Onderdeel exO) {
		// kan alleen worden verwijderd als het artikelNr bestaat
		boolean result = false;
		if (heeftOnderdeel(exO.getArtikelNr())) {
			result = true;
			alleOnderdelen.remove(exO);
		}
		return result;
	}

	public int aantalOnderdelen() {
		if (alleOnderdelen.size() != 0) {
			return alleOnderdelen.size();
		} else {
			return 0;
		}
	}

	// einde van de code die ook in klasse voorraad staat
	
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
