package domein.klusbeheer;

import java.util.Calendar;

/**
 * OUDE JDOCS! Needs update!
 * 
 * in deze klasse kunnen de gegevens van een weekplanning ingevuld/bewerkt worden
 * in deze klasse wordt ook de arraylists van klussen en monteurs bijgehouden/bewerkt
 */
public class Weekplanning {
	Calendar c = Calendar.getInstance();
	private int weekdag = c.get(Calendar.DAY_OF_WEEK);
	private int weeknr = c.get(Calendar.WEEK_OF_YEAR);
	
	private Klus[][][] planning = new Klus[6][7][52];
	
	public int getWeekNr() {
		return weeknr;
	}
	
	public Klus[][][] getKlussen() {
		Klus[][][] klussen = null;
		klussen = planning;
		return klussen;
	}
	
	public void addKlus(Klus k) {
		boolean succes = false;
		while(!succes) {
			for(int i = 1; i<7; i++) {
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
	
	public String getKlussenOpDag(int dag) { //dag 1-7
		String result = "";
		for (int i = 0; i<6; i++) {
			if(planning[i][dag-1][weeknr] == null) {
				
			}
		}
		return result;
	}
}
