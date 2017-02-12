package test.java.tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import test.java.pageobjects.Login;

public class TestLogin extends BaseTests{

	private Login login;

	//Setup method: load before testing method
	@Before
	public void setUp() {
		//Instantiate Login object with driver from BaseTests
		login = new Login(driver);
	}

	//Testing method
	@Test
	public void succeeded() {
		//Calls "with" method using username and password
		login.with("tomsmith", "SuperSecretPassword!");
		assertTrue("success message not present", login.successMessagePresent());
	}
	
	//Testing method
	@Test
	public void failed() {
		login.with("tomsmith", "bad password");
		assertTrue("failure message wasn't present after providing bogus credentials", 
				login.failureMessagePresent());
	}
}

