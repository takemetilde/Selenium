package test.java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoading extends BaseObjects {

	By startButton = By.cssSelector("#start button");
	By finishText = By.id("finish");

	public DynamicLoading(WebDriver driver) {
		super(driver);

	}

	public void loadExample(String exampleNumber) {
		visit("/dynamic_loading/" + exampleNumber);
		click(startButton);

	}
	
	public Boolean finishTextPresent() {
		return waitForIsDisplayed(finishText, 10);
	}
}