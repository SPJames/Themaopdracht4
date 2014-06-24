package selenium_admin_tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ NieuweMonteurToevoegen.class, VoorraadBrandstofToevoegen.class,
		VoorraadOnderdeelToevoegen.class, VoorraadWijzigen.class,
		KlantOverzichtEmailSturen.class })
public class AlleTestsAdmin {

}
