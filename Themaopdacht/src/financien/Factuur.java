package financien;

public class Factuur {
	private int factuurNummer;
	private Betaling deBetalingen;

	public Factuur(int fN) {
		factuurNummer = fN;
	}

	public void setFactuurNummer(int fN) {
		factuurNummer = fN;
	}

	public int getFactuurNummer() {
		return factuurNummer;
	}

	public void setDeBetalingen(Betaling dB) {
		deBetalingen = dB;
	}

	public Betaling getDeBetalingen() {
		return deBetalingen;
	}

	public String toString() {
		String s = "" + getFactuurNummer();
		return s;
	}

}
