package domein.klusbeheer;

import java.io.Serializable;
import java.util.Calendar;

/** 
 * in deze klasse wordt de weekplanning bijgehouden
 */
public class Weekplanning implements Serializable{
	private static final long serialVersionUID = 1L;
	Calendar c = Calendar.getInstance();
	private int weekdag = c.get(Calendar.DAY_OF_WEEK);
	private int weeknr = c.get(Calendar.WEEK_OF_YEAR);	
	private Klus[][][] planning = new Klus[6][7][52];
	
	/**
	 * deze methode vraagt het weeknummer op
	 * 
	 * @return het weeknummer
	 */
	public int getWeekNr() {
		return weeknr;
	}
	
	/**
	 * Deze methode vraagt de klussen in een planning op
	 * 
	 * @return de klussen die in de planning staan
	 */
	public Klus[][][] getKlussen() {
		Klus[][][] klussen = null;
		klussen = planning;
		return klussen;
	}
	
	/**
	 * Deze methode voegt een klus aan de planning toe
	 * 
	 * @param k de toe te voegen klus
	 */
	public void addKlus(Klus k) {
		boolean succes = false;
		while(!succes) {
			for(int i = 1; i<7; i++) { //als het klusslot op de eerstvolgende werkdag(kan zelfde dag zijn)
				//leeg is, en het is geen zondag, en de klus staat niet al ingepland. dan pas wordt de klus toegevoegd
				if((planning[i-1][weekdag-1][weeknr-1] == null) && (weekdag>1 && weekdag<7 ) &&(!succes)) {
					planning[i-1][weekdag-1][weeknr-1] = k;
					succes = true;
				}
			}
			if(!succes) {
				if(weeknr == 52 && weekdag == 6) {
					weeknr = 1;
					weekdag = 2;
				} else if(weekdag < 6) {
						weekdag++;
				} else if (weekdag == 6) {
						weeknr++;
						weekdag = 2;
				}
			}
		}
	}
	
	/**
	 *  Deze methode laat de klussen op één dag zien
	 * 
	 * @param dag de dag waarvan de klussen opgevraagd worden
	 * @return de klussen die op die dag ingepland staan
	 */
	public String getKlussenOpDag(int dag) { //dag 1-7
		String result = "";
		for (int i = 0; i<6; i++) {
			if(planning[i][dag-1][weeknr] == null) {				
			}
		}
		return result;
	}
}