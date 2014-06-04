package financien;

import Klusbeheer.Klus;

public class Factuur {
	private Klus klus;
	private static int nummer = 1;
	private int factuurNummer;

	public Factuur(Klus k) {
		setKlus(k);
		factuurNummer = nummer++;
	}

	public void setFactuurNummer(int fN) {
		factuurNummer = fN;
	}

	public int getFactuurNummer() {
		return factuurNummer;
	}

	public String toString() {
		String s = "" + getFactuurNummer();
		return s;
	}

	public Klus getKlus() {
		return klus;
	}

	public void setKlus(Klus klus) {
		this.klus = klus;
	}

}
