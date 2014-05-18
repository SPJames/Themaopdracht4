package financien;

import java.util.ArrayList;

import klantenbinding.Auto;
import voorraadbeheer.Brandstof;

public class Betaling {
	private int kortingsPrecentage;
	private int btw;
	private boolean betaald;
	private double totaal = 0;
	private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
	private ArrayList<DienstType> alleDiensten = new ArrayList<DienstType>();

	public Betaling(int k, int b) {
		kortingsPrecentage = k;
		btw = b;
	}

	public double totaalPrijs() {
		totaal = (totaal + btw) - getKortingsPrecentage();
		return totaal;
	}

	public void setKortingsPrecentage(int k) {
		kortingsPrecentage = k;
	}

	public int getKortingsPrecentage() {
		return kortingsPrecentage;
	}

	public int getBtw() {
		return btw;
	}

	public void setBtw(int b) {
		btw = b;
	}

	// AUTO

	public boolean heeftAuto(String kt) {
		boolean result = false;
		if (zoekAuto(kt) != null) {
			result = true;
		}
		return result;
	}

	public Auto zoekAuto(String kt) {
		// zoeken op kenteken
		Auto result = null;
		for (Auto a : alleAutos) {
			if (a.getKenteken().equals(kt)) {
				result = a;
			}
		}
		return result;
	}

	public boolean voegAutoToe(Auto nwA) {
		alleAutos.add(nwA);
		return true;
	}

	public boolean verwijderAuto(Auto exA) {
		// kan alleen worden verwijderd als het kenteken bestaat
		boolean result = false;
		if (heeftAuto(exA.getKenteken())) {
			result = true;
			alleAutos.remove(exA);
		}
		return result;
	}

	// checken of er is betaald door de Klant
	public void setBetaald(boolean b) {
		betaald = b;
	}
}
