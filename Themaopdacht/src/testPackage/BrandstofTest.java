package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.voorraadbeheer.Brandstof;

public class BrandstofTest {
	Brandstof b = new Brandstof("diesel", 5, 1.5, 8);
	
	@Test
	public void testSetBrandstofType() {
		b.setBrandstofType("benzine");
		assertEquals("benzine", b.getBrandstofType());
	}

	@Test
	public void testSetLiters(){
		b.setLiter(10);
		assertEquals(10, b.getLiter(), 1e-15);
	}
	
	@Test
	public void testSetTsic(){
		b.setTsic(19);
		assertEquals(19, b.getTsic());
	}
	
	@Test
	public void testSetPrijsPerLiter(){
		b.setPrijsPerLiter(99.8);
		assertEquals(99.8, b.getPrijsPerLiter(), 1e-15);
	}
}
