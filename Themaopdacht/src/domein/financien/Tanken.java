package domein.financien;

import domein.voorraadbeheer.Brandstof;

/**
 * De klasse Tanken berekend de kosten voor het tanken met een auto
 * Er worden een aantal methodes geerft van de abstracte klasse DienstType
 */
public class Tanken extends DienstType {
	private double aantalLiter;
	private double totaalB;
	private Brandstof deBrandstof;

	//de klasse wordt geinitialiseerd
	public Tanken() {
		super();
	}

	/**
	 * deze methode maakt de dienst tanken aan en vult het aantal getankte liters benzine in
	 * 
	 * @param aL de double waarde voor het aantal getankte liters
	 */
	public Tanken(double aL) {
		super();
		aantalLiter = aL;
	}

	/**
	 * deze methode vult het aantal getankte liters in
	 * 
	 * @param aL de double waarde voor het aantal getankte liters
	 */
	public void setGebruikteLiter(double aL) {
		aantalLiter = aL;
	}

	/**
	 * Deze methode vult het goede type brandstof in
	 * 
	 * @param br het type brandstof
	 */
	//deze methode is nodig want de prijs per liter verschilt per brandstof type
	public void setDeBrandstof(Brandstof br) {
		deBrandstof = br;
	}

	/**
	 * deze methode vraagt het brandstoftype op
	 * 
	 * @return het type brandstof
	 */
	public Brandstof getDeBrandstof() {
		return deBrandstof;
	}

	/**
	 * deze methode vraagt het getankte aantal liters op
	 * 
	 * @return het getankte aantal liters
	 */
	public double getGebruikteLiter() {
		return aantalLiter;
	}

	/**
	 * Deze methode berekend de totaalprijs voor het tanken
	 * Hiervoor worden de methode getGebruikteLiter en getPrijsPerLiter(uit klasse brandstof) gebruikt
	 * de prijs per liter wordt vermenigvuldigt met het aantal getankte liters
	 * 
	 * @return de totaalprijs van het tanken
	 */
	public double dienstPrijs() {
		totaalB = getGebruikteLiter() * deBrandstof.getPrijsPerLiter();
		return totaalB;
	}

	/**
	 * deze methode geeft de naam van dit diensttype weer als een string
	 * 
	 * @return de naam van dit diensttype
	 */
	public String dienstType() {
		String s = "Tanken";
		return s;
	}
}
