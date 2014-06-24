package testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

import domein.klusbeheer.Weekplanning;

public class WeekplanningTest {
	Calendar cal;
	Weekplanning w = new Weekplanning();
	
	@Test
	public void testGetWeekNr() {
		assertEquals(cal.get(Calendar.WEEK_OF_YEAR), w.getWeekNr());
	}

}
