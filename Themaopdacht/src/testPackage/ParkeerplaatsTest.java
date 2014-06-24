package testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;

import domein.klusbeheer.Parkeerplaats;

import org.junit.Test;

import domein.klantenbinding.Auto;

public class ParkeerplaatsTest {
	Auto u = new Auto("12-zx-56", "honda", "1");
	Auto u2 = new Auto("34-xz-65", "ford", "4");
	Parkeerplaats p = new Parkeerplaats(u);
	private Calendar cal = Calendar.getInstance();
	
	@Test
	public void testSetAuto() {
		p.setAuto(u2);
		assertEquals(u2, p.getAuto());
	}
	
	@Test
	public void testSetReserveringsDatum(){
		p.setReseveringsDatum(cal);
		assertEquals("22/06/2014", p.getReseveringsDatum());
	}

}
