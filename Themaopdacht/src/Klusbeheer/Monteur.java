package Klusbeheer;
public class Monteur {
	private String naam;
	private Klus deKlus;

	public Monteur(String nm) {
		naam = nm;
	}

	public Klus getDeKlus() {
		return deKlus;
	}

	public void setDeKlus(Klus dK) {
		deKlus = dK;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String nm) {
		naam = nm;
	}

	public String toString() {
		String s = "" + getNaam();
		return s;
	}
}
