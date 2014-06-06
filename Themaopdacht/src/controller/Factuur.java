package controller;

import domein.klusbeheer.Klus;

/**
 * In de klasse Factuur wordt de factuur opgesteld
 */
public class Factuur {
	private Klus klus;
	private static int nummer = 1;
	private int factuurNummer;

	/**
	 * Er wordt een Factuur aangemaakt en meteen aan een klus gekoppelt
	 * de methode setKlus wordt gemaakt om een klus aan de Factuur te koppelen
	 * het factuurnummer wordt automatisch toegekend en verandert.
	 * @param k de klus waar de factuur voor opgesteld moet worden
	 */
	public Factuur(Klus k) {
		setKlus(k);
		factuurNummer = nummer++;
	}

	/**
	 * De factuur wordt aangemaakt
	 * @param fN de int voor het nummer van de factuur
	 */
	public void setFactuurNummer(int fN) {
		factuurNummer = fN;
	}

	/**
	 * deze methode vraagt het factuurnummer
	 * @return de int waarde van factuurNummer
	 */
	public int getFactuurNummer() {
		return factuurNummer;
	}

	/**
	 * deze methode geeft het FactuurNummer weer als een string
	 * @return s een String met het factuurnummer
	 */
	public String toString() {
		String s = "" + getFactuurNummer();
		return s;
	}

	/**
	 * deze methode vraagt de klus op waarvoor de factuur aangemaakt moet worden
	 * @return de klus waarvoor de factuur aangemaakt moet worden
	 */
	public Klus getKlus() {
		return klus;
	}

	/**
	 * Deze methode vult de klus in waarvoor de factuur gemaakt moet worden
	 * @param klus de klus waarvoor de factuur gemaakt wordt
	 */
	public void setKlus(Klus klus) {
		this.klus = klus;
	}

}
