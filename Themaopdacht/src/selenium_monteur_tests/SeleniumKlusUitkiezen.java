package selenium_monteur_tests;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumKlusUitkiezen {
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
	public void testSeleniumKlusUitkiezen() throws Exception {
		driver.get(baseUrl + "/atd/inloggen.jsp");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Klaas");
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys("monteur1");
		driver.findElement(By.name("Go")).click();
		driver.findElement(By.linkText("Klussen Lijst")).click();
		driver.findElement(By.linkText("uitkiezen")).click();

		driver.findElement(By.linkText("edit")).click();
		driver.findElement(By.name("comments")).clear();
		driver.findElement(By.name("comments")).sendKeys(
				"auto heeft nieuwe wieldoppen gekregen");
		driver.findElement(By.name("aantal0")).clear();
		driver.findElement(By.name("aantal0")).sendKeys("4");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}

//	@Test
//	public void testSeleniumKlusAanpassen() throws Exception {
//		driver.get(baseUrl + "/atd/monteur/KlusUitkiezenServlet?id=1");
//		driver.findElement(By.linkText("edit")).click();
//		driver.findElement(By.name("comments")).clear();
//		driver.findElement(By.name("comments")).sendKeys(
//				"auto heeft nieuwe wieldoppen gekregen");
//		driver.findElement(By.name("aantal0")).clear();
//		driver.findElement(By.name("aantal0")).sendKeys("4");
//		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
//	}

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
