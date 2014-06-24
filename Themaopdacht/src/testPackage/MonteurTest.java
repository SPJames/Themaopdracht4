package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.klusbeheer.Monteur;

public class MonteurTest {
	Monteur m = new Monteur("jan", "pass", 3);
	
	@Test
	public void testGetId() {
		assertEquals(2, m.getId());
	}
	
	@Test
	public void testSetPassword(){
		m.setPassword("change");
		assertEquals("change", m.getPassword());
	}
	
	@Test
	public void testSetNaam(){
		m.setNaam("pieter");
		assertEquals("pieter", m.getNaam());
	}

}
