package domein.voorraadbeheer;

/**
 * in deze klasse kunnen de gegevens van een onderdeel ingevuld/bewerkt worden
 */
public class Onderdeel {
	private int artikelNr, aantal;
	private String naam;
	private double prijsArtikel;
	private double totaal;
	private static int getal = 1;

	/**
	 * het onderdeel wordt aangemaakt het krijgt een artikelnummer, het aantal artikelen dat
	 * van dit onderdeel aanwezig is, een naam en een prijs per gebruikt artikel
	 * @param aan	het aantal
	 * @param nm	de naam
	 * @param pA	de prijs per artikel
	 */
	public Onderdeel(int aan, String nm, double pA) {
		artikelNr = getal++;
		aantal = aan;
		naam = nm;
		prijsArtikel = pA;
	}

	/**
	 * deze methode vraag het artikelnummer op
	 * @return het artikelnummer
	 */
	public int getArtikelNr() {
		return artikelNr;
	}

	/**
	 * deze methode vraagt het aantal beschikbare artikelen op
	 * @return het aantal
	 */
	public int getAantal() {
		return aantal;
	}

	/**
	 * deze methode vraagt de naam van het artikel op
	 * @return de naam
	 */
	public String getNaam() {
		return naam;
	}

	/**
	 * deze methode vult het artikelnummer in
	 * @param aN het artikelnummer
	 */
	public void setArtikelNr(int aN) {
		artikelNr = aN;
	}

	/**
	 * deze methode vult het aantal aanwezige artikelen in
	 * @param aan het aantal aanwezige artikelen
	 */
	public void setAantal(int aan) {
		aantal = aan;
	}

	/**
	 * deze methode vult de naam van het artikel in
	 * @param nm de naam
	 */
	public void setNaam(String nm) {
		naam = nm;
	}

	/**
	 * deze methode vult de prijs per artikel in
	 * @param pA de prijs per artikel
	 */
	public void setPrijsArtikel(double pA) {
		prijsArtikel = pA;
	}

	/**
	 * deze methode vraagt de prijs per artikel op
	 * @return de prijs per artikel
	 */
	public double getPrijsArtikel() {
		return prijsArtikel;
	}

	/**
	 * deze methode berekend de totaalprijs van dit onderdeel als het gebruikt is
	 * de prijs per artikel wordt vermenigvuldigd met het aantal gebruikte artikelen
	 * @return de prijs van het aantal gebruikte artikelen
	 */
	public double totaalPrijsOnderdeel() {
		totaal = getPrijsArtikel() * getAantal();
		return totaal;
	}

	/**
	 * deze methode zet alle gegevens van dit onderdeel op een rijtje
	 * @return een string met alle gegevens van dit onderdeel
	 */
	public String toString() {
		String s = "Artikelnummer: " + getArtikelNr() + ". Naam: " + getNaam()
				+ ". Aantal: " + getAantal() + ". Prijs per artikel: "
				+ getPrijsArtikel() + "\n";
		return s;
	}
}
