package testPackage;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import domein.financien.Parkeren;
import domein.klantenbinding.*;
import domein.voorraadbeheer.*;
import domein.klusbeheer.*;

public class KlusTest {
	Auto a = new Auto("11-22-33", "honda", "1");
	Auto a2 = new Auto("22-33-44", "ford", "2");
	Onderdeel o = new Onderdeel(50, "bout", 0.50, 4);
	Brandstof b = new Brandstof("diesel", 50, 1.23, 5);
	Klus s = new Klus(a,"uitlaat = broken", "rep", 1);
	
	@Test
	public void testAddOnderdeel(){
		s.addOnderdeel(o, 12);
		HashMap<Onderdeel, Integer> test = new HashMap<Onderdeel, Integer>();
		test.put(o, 12);
		assertEquals(test, s.getGebruikteOnderdelen());
	}
	
	@Test
	public void testSetKlusnummer(){
		s.setKlusNummer(2);
		assertEquals(2, s.getKlusNummer());
	}
	
	@Test
	public void testSetBeschrijving(){
		s.setBeschrijving("uitlaat is kapot");
		assertEquals("uitlaat is kapot", s.getBeschrijving());
	}
	
	@Test
	public void testSetHetType(){
		s.setHetType("Parkeren");
		Parkeren p = new Parkeren();
		assertEquals(p, s.getHetType());
	}
	
	@Test
	public void testSetWerknemer(){
		s.setWerknemer("henk");
		assertEquals("henk", s.getWerknemer());
	}
	
	@Test
	public void testSetParkeerplaats(){
		s.setParkeerplaats(2);
		assertEquals(2, s.getParkeerplaats());
	}
	
	@Test
	public void testSetAuto(){
		s.setAuto(a2);
		assertEquals(a2, s.getAuto());
	}
	
	@Test
	public void testSetKlusAfgerond(){
		s.setKlusafgerond(true);
		assertTrue(s.isKlusafgerond());
	}
	
	@Test
	public void testSetKlantID(){
		s.setKlantID(3);
		assertEquals(3, s.getKlantID());
	}
	
	@Test 
	public void testAddBrandstof(){
		s.addBrandstof(b, 12.0);
		HashMap<Brandstof, Double> test = new HashMap<Brandstof, Double>();
		test.put(b, 12.0);
		assertEquals(test, s.getGebruikteBrandstof());
	}
	
	@Test
	public void testAddManUren(){
		s.addManuren(30);
		assertEquals(30, s.getManuren());
	}
	
}
