package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.voorraadbeheer.Onderdeel;

public class OnderdeelTest {
	Onderdeel o = new Onderdeel(10, "moer", 0.08, 7);
	
	@Test
	public void testSetArtikelNr() {
		o.setArtikelNr(8);
		assertEquals(8, o.getArtikelNr());
	}
	
	@Test
	public void testSetAantal(){
		o.setAantal(90);
		assertEquals(90, o.getAantal());
	}
	
	@Test
	public void testSetNaam(){
		o.setNaam("bout");
		assertEquals("bout", o.getNaam());
	}
	
	@Test
	public void testSetPrijsArtikel(){
		o.setPrijsArtikel(0.10);
		assertEquals(0.10, o.getPrijsArtikel(),1e-15);
	}
	
	@Test
	public void testTotaalPrijsOnderdeel(){
		o.setPrijsArtikel(0.10);
		o.setAantal(100);
		assertEquals(10, o.totaalPrijsOnderdeel(),1e-15);
	}

}
