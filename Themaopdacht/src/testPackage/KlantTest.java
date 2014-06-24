package testPackage;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import domein.klantenbinding.*;

public class KlantTest {
	Klant k = new Klant("henk","henklaan","1234rc","henk@henkness.com","henktheawesome","something", 4);
	Auto a = new Auto("ww-22-pp","honda","something");
	Auto a2 = new Auto("ww-23-pp","ford","henk");
	private Calendar nd = Calendar.getInstance();
	
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
	
	@Test
	public void testSetUsername(){
		Klant b = new Klant(null, null, null, null, null, null, 5);
		b.setUsername("henk");
		assertEquals("henk", b.getUsername());
	}
	
	@Test
	public void testSetPassword(){
		Klant b = new Klant(null, null, null, null, null, null, 6);
		b.setPassword("someplace");
		assertEquals("someplace", b.getPassword());
	}
	
	@Test
	public void testSetNaam(){
		Klant b = new Klant(null, null, null, null, null, null, 7);
		b.setNaam("sjaak");
		assertEquals("sjaak", b.getNaam());
	}
	
	@Test 
	public void testSetAdres(){
		Klant b = new Klant(null, null, null, null, null, null, 8);
		b.setAdres("nijenoord 1");
		assertEquals("nijenoord 1", b.getAdres());
	}
	
	@Test
	public void  testSetPostcode(){
		Klant b = new Klant(null, null, null, null, null, null, 9);
		b.setPostcode("1234sa");
		assertEquals("1234sa", b.getPostcode());
	}
	
	@Test
	public  void testSetEmail(){
		Klant b = new Klant(null, null, null, null, null, null, 10);
		b.setEmail("r.huydts@hotmail.com");
		assertEquals("r.huydts@hotmail.com",b.getEmail());;
	}
	
	@Test
	public void testSetLaatstBezocht(){
		Klant b = new Klant(null, null, null, null, null, null, 11);
		b.setLaatstBezocht(nd);
		assertEquals("22/06/2014", b.getLaatstBezocht());
		
	}
	
	
}
