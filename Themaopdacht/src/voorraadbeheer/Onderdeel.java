package voorraadbeheer;

public class Onderdeel {
	private int artikelNr, aantal;
	private String naam;
	private double prijsArtikel;
	private double totaal;

	public Onderdeel(int aN, int aan, String nm, double pA) {
		artikelNr = aN;
		aantal = aan;
		naam = nm;
		prijsArtikel = pA;
	}

	public int getArtikelNr() {
		return artikelNr;
	}

	public int getAantal() {
		return aantal;
	}

	public String getNaam() {
		return naam;
	}

	public void setArtikelNr(int aN) {
		artikelNr = aN;
	}

	public void setAantal(int aan) {
		aantal = aan;
	}

	public void setNaam(String nm) {
		naam = nm;
	}

	public void setPrijsArtikel(double pA) {
		prijsArtikel = pA;
	}

	public double getPrijsArtikel() {
		return prijsArtikel;
	}

	public double totaalPrijsOnderdeel() {
		totaal = getPrijsArtikel() * getAantal();
		return totaal;
	}

	public String toString() {
		String s = "Artikelnummer: " + getArtikelNr() + ". Naam: " + getNaam()
				+ ". Aantal: " + getAantal() + ". Prijs per artikel: "
				+ getPrijsArtikel() + "\n";
		return s;
	}
}
