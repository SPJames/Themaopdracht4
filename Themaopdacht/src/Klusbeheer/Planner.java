package Klusbeheer;

import java.util.ArrayList;

/**
 * in deze klasse worden alle weekplanningen bijgehouden
 */
public class Planner {
	private ArrayList<Weekplanning> alleWeekplanningen = new ArrayList<Weekplanning>();

	//de klasse wordt geinitialiseerd
	public Planner() {

	}

	/**
	 * deze methode kijkt mbv zoekplanning en een weeknummer of er een planning in de lijst
	 * alleWeekplanningen staat voor die week
	 * @param wn het weeknummer waarvoor we willen kijken of het een planning heeft
	 * @return een boolean die aangeeft of er een planning is of niet
	 */
	public boolean heefPlanning(int wn) {
		boolean result = false;
		if (zoekPlanning(wn) != null) {
			result = true;
		}
		return result;
	}

	/**
	 * deze methode zoekt een planning in de arraylist alleWeekplanningen
	 * er wordt gezocht op weeknummer
	 * @param wn het weeknummer waarop gezocht wordt
	 * @return de planning van die week als die er is, anders niks
	 */
	public Weekplanning zoekPlanning(int wn) {
		Weekplanning result = null;
		for (Weekplanning w : alleWeekplanningen) {
			if (w.getWeeknummer() == wn) {
				result = w;
			}
		}
		return result;
	}

	/**
	 * deze methode voegt een planning toe aan de arraylist alleWeekplanningen
	 * @param nwP de toe te voegen weekplanningen
	 * @return een boolean die aangeeft of het gelukt is om de planning toe te voegen
	 */
	public boolean voegPlanningToe(Weekplanning nwP) {
		alleWeekplanningen.add(nwP);
		return true;
	}

}
