package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.financien.Onderhoud;
import domein.voorraadbeheer.Onderdeel;

public class OnderhoudTest {
	Onderhoud o = new Onderhoud();
	Onderdeel u = new Onderdeel(10, "moer", 0.12, 10);
	@Test
	public void testTotaalManuurPrijs() {
		o.setManUren(10);
		o.setPrijsPerManuur(30);
		assertEquals(300, o.totaalManuurPrijs(), 1e-15);
	}

	@Test
	public void testSetManuren(){
		o.setManUren(11.1);
		assertEquals(11.1, o.getManUren(), 1e-15);
	}
	
	@Test
	public void testSetPrijsPerManuur(){
		o.setPrijsPerManuur(14.90);
		assertEquals(14.90, o.getPrijsPerManuur(), 1e-15);
	}
	
	@Test
	public void testSetDeOnderdelen(){
		o.setDeOnderdelen(u);
		assertEquals(u, o.getDeOnderdelen());
	}
	
	@Test
	public void testDienstprijs(){
		o.setDeOnderdelen(u);
		o.setPrijsPerManuur(14.90);
		o.setManUren(10);
		assertEquals(150.20, o.dienstPrijs(), 1e-15);
	}
	
	@Test
	public void testDientsType(){
		String s = o.dienstType();
		assertEquals("Onderhoud", s);
	}
}

