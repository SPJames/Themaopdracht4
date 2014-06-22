package selenium_klant_tests;

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

public class AutoToevoegen {
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
	public void generateData() throws Exception {
		String username;
		String pwd;
		String merk;
		String kenteken;
		String comments;
		
		BufferedReader reader = null;

		try {
			File file = new File("../csv/autoToevoegen.csv");
			reader = new BufferedReader(new FileReader(file));

			String line;
			while ((line = reader.readLine()) != null) {
				@SuppressWarnings("resource")
				Scanner s = new Scanner(line);
				s.useDelimiter(";");
				while (s.hasNext()) {
					username = s.next();
					pwd = s.next();
					merk = s.next();
					kenteken = s.next();
					comments = s.next();
					testSeleniumAutoToevoegen(username, pwd, merk, kenteken, comments);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void testSeleniumAutoToevoegen(String username, String pwd,
			String merk, String kenteken, String comments) throws Exception {
		driver.get(baseUrl + "/atd/inloggen.jsp");
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.name("Go")).click();
		driver.findElement(By.linkText("Auto Overzicht")).click();
		driver.findElement(By.linkText("Voeg een auto toe")).click();
		driver.findElement(By.name("merk")).clear();
		driver.findElement(By.name("merk")).sendKeys(merk);
		driver.findElement(By.name("kenteken")).clear();
		driver.findElement(By.name("kenteken")).sendKeys(kenteken);
		driver.findElement(By.cssSelector("input.down")).click();

		driver.findElement(By.linkText("Afspraak Maken")).click();
		driver.findElement(By.name("comments")).clear();
		driver.findElement(By.name("comments")).sendKeys(comments);
		driver.findElement(By.cssSelector("input.down-afspraak")).click();
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
