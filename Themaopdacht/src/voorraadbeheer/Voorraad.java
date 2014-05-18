package voorraadbeheer;

import java.util.ArrayList;

public class Voorraad {

	private ArrayList<Brandstof> alleBrandstof = new ArrayList<Brandstof>();
	private ArrayList<Onderdeel> alleOnderdelen = new ArrayList<Onderdeel>();
	private ArrayList<Bestelling> alleBestellingen = new ArrayList<Bestelling>();

	public Voorraad() {

	}

	// BRANDSTOF

	public ArrayList<Brandstof> getAlleBrandstof() {
		return alleBrandstof;
	}

	public boolean heeftBrandstof(String tp) {
		boolean result = false;
		if (zoekBrandstof(tp) != null) {
			result = true;
		}
		return result;
	}

	public Brandstof zoekBrandstof(String tp) {
		// zoeken op brandstofType
		Brandstof result = null;
		for (Brandstof b : alleBrandstof) {
			if (b.getBrandstofType().equals(tp)) {
				result = b;
			}
		}
		return result;
	}

	public boolean voegBrandstofToe(Brandstof nwB) {
		// Brandstof toevoegen aan voorraad, dit kunnen meer van het zelfde type
		// zijn!
		alleBrandstof.add(nwB);
		return true;
	}

	public boolean verwijderBrandstof(Brandstof exB) {
		// kan alleen worden verwijderd als het type bestaat
		boolean result = false;
		if (heeftBrandstof(exB.getBrandstofType())) {
			result = true;
			alleBrandstof.remove(exB);
		}
		return result;
	}

	public int aantalBrandstof() {
		if (alleBrandstof.size() != 0) {
			return alleBrandstof.size();
		} else {
			return 0;
		}
	}

	// ONDERDEEL

	public ArrayList<Onderdeel> getAlleOnderdelen() {
		return alleOnderdelen;
	}

	public boolean heeftOnderdeel(int aN) {
		boolean result = false;
		if (zoekOnderdeel(aN) != null) {
			result = true;
		}
		return result;
	}

	public Onderdeel zoekOnderdeel(int aN) {
		// zoeken op artikelnr
		Onderdeel result = null;
		for (Onderdeel o : alleOnderdelen) {
			if (o.getArtikelNr() == (aN)) {
				result = o;
			}
		}
		return result;
	}

	public boolean voegOnderdeelToe(Onderdeel nwO) {
		// Onderdeel toevoegen aan voorraad, dit kunnen meer van het zelfde
		// artikelnr zijn!
		if (!heeftOnderdeel(nwO.getArtikelNr())) {
			alleOnderdelen.add(nwO);
		}
		// als het artikelnr er is moet het aantal van het nieuwe artikel erbij
		// opgeteld worden
		if (heeftOnderdeel(nwO.getArtikelNr())) {
			int erbij = nwO.getAantal();
			int aN = 0;
			for (Onderdeel o : alleOnderdelen) {
				if (o.getArtikelNr() == (aN)) {
					o.setAantal(o.getAantal() + erbij);
				}
			}
		}
		return true;
	}

	public boolean verwijderOnderdeel(Onderdeel exO) {
		// kan alleen worden verwijderd als het artikelNr bestaat
		boolean result = false;
		if (heeftOnderdeel(exO.getArtikelNr())) {
			result = true;
			alleOnderdelen.remove(exO);
		}
		return result;
	}

	public int aantalOnderdelen() {
		if (alleOnderdelen.size() != 0) {
			return alleOnderdelen.size();
		} else {
			return 0;
		}
	}

	// BESTELLING

	public ArrayList<Bestelling> getAlleBestellingen() {
		return alleBestellingen;
	}

	public boolean heeftBestelling(int bN) {
		boolean result = false;
		for (Bestelling b : alleBestellingen) {
			if (b.getBestellingsNr() == bN) {
				result = true;
			}
		}
		return result;
	}

	public boolean zoekBestelling(int bN) {
		// zoeken op bestelnr
		Boolean result = false;
		for (Bestelling o : alleBestellingen) {
			if (o.getBestellingsNr() == (bN)) {
				result = true;
			}
		}
		return result;
	}

	public boolean voegBestellingToe(Bestelling nwBe) {
		// kan alleen worden toegevoegd als bestelNr niet bestaat!
		if (!heeftBestelling(nwBe.getBestellingsNr())) {
			alleBestellingen.add(nwBe);
			return true;
		}
		return false;
	}

	public boolean verwijderBestelling(Bestelling exBe) {
		// kan alleen worden verwijderd als het bestelNr bestaat
		boolean result = false;
		if (heeftBestelling(exBe.getBestellingsNr())) {
			result = true;
			alleBestellingen.remove(exBe);
		}
		return result;
	}

	public int aantalBestellingen() {
		if (alleBestellingen.size() != 0) {
			return alleBestellingen.size();
		} else {
			return 0;
		}
	}

	public String toString() {
		String i = "";
		String j = "";
		for (Onderdeel o : alleOnderdelen) {
			i += "" + o.toString();
		}
		for (Brandstof b : alleBrandstof) {
			j += "" + b.toString();
		}
		String s = "Het aantal soorten onderdelen is: " + aantalOnderdelen()
				+ "\nDeze onderdelen zijn: \n" + i
				+ "\nHet aantal soorten brandstof is: " + aantalBrandstof()
				+ "\nDeze brandstoffen zijn: \n " + j;
		return s;
	}
}
