package testPackage;

import static org.junit.Assert.*;

import org.junit.Test;

import domein.klantenbinding.*;
import domein.voorraadbeheer.Voorraad;

public class BedrijfTest {

	Bedrijf atd = new Bedrijf("atd");
	Klant one = new Klant(null, null, null, "something@something.com", null,
			null);
	Klant two = new Klant("something", null, null, "something1@something.com",
			null, null);

	@Test
	public void testVoegKlantToe() {
		atd.voegKlantToe(one);
		assertTrue(atd.heeftKlant("something@something.com"));
	}

	@Test
	public void testZoekKlant() {
		atd.voegKlantToe(one);
		assertEquals(one, atd.zoekKlant("something@something.com"));
	}

	@Test
	public void testVerwijderKlant() {
		atd.voegKlantToe(two);
		assertTrue(atd.verwijderKlant(two));
	}

	@Test
	public void testAantalKlanten() {
		atd.voegKlantToe(one);
		atd.voegKlantToe(two);
		assertEquals(2, atd.aantalKlanten());
	}

	@Test
	public void testSetNaam() {
		atd.setNaam("herpderp");
		assertEquals("herpderp", atd.getNaam());
	}

	@Test
	public void testSetDeVoorraad() {
		Voorraad v = new Voorraad();
		atd.setDeVoorraad(v);
		assertEquals(v, atd.getDeVoorraad());
	}

}