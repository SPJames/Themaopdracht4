package testPackage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import domein.klusbeheer.Parkeerplaats;

import org.junit.Test;

import domein.klantenbinding.Auto;

public class ParkeerplaatsTest {
	Auto u = new Auto("12-zx-56", "honda", "1");
	Auto u2 = new Auto("34-xz-65", "ford", "4");
	Parkeerplaats p = new Parkeerplaats(u);
	private Calendar cal = Calendar.getInstance();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	@Test
	public void testSetAuto() {
		p.setAuto(u2);
		assertEquals(u2, p.getAuto());
	}
	
	@Test
	public void testSetReserveringsDatum(){
		String s = df.format(cal.getTime());
		p.setReseveringsDatum(cal);
		assertEquals(s, p.getReseveringsDatum());
	}

}
