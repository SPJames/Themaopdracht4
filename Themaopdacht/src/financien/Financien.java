package financien;

import java.util.ArrayList;

import Klusbeheer.Monteur;

public class Financien {
	protected ArrayList<Factuur> alleFactures = new ArrayList<Factuur>();
	private ArrayList<Betaling> alleBetalingen = new ArrayList<Betaling>();

	public Financien() {
	}

	// Factuur

	public boolean heeftFactuur(int fN) {
		boolean result = false;
		for(Factuur f: alleFactures){
			if(f.getFactuurNummer()==fN){
				result = true;
			}
		}
		return result;
	}

	public Factuur zoekFactuur(int fN) {
		// zoeken op factuurnr
		Factuur result = null;
		for (Factuur f : alleFactures) {
			if (f.getFactuurNummer() == fN) {
				result = f;
			}
		}
		return result;
	}

	public boolean voegFactuurToe(Factuur nwF) {
		//if(heeftFactuur(nwF.getFactuurNummer())){
		//	return false;
		//}
		//else{
			alleFactures.add(nwF);	
			return true;
		//}
	}
	
	public ArrayList<Factuur> getAlleFactures() {
		return alleFactures;
	}
}