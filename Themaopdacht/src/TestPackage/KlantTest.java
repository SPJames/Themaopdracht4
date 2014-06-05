package TestPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import klantenbinding.*;

public class KlantTest {
	Klant k = new Klant("henk","henklaan","1234rc","henk@henkness.com","henktheawesome","something");
	Auto a = new Auto("ww-22-pp","honda","something");
	Auto a2 = new Auto("ww-23-pp","ford","henk");
	
	@Test
	public void testVoegAutoToe(){
		k.voegAutoToe(a);
		assertTrue(k.heeftAuto(a.getKenteken()));
	}
	
	@Test
	public void testAantalAutos(){
		k.voegAutoToe(a);
		k.voegAutoToe(a2);
		
		assertEquals(2, k.aantalAutos());
	}
	
	@Test
	public void testZoekAuto(){
		k.voegAutoToe(a);
		k.voegAutoToe(a2);
		
		assertEquals(a, k.zoekAuto(a.getKenteken()));
	}
}
