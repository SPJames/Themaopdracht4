package selenium_tests_Start;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import selenium_admin_tests.AlleTestsAdmin;
import selenium_klant_tests.AlleTests;
import selenium_monteur_tests.AlleTestsMonteur;

@RunWith(Suite.class)
@SuiteClasses({ AlleTests.class, AlleTestsMonteur.class, AlleTestsAdmin.class })
public class AlleTests_start {

}
