package selenium_admin_tests;

import static org.junit.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VoorraadOnderdeelToevoegen {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testVoorraadOnderdeelToevoegen() throws Exception {
		driver.get(baseUrl + "/atd/index.jsp");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys("Admin");
		driver.findElement(By.name("Go")).click();
		driver.findElement(By.linkText("Voorraad Overzicht")).click();
		driver.findElement(By.linkText("Nieuw Onderdeel Toevoegen")).click();
		driver.findElement(By.name("aantal")).clear();
		driver.findElement(By.name("aantal")).sendKeys("3");
		driver.findElement(By.name("artikelnaam")).clear();
		driver.findElement(By.name("artikelnaam")).sendKeys("wieldop");
		driver.findElement(By.name("PrijsArtikel")).clear();
		driver.findElement(By.name("PrijsArtikel")).sendKeys("4.5");
		driver.findElement(By.cssSelector("input.down")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
