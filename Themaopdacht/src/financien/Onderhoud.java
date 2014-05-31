package financien;

import voorraadbeheer.Onderdeel;

public class Onderhoud extends DienstType {
	private double manUren, prijsPerManuur;
	private double totaalMU, totaal;
	private Onderdeel deOnderdelen;

	public Onderhoud() {
		super();
	}

	public Onderhoud(double mU, double pPM) {
		super();
		manUren = mU;
		prijsPerManuur = pPM;
	}

	public double totaalManuurPrijs() {
		totaalMU = manUren * prijsPerManuur;
		return totaalMU;
	}

	public void setManUren(double mU) {
		manUren = mU;
	}

	public void setPrijsPerManuur(double pPM) {
		prijsPerManuur = pPM;
	}

	public void setDeOnderdelen(Onderdeel dO) {
		deOnderdelen = dO;
	}

	public Onderdeel getDeOnderdelen() {
		return deOnderdelen;
	}

	public String dienstType() {
		String s = "Onderhoud";
		return s;
	}

	// prijs voor de onderhoudkosten
	public double dienstPrijs() {
		totaal = totaalManuurPrijs() + deOnderdelen.totaalPrijsOnderdeel();
		return totaal;
	}

	// public void setGebruikteOnderdelen(int gO){
	// gebruikteOnderdelen = gO;
	// }

}
