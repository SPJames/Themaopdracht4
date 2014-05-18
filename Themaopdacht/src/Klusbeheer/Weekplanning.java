package Klusbeheer;

import java.util.ArrayList;

public class Weekplanning {
	private int weeknummer;
	private ArrayList<Klus> alleKlussen = new ArrayList<Klus>();
	private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();

	public Weekplanning(int wn) {
		weeknummer = wn;
	}

	// Klus
	public ArrayList<Klus> getAlleKlussen() {
		return alleKlussen;
	}

	public boolean heeftKlus(int kn) {
		boolean result = false;
		if (zoekKlus(kn) != null) {
			result = true;
		}
		return result;
	}

	public Klus zoekKlus(int kn) {
		// zoeken op klusnummer
		Klus result = null;
		for (Klus k : alleKlussen) {
			if (k.getKlusNummer() == kn) {
				result = k;
			}
		}
		return result;
	}

	public boolean voegKlusToe(Klus nwK) {
		if (heeftKlus(nwK.getKlusNummer())) {
			return false;
		} else {
			alleKlussen.add(nwK);
			return true;
		}
	}

	public boolean verwijderKlus(Klus exK) {
		boolean result = false;
		if (heeftKlus(exK.getKlusNummer())) {
			result = true;
			alleKlussen.remove(exK);
		}
		return result;
	}

	public int aantalKlussen() {
		if (alleKlussen.size() != 0) {
			return alleKlussen.size();
		} else {
			return 0;
		}
	}

	// Monteur

	public ArrayList<Monteur> getAlleMonteurs() {
		return alleMonteurs;
	}

	public boolean heeftMonteur(String nm) {
		boolean result = false;
		if (zoekMonteur(nm) != null) {
			result = true;
		}
		return result;
	}

	public Monteur zoekMonteur(String nm) {
		// zoeken op naam
		Monteur result = null;
		for (Monteur m : alleMonteurs) {
			if (m.getNaam().equals(nm)) {
				result = m;
			}
		}
		return result;
	}

	public boolean voegMonteurToe(Monteur nwM) {
		alleMonteurs.add(nwM);
		return true;
	}

	public boolean verwijderMonteur(Monteur exM) {
		boolean result = false;
		if (heeftMonteur(exM.getNaam())) {
			result = true;
			alleKlussen.remove(exM);
		}
		return result;
	}

	// weekplanning

	public int getWeeknummer() {
		return weeknummer;
	}

	public void setWeeknummer(int wn) {
		weeknummer = wn;
	}

	public String toString() {
		String s = "Planning voor week " + getWeeknummer();
		return s;
	}
}
