package test.java.tests;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	protected WebDriver driver;

	@Rule
	public ExternalResource resource = new ExternalResource() {
		
		@Override
		protected void before() throws Throwable {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\hongiaher\\Desktop\\Eclipse Workspace\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		@Override
		protected void after() {
			driver.quit();
		}
	};
}
