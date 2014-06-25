package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.financien.Factuur;
import domein.klantenbinding.Auto;
import domein.klusbeheer.Klus;

public class FactuurTest {
	Auto u = new Auto("11-ee-32", "bmw", "10");
	Klus k = new Klus(u, "reparatie", "rep", 0);
	Factuur f = new Factuur(k, 1);
	
	
	@Test
	public void testSetManurenPrijs() {
		f.setManurenprijs(k);
		assertEquals(",00", f.getManurenprijs());
		
	}
	
	@Test
	public void testSetOnderdelenprijs(){
		f.setOnderdelenprijs(k);
		assertEquals("", f.getOnderdelenprijs());
	}
	
	@Test
	public void testSetBrandstofprijs(){
		f.setBrandstofprijs(k);
		assertEquals("", f.getBrandstofprijs());
	}
	
	@Test
	public void testSetTotaalprijs(){
		f.setTotaalprijs(k);
		assertEquals(",00", f.getTotaalprijs());
	}
	
	@Test
	public void testSetFactuurNummer(){
		f.setFactuurNummer(5);
		assertEquals(5, f.getFactuurNummer());
	}
	
	@Test
	public void testSetKlus(){
		Auto l = new Auto("11-xx-32", "audi", "11");
		Klus x = new Klus(l, "parkeren voor 2 dagen", "park", 1);
		f.setKlus(x);
		assertEquals(x, f.getKlus());
	}
	
	@Test
	public void testSetKorting(){
		f.setKorting(70);
		assertEquals(70, f.getKorting(),1e-15);
	}
	
	
}
