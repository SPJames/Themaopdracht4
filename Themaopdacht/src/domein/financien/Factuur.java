package domein.financien;

import java.util.ArrayList;
import java.util.HashMap;

import domein.klusbeheer.Klus;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

/**
 * In de klasse Factuur wordt de factuur opgesteld
 */
public class Factuur {
	private Klus klus;
	private static int nummer = 1;
	private int factuurNummer;
	
	private double manurenprijs;
	private HashMap<String, Double> onderdelenprijs = new HashMap<String, Double>();
	private HashMap<String, Double> brandstofprijs = new HashMap<String, Double>();
	private double totaalprijs;

	/**
	 * Er wordt een Factuur aangemaakt en meteen aan een klus gekoppelt
	 * de methode setKlus wordt gemaakt om een klus aan de Factuur te koppelen
	 * het factuurnummer wordt automatisch toegekend en verandert.
	 * @param k de klus waar de factuur voor opgesteld moet worden
	 */
	public Factuur(Klus k) {
		setKlus(k);
		factuurNummer = nummer++;
		setManurenprijs(k);
	}

	public double getManurenprijs() {
		return manurenprijs;
	}

	public void setManurenprijs(Klus k) {
		double prijs = 0.0;
		prijs = k.getManuren() * 0.0; // 0.0 = prijs per uur
		
		manurenprijs = prijs;
	}

	public HashMap<String, Double> getOnderdelenprijs() {
		return onderdelenprijs;
	}

	public void setOnderdelenprijs(Klus k) {
		HashMap<Onderdeel, Integer>gebruikteOnderdelen = k.getGebruikt();
		for (Onderdeel o : gebruikteOnderdelen.keySet()) {
			double a = gebruikteOnderdelen.get(o) * 0.0; // 0.0 = prijs per uur
		    onderdelenprijs.put(o.getNaam(), a);
		}
	}

	public HashMap<String, Double> getBrandstofprijs() {
		return brandstofprijs;
	}

	public void setBrandstofprijs(Klus k) {
		HashMap<Brandstof, Integer>gebruikteBrandstof = k.getGebruikteBrandstof(); // get de gebruikte brandstof
		for (Brandstof b : gebruikteBrandstof.keySet()) {
			double a = gebruikteBrandstof.get(b) * 0.0; // 0.0 = prijs per uur
		    brandstofprijs.put(b.getBrandstofType(), a);
		}
	}

	public double getTotaalprijs() {
		return totaalprijs;
	}

	public void setTotaalprijs(Klus k) {
		double prijs = 0.0;
		
		for (String o : onderdelenprijs.keySet()) {
			prijs =+ onderdelenprijs.get(o);
		}
		
		for (String b : brandstofprijs.keySet()) {
			prijs =+ brandstofprijs.get(b);
		}
		
		prijs =+ manurenprijs;
		
		totaalprijs = prijs;
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
