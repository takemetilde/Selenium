package test.java.tests;

import java.io.File;

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
			//Auto-finds firefox geckodriver
			File f = new File("./geckodriver.exe");
			String path = f.getAbsolutePath().replace("\\", "\\\\");
			
			System.setProperty("webdriver.gecko.driver",
					path);
			driver = new FirefoxDriver();
		}

		//Teardown method: load after testing method
		@Override
		protected void after() {
			driver.quit();
		}
	};
}
