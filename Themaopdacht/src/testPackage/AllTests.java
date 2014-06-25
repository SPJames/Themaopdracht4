package testPackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ KlantTest.class, AutoTest.class, KlusTest.class,
		MonteurTest.class, ParkeerplaatsTest.class, FactuurTest.class,
		OnderhoudTest.class, ParkerenTest.class, TankenTest.class,
		OnderdeelTest.class, BrandstofTest.class })
public class AllTests {

}