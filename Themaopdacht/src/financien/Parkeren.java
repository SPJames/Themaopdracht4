package financien;

public class Parkeren extends DienstType {
	private double dagPrijs;
	private int aantalDagen;
	private double totaal = 0;

	public Parkeren(double dP, int aD) {
		dagPrijs = dP;
		aantalDagen = aD;
	}

	public void setAantalDagen(int aD) {
		aantalDagen = aD;
	}

	public int getAantalDagen() {
		return aantalDagen;
	}

	public double getDagPrijs() {
		return dagPrijs;
	}

	public void setDagPrijs(double dP) {
		dagPrijs = dP;
	}

	// prijs voor het berekenen van de parkeerkosten
	public double dienstPrijs() {
		totaal = aantalDagen * dagPrijs;
		return totaal;
	}

	public String dienstType() {
		String s = "Parkeren";
		return s;
	}
}
