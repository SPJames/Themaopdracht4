package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;
import domein.voorraadbeheer.*;

public class BestellingTest {
	Bestelling b = new Bestelling("", 1);
	
	@Test
	public void testSetLeveringsDatum(){
		b.setLeveringsDatum("22/06/2014");
		assertEquals("22/06/2014", b.getLeveringsDatum());
	}
	
	@Test
	public void testSetBestellingsNr(){
		b.setBestellingsNr(3);
		assertEquals(3, b.getBestellingsNr());
	}
	
	
}
