package Klusbeheer;

import java.util.ArrayList;

public class Planner {
	private ArrayList<Weekplanning> alleWeekplanningen = new ArrayList<Weekplanning>();

	public Planner() {

	}

	public boolean heefPlanning(int wn) {
		boolean result = false;
		if (zoekPlanning(wn) != null) {
			result = true;
		}
		return result;
	}

	public Weekplanning zoekPlanning(int wn) {
		Weekplanning result = null;
		for (Weekplanning w : alleWeekplanningen) {
			if (w.getWeeknummer() == wn) {
				result = w;
			}
		}
		return result;
	}

	public boolean voegPlanningToe(Weekplanning nwP) {
		alleWeekplanningen.add(nwP);
		return true;
	}

}
