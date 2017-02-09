package test.java.tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTests {

	protected WebDriver driver;

	//Do not quite understand purpose or functionality yet
	@Rule
	public ExternalResource resource = new ExternalResource() {
		
		@Override
		protected void before() throws Throwable {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\hongiaher\\Desktop\\Eclipse Workspace\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		//Teardown method: load after testing method
		@Override
		protected void after() {
			driver.quit();
		}
	};
}
