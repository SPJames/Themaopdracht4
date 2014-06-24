package domein.financien;

import java.io.Serializable;

import domein.voorraadbeheer.Onderdeel;

/**
 * De klasse Onderhoud berekend de kosten voor het onderhoud aan een auto
 * Er worden een aantal methodes geerft van de abstracte klasse DienstType
 */
public class Onderhoud extends DienstType implements Serializable{
	private static final long serialVersionUID = 1L;
	private double manUren, prijsPerManuur;
	private double totaalMU, totaal;
	private Onderdeel deOnderdelen;

	//de klasse wordt geinitialiseerd
	public Onderhoud() {
		super();
	}

	/**
	 * Deze methode maakt een onderhoudsdienst aan en
	 * vult het aantal gewerkte manuren en de kosten per manuren in
	 * 
	 * @param mU het aantal gewerkte manUren
	 * @param pPM de prijs per gewerkt uur
	 */
	public Onderhoud(double mU, double pPM) {
		super();
		manUren = mU;
		prijsPerManuur = pPM;
	}

	/**
	 * deze methode berekend de totaalprijs van het onderhoud 
	 * Deze wordt berekend mbv de atributen manUren en prijsPerManuur
	 * 
	 * @return de totaalprijs voor het aantal gewerkte uren
	 */
	public double totaalManuurPrijs() {
		totaalMU = manUren * prijsPerManuur;
		return totaalMU;
	}

	/**
	 * deze methode vult het aantal manUren in
	 * 
	 * @param mU het aantal gewerkte uren
	 */
	public void setManUren(double mU) {
		manUren = mU;
	}

	/**
	 * deze methode vult de prijsPerManuur in
	 * 
	 * @param de prijs per gewerkt uur
	 */
	public void setPrijsPerManuur(double pPM) {
		prijsPerManuur = pPM;
	}

	/**
	 * deze methode vult het Onderdeel deOnderdelen in 
	 * hiervan kunnen er meerdere worden toegevoegd per onderhoudsbeurt
	 * 
	 * @param dO het onderdeel
	 */
	public void setDeOnderdelen(Onderdeel dO) {
		deOnderdelen = dO;
	}

	/**
	 * deze methode vraag het deOnderdelen op
	 * 
	 * @return de waarde van deOnderdelen
	 */
	public Onderdeel getDeOnderdelen() {
		return deOnderdelen;
	}

	/**
	 * Deze methode geeft het diensttype (in dit geval onderhoud) weer in de vorm van een string
	 * 
	 * @return s de naam van dit diensttype
	 */
	public String dienstType() {
		String s = "Onderhoud";
		return s;
	}

	/**
	 * Deze methode berekend de totale onderhoudskosten
	 * Deze worden berekend door de totaalkosten van manuren en onderdelen bij elkaar op te tellen
	 * deze totaalkosten worden berekend mbv de methoden totaalManuurPrijs() en totaalPrijsOnderdeel()(uit klasse Onderdeel)
	 * 
	 * @return totaal de totaalkosten van alle gewerkte uren en de onderdeelkosten
	 */
	public double dienstPrijs() {
		totaal = totaalManuurPrijs() + deOnderdelen.totaalPrijsOnderdeel();
		return totaal;
	}
}
