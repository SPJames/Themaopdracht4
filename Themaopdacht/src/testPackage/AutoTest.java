package testPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domein.klantenbinding.Auto;

@SuppressWarnings("deprecation")
public class AutoTest {
	/**
	 * @author Cindy Jong
	 */
	private Auto a1;

	/**
	 * In deze methode wordt een zware operatie voorbereid, zoals het openen van
	 * een database connectie.
	 * 
	 * @see #initialize()
	 */
	@BeforeClass
	public static void initializeClass() {
		// geen operaties nodig
	}

	/**
	 * In deze methode wordt een leeg (null) auto object aangemaak waarop deze
	 * tescase zijn tests kan uitvoeren.
	 * 
	 * @see #initializatieClass()
	 */

	@Before
	public void initialize() {
		a1 = new Auto(null, null, null);
	}

	/**
	 * In deze methode wordt het kenteken attribuut van een object (van klasse
	 * Auto) gechecked op NULL waarden, setters en getters.
	 * 
	 * @deprecated maakt gebruikt van de assert (warnings worden ge supressed).
	 */
	@Test
	public void testKentekenAttribuut() {
		Assert.assertNull(a1.getKenteken());
		// nu gaan we een waarde meegeven
		a1.setKenteken("AB-03-NL");
		// nu gaan we testen of het systeem functioneerd met een normale waarde
		Assert.assertNotNull(a1.getKenteken());
		Assert.assertEquals("AB-03-NL", a1.getKenteken());
		// nu gaan we testen of het systeem een fout genereerd als de waarden
		// niet gelijk zijn
		Assert.assertNotSame("AP-03-NL", a1.getKenteken());
	}

	/**
	 * In deze methode wordt het Merk attribuut van een object (van klasse Auto)
	 * gechecked op NULL waarden, setters en getters.
	 * 
	 * @deprecated maakt gebruikt van de assert (warnings worden ge supressed).
	 */

	@Test
	public void testMerkAtribuut() {
		Assert.assertNull(a1.getMerk());
		// nu gaan we een waarde toewijzen
		a1.setMerk("Audi");
		// nu gaan we testen of het systeem functioneerd met een normale waarde
		Assert.assertNotNull(a1.getMerk());
		Assert.assertEquals("Audi", a1.getMerk());
		// nu gaan we testen of het systeem een fout genereerd als de waardes
		// niet gelijk zijn
		Assert.assertNotSame("Adi", a1.getMerk());
	}

	@Test
	public void testKlantid() {
		Assert.assertNull(a1.getKlantid());
		// nu gaan we een waarde toewijzen
		a1.setKlantid("4");
		// nu gaan we testen of het systeem functioneerd met een normale waarde
		Assert.assertNotNull(a1.getKlantid());
		Assert.assertEquals("4", a1.getKlantid());
		// nu gaan we testen of het systeem een fout genereerd als de waardes
		// niet gelijk zijn
		Assert.assertNotSame("5", a1.getKlantid());
	}

	public void streamTest() throws IOException {

		FileOutputStream fos = new FileOutputStream("testfile.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// random data generator
		for (int i = 0; i < 100; i++) {
			Auto at = new Auto("12-test-2", "Toyota", "1");
			SecureRandom random = new SecureRandom();
			String key = new BigInteger(100, random).toString(32);
			at.setKenteken(key);
			oos.writeObject(at);

		}

		oos.close();
		fos.close();

	}

	/**
	 * In deze methode wordt de referentie naar het object verwijderd en wordt
	 * het object uiteindelijk vernietigd door de garbage collector
	 */

	@After
	public void deconstruct() {
		a1 = null; // verwijder de referentie naar het object - JAVA garbage
					// collecter vernietigd deze data
	}

}
