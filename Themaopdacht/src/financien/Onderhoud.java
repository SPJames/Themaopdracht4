package financien;

import voorraadbeheer.Onderdeel;

/**
 * De klasse Onderhoud berekend de kosten voor het onderhoud aan een auto
 * Er worden een aantal methodes geerft van de abstracte klasse DienstType
 */
public class Onderhoud extends DienstType {
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
	 * @param mU is de double voor manUren
	 * @param pPM is de double voor prijsPerManuur
	 */
	public Onderhoud(double mU, double pPM) {
		super();
		manUren = mU;
		prijsPerManuur = pPM;
	}

	/**
	 * deze methode berekend de totaalprijs van het onderhoud 
	 * Deze wordt berekend mbv de atributen manUren en prijsPerManuur
	 * @return de totaalprijs door de prijsPerManuur te vermenigvuldigen met het aantal gemaakte manUren
	 */
	public double totaalManuurPrijs() {
		totaalMU = manUren * prijsPerManuur;
		return totaalMU;
	}

	/**
	 * deze methode vult het aantal manUren in
	 * @param mU de double waarde voor het aantal manUren
	 */
	public void setManUren(double mU) {
		manUren = mU;
	}

	/**
	 * deze methode vult de prijsPerManuur in
	 * @param pPM de double waarde voor de prijsPerManuur
	 */
	public void setPrijsPerManuur(double pPM) {
		prijsPerManuur = pPM;
	}

	/**
	 * deze methode vult het Onderdeel deOnderdelen in 
	 * hiervan kunnen er meerdere worden toegevoegd per onderhoudsbeurt
	 * @param dO het Onderdeel dat in deOnderdelen komt te staan
	 */
	public void setDeOnderdelen(Onderdeel dO) {
		deOnderdelen = dO;
	}

	/**
	 * deze methode vraag het deOnderdelen op
	 * @return de waarde van deOnderdelen
	 */
	public Onderdeel getDeOnderdelen() {
		return deOnderdelen;
	}

	/**
	 * Deze methode geeft het diensttype (in dit geval onderhoud) weer in de vorm van een string
	 * @return s String met de naam van dit diensttype
	 */
	public String dienstType() {
		String s = "Onderhoud";
		return s;
	}

	// prijs voor de onderhoudkosten
	/**
	 * Deze methode berekend de totale onderhoudskosten
	 * Deze worden berekend door de totaalkosten van manuren en onderdelen bij elkaar op te tellen
	 * deze totaalkosten worden berekend mbv de methoden totaalManuurPrijs() en totaalPrijsOnderdeel()(uit klasse Onderdeel)
	 * @return totaal double waarde van de som van de teruggegeven doubles van totaalManuurPrijs() en totaalPrijsOnderdeel()
	 */
	public double dienstPrijs() {
		totaal = totaalManuurPrijs() + deOnderdelen.totaalPrijsOnderdeel();
		return totaal;
	}

	//KAN DIT WEG?
	// public void setGebruikteOnderdelen(int gO){
	// gebruikteOnderdelen = gO;
	// }

}
