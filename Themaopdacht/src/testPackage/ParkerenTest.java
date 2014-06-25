package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import domein.financien.Parkeren;

public class ParkerenTest {
	Parkeren o = new Parkeren();
	@Test
	public void testSetAantalDagen() {
		o.setAantalDagen(10);
		assertEquals(10, o.getAantalDagen());
	}
	
	@Test
	public void testSetDagPrijs(){
		o.setDagPrijs(1.59);
		assertEquals(1.59, o.getDagPrijs(), 1e-15);
	}
	
	@Test
	public void testDienstPrijs(){
		o.setAantalDagen(10);
		o.setDagPrijs(1.59);
		double b = o.dienstPrijs();
		assertEquals(15.90, b, 1e-15);
	}
	
	@Test
	public void testDientsType(){
		String s = o.dienstType();
		assertEquals("Parkeren", s);
	}

}
