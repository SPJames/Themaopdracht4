package testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import domein.klusbeheer.Klus;
import domein.klusbeheer.Weekplanning;

public class WeekplanningTest {
	Calendar cal = Calendar.getInstance();
	Weekplanning w = new Weekplanning();
	Klus k = new Klus(null, "a", "b", 1);
	
	@Test
	public void testGetWeekNr() {
		assertEquals(cal.get(Calendar.WEEK_OF_YEAR), w.getWeekNr());
	}
	
	@Test
	public void testGetKlussen() {
		for(int i=0; i<52; i++) {
			for(int j=0; j<7; j++) {
				for(int l=0; l<6; l++) {
					assertEquals(null, w.getKlussen()[l][j][i]);
				}
			}
		}
	}
	
	@Test
	public void testGetKlus() {
		Klus kl = null;
		assertEquals(kl, w.getKlus(kl));
	}
	
	@Test
	public void testAddKlus() {
		w.addKlus(k);
		assertEquals(k, w.getKlus(k));
	}
}