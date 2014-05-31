package klantenbinding;

import java.util.ArrayList;
import voorraadbeheer.Voorraad;
import Klusbeheer.Planner;

public class Bedrijf {
	private ArrayList<Klant> alleKlanten = new ArrayList<Klant>();
	private String bedrijfsNaam;
	private Planner dePlanner;
	private Voorraad deVoorraad;

	public Bedrijf(String nm) {
		setNaam(nm);
	}

	public ArrayList<Klant> getAlleKlanten() {
		return alleKlanten;
	}

	public boolean voegKlantToe(Klant nwK) {
		if (heeftKlant(nwK.getEmail())) {
			return false;
		} else { // klant kan alleen worden toegevoegd als deze nog niet
					// geregistreerd is
			alleKlanten.add(nwK);
			return true;
		}
	}

	public boolean heeftKlant(String em) {
		boolean result = false;
		if (zoekKlant(em) != null) {
			result = true;
		}
		return result;
	}

	public Klant zoekKlant(String em) {
		Klant result = null;
		for (Klant k : alleKlanten) {
			if (k.getEmail().equals(em)) {
				result = k;
			}
		}
		return result;
	}

	public boolean verwijderKlant(Klant exk) {
		boolean resultaat = false;
		if (heeftKlant(exk.getEmail())) {// Klant kan alleen verwijdert worden
											// als deze geregistreerd is
			alleKlanten.remove(exk);
			resultaat = true;
		}
		return resultaat;
	}

	public int aantalKlanten() {
		if (alleKlanten.size() != 0) {
			return alleKlanten.size();
		} else {
			return 0;
		}

	}

	public String getNaam() {
		return bedrijfsNaam;
	}

	public void setNaam(String nm) {
		bedrijfsNaam = nm;
	}

	public Planner getDePlanner() {
		return dePlanner;
	}

	public void setDePlanner(Planner p) {
		dePlanner = p;
	}

	public Voorraad getDeVoorraad() {
		return deVoorraad;
	}

	public void setDeVoorraad(Voorraad v) {
		deVoorraad = v;
	}

	public Planner getDeFinancien() {
		return dePlanner;
	}

	public String toString() {
		String i = "";
		for (Klant k : alleKlanten) {
			i += "" + k.toString();
		}
		String s = "Het aantal contacten is: " + aantalKlanten()
				+ "\nDeze contacten zijn: \n" + i;
		return s;
	}

}
