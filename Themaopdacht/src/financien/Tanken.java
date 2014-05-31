package financien;

import voorraadbeheer.Brandstof;

public class Tanken extends DienstType {
	private double aantalLiter;
	private double totaalB;
	private Brandstof deBrandstof;

	public Tanken() {
		super();
	}

	public Tanken(double aL) {
		super();
		aantalLiter = aL;
	}

	public void setGebruikteLiter(double aL) {
		aantalLiter = aL;
	}

	public void setDeBrandstof(Brandstof br) {
		deBrandstof = br;
	}

	public Brandstof getDeBrandstof() {
		return deBrandstof;
	}

	public double getGebruikteLiter() {
		return aantalLiter;
	}

	// prijs voor tanken
	public double dienstPrijs() {
		totaalB = getGebruikteLiter() * deBrandstof.getPrijsPerLiter();
		return totaalB;
	}

	public String dienstType() {
		String s = "Tanken";
		return s;
	}
}
