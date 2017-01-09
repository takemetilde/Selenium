package test.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class Login extends Base{
	
	private WebDriver driver;
	
	By usernameLocator = By.id("username");
	By passwordLocator = By.id("password");
	By loginFormLocator = By.id("login");
	By successMessageLocator = By.cssSelector(".flash.success");
	By failureMessageLocator = By.cssSelector(".flash.error");

	public Login(WebDriver driver) {
		super(driver);
		driver.get("http://the-internet.herokuapp.com/login");
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
