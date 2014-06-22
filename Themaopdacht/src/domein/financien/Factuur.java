package domein.financien;

import java.util.HashMap;

import domein.klusbeheer.Klus;
import domein.voorraadbeheer.Brandstof;
import domein.voorraadbeheer.Onderdeel;

/**
 * In de klasse Factuur wordt de factuur opgesteld en berekend
 */
public class Factuur {
	private Klus klus;
	private static int nummer = 1;
	private int factuurNummer;

	private double btw = 1.21;

	private double korting;

	private double manurenprijs;
	private HashMap<String, Double> onderdelenprijs = new HashMap<String, Double>();
	private HashMap<String, Double> brandstofprijs = new HashMap<String, Double>();
	private double totaalprijs;

	/**
	 * Er wordt een Factuur aangemaakt bij een afgeronde klus.
	 * Het factuurnummer wordt automatisch toegekend en verandert.
	 * De gemaakte kosten van de klus worden opgevraagd en de eindprijs wordt berekend.
	 * 
	 * @param k de klus waar de factuur voor opgesteld moet worden
	 */
	public Factuur(Klus k) {
		setKlus(k);
		factuurNummer = nummer++;
		setManurenprijs(k);
		setBrandstofprijs(k);
		setOnderdelenprijs(k);
		setTotaalprijs(k);
	}

	/**
	 * In deze methode wordt de kosten van een uur werken opgevraagd
	 * 
	 * @return de kosten van een uur werktijd
	 */
	public double getManurenprijs() {
		return manurenprijs;
	}

	/**
	 * In deze methode wordt de totaalkosten voor de gewerkte uren berekend
	 * 
	 * @param k de klus waarvan de kosten moeten worden berekend
	 */
	public void setManurenprijs(Klus k) {
		double prijs = 0.0;
		prijs = k.getManuren() * 10.0; // 10.0 = prijs per uur
		//k.getManuren = aantal gewerkte uren van deze klus
		manurenprijs = prijs;
	}

	/**
	 * In deze methode worden van alle onderdelen per onderdeel de totaalprijs opgevraagd
	 * 
	 * @return de prijs van een onderdeel
	 */
	public HashMap<String, Double> getOnderdelenprijs() {
		return onderdelenprijs;
	}

	/**
	 * in deze methode wordt de prijs van de gebruikte onderdelen berekend
	 * 
	 * @param k de klus waarvan de prijs berekend moet worden
	 */
	public void setOnderdelenprijs(Klus k) {
		HashMap<Onderdeel, Integer> gebruikteOnderdelen = k.getGebruikteOnderdelen();
		for (Onderdeel o : gebruikteOnderdelen.keySet()) {
			double a = gebruikteOnderdelen.get(o) * o.getPrijsArtikel();
			onderdelenprijs.put(o.getNaam(), a);
		}
	}

	/**
	 * deze methode vraagt de brandstofprijs op
	 * 
	 * @return de brandstofprijs
	 */
	public HashMap<String, Double> getBrandstofprijs() {
		return brandstofprijs;
	}

	/**
	 * deze methode berekend de totale brandstofprijs voor een klus
	 * 
	 * @param k de klus waarvan de brandstofkosten berekend moeten worden
	 */
	public void setBrandstofprijs(Klus k) {
		HashMap<Brandstof, Double> gebruikteBrandstof = k.getGebruikteBrandstof(); // get de gebruikte brandstof
		for (Brandstof b : gebruikteBrandstof.keySet()) {
			double a = gebruikteBrandstof.get(b) * b.getPrijsPerLiter();
			brandstofprijs.put(b.getBrandstofType(), a);
		}
	}

	/**
	 * deze methode vraagt de totaalprijs exclusief de btw op
	 * 
	 * @return de totaalprijs exclusief de btw
	 */
	public double getTotaalprijsExBtw() {
		return totaalprijs;
	}

	/**
	 * deze methode vraagt de totaalprijs met btw op
	 * 
	 * @return de totaalprijs met btw
	 */
	public double getTotaalprijs() {
		return totaalprijs * btw;
	}

	/**
	 * deze methode vraagt de totaalprijs met btw en korting op
	 * 
	 * @return de totaalprijs met btw en korting
	 */
	public double getTotaalprijsKorting() {
		return (totaalprijs * btw) * (100 / korting);
	}

	/**
	 * deze methode berekend de totaalprijs aan onderdelen en benzine en
	 * werktijd voor een klus
	 * 
	 * @param k de meegegeven klus
	 */
	public void setTotaalprijs(Klus k) {
		double prijs = 0.0;

		for (String o : onderdelenprijs.keySet()) {
			prijs += onderdelenprijs.get(o);
		}

		for (String b : brandstofprijs.keySet()) {
			 prijs += brandstofprijs.get(b);
		}

		prijs += manurenprijs;

		totaalprijs = prijs;
	}

	/**
	 * Het factuurnummer wordt ingevuld
	 * 
	 * @param fN de int voor het nummer van de factuur
	 */
	public void setFactuurNummer(int fN) {
		factuurNummer = fN;
	}

	/**
	 * deze methode vraagt het factuurnummer op
	 * 
	 * @return de int waarde van factuurNummer
	 */
	public int getFactuurNummer() {
		return factuurNummer;
	}

	/**
	 * deze methode geeft het FactuurNummer weer als een string
	 * 
	 * @return s een String met het factuurnummer
	 */
	public String toString() {
		String s = "" + getFactuurNummer();
		return s;
	}

	/**
	 * deze methode vraagt de klus op waarvoor de factuur aangemaakt moet worden
	 * 
	 * @return de klus waarvoor de factuur aangemaakt moet worden
	 */
	public Klus getKlus() {
		return klus;
	}

	/**
	 * Deze methode vult de klus in waarvoor de factuur gemaakt moet worden
	 * 
	 * @param klus de klus waarvoor de factuur gemaakt wordt
	 */
	public void setKlus(Klus klus) {
		this.klus = klus;
	}

	/**
	 * deze methode vraagt de hoeveelheid korting op die de klant krijgt
	 * 
	 * @return het percentage korting dat gegeven gaat worden
	 */
	public double getKorting() {
		return korting;
	}

	/**
	 * deze methode vult de hoeveelheid korting in die de klant krijgt
	 * 
	 * @param korting het percentage korting dat gegeven gaat worden
	 */
	public void setKorting(double korting) {
		this.korting = korting;
	}
}