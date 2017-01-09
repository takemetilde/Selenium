package test.java.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.*;
import test.java.pageobjects.Login;

public class TestLogin {

	private WebDriver driver;
	private Login login;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\hongiaher\\Desktop\\Eclipse Workspace\\Selenium\\geckodriver.exe");
		//DesiredCapabilities cap = DesiredCapabilities.firefox();
		//cap.setCapability("marionette", true);		
		driver = new FirefoxDriver();
		login = new Login(driver);
	}

	@Test
	public void succeeded() {
		login.with("tomsmith", "SuperSecretPassword!");
		assertTrue("success message not present", login.successMessagePresent());
	}
	
	@Test
	public void failed() {
		login.with("tomsmith", "bad password");
		assertTrue("failure message wasn't present after providing bogus credentials", 
				login.failureMessagePresent());
	}

	@After
	public void tearDown() {
						driver.quit();
		}
}

