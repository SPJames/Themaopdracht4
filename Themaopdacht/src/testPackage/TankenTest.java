package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.financien.Tanken;
import domein.voorraadbeheer.Brandstof;

public class TankenTest {
	Tanken t = new Tanken();
	Brandstof b = new Brandstof("diesel", 12.0, 1.15, 10);
	
	@Test
	public void testSetGebruikteLiter() {
		t.setGebruikteLiter(10);
		assertEquals(10, t.getGebruikteLiter(), 1e-15);
	}
	
	@Test
	public void testSetDeBrandstof(){
		t.setDeBrandstof(b);
		assertEquals(b, t.getDeBrandstof());
	}
	
	@Test
	public void testDienstPrijs(){
		t.setDeBrandstof(b);
		t.setGebruikteLiter(10);
		assertEquals(11.50, t.dienstPrijs(),1e-15);
	}
	
	@Test
	public void testDienstType(){
		String s = t.dienstType();
		assertEquals("Tanken", s);
	}
}
