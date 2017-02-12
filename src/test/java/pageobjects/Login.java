package test.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class Login extends BaseObjects{
	
	//'By' object used to verify locators
	By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginFormLocator = By.id("login");
	By successMessageLocator = By.cssSelector(".flash.success");
	By failureMessageLocator = By.cssSelector(".flash.error");

	
	public Login(WebDriver driver) {
		//Runs driver through BaseObjects 
		super(driver);
		//Determines baseURL and JUnit function to open site
		visit("/login");
		//Checks for 'true' response and displays in output
		assertTrue("The login form is not present",
				driver.findElement(loginFormLocator).isDisplayed());
	}
	
	public void with(String username, String password) {
		type(username, usernameLocator);
		type(password, passwordLocator);
		submit(loginFormLocator);
	}
	
	public Boolean successMessagePresent() {
		return isDisplayed(successMessageLocator);
	}
	
	public Boolean failureMessagePresent() {
		return isDisplayed(failureMessageLocator);
	}
}
