package selenium_klant_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RegistrerenKlant.class, AutoToevoegen.class,
		AccountWijzigen.class })
public class AlleTests {
	// ACCOUNT WIJZIGEN MAKEN DOET HET NOG NIET
}