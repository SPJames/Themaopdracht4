package testPackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BedrijfTest.class, KlantTest.class, AutoTest.class, BestellingTest.class, KlusTest.class, MonteurTest.class, ParkeerplaatsTest.class })
public class AllTests {

}