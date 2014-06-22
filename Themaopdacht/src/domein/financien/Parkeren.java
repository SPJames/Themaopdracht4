package domein.financien;

/**
 * De klasse Parkeren berekend de kosten voor het parkeren van een auto
 * Er worden een aantal methodes geerft van de abstracte klasse DienstType
 */
public class Parkeren extends DienstType {
	private double dagPrijs;
	private int aantalDagen;
	private double totaal = 0;

	//de klasse wordt geinitialiseerd
	public Parkeren() {
		super();
	}

	/**
	 * deze methode maakt de dienst parkeren aan en 
	 * vult de prijs per dag en het aantal geparkeerde dagen in
	 * 
	 * @param dP de kosten van een dag parkeren
	 * @param aD het aantal dagen dat een auto geparkeerd is
	 */
	public Parkeren(double dP, int aD) {
		super();
		dagPrijs = dP;
		aantalDagen = aD;
	}

	/**
	 * deze methode vult het aantal geparkeerde dagen in
	 * 
	 * @param aD het aantal geparkeerde dagen
	 */
	public void setAantalDagen(int aD) {
		aantalDagen = aD;
	}

	/**
	 * deze methode vraagt het aantal geparkeerde dagen op
	 * 
	 * @return het aantal geparkeerde dagen
	 */
	public int getAantalDagen() {
		return aantalDagen;
	}

	/**
	 * deze methode vraagt de prijs per dag op
	 * 
	 * @return de kosten van een dag parkeren
	 */
	public double getDagPrijs() {
		return dagPrijs;
	}

	/**
	 * deze methode vult de prijs per dag in
	 * 
	 * @param dP de kosten van een dag parkeren
	 */
	public void setDagPrijs(double dP) {
		dagPrijs = dP;
	}

	// prijs voor het berekenen van de parkeerkosten
	/**
	 * deze methode berekent de kosten van het parkeren door de prijs per dag
	 * te vermenigvuldigen met het aantal geparkeerde dagen
	 * 
	 * @return de totaalprijs voor het parkeren
	 */
	public double dienstPrijs() {
		totaal = aantalDagen * dagPrijs;
		return totaal;
	}

	/**
	 * deze methode geeft de naam van dit diensttype weer als een string
	 * 
	 * @return de string met de naam van dit diensttype
	 */
	public String dienstType() {
		String s = "Parkeren";
		return s;
	}
}
