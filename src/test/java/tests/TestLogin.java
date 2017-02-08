package test.java.tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import test.java.pageobjects.Login;

public class TestLogin extends Base{

	private Login login;

	@Before
	public void setUp() {
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
}

