package test.java.tests;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import test.java.pageobjects.DynamicLoading;

public class TestDynamicLoading extends BaseTests{

	private DynamicLoading dynamicLoading;

	@Before
	public void setUp() {
		dynamicLoading = new DynamicLoading(driver);
	}

	@Test
	public void hiddenElementLoads() {
		dynamicLoading.loadExample("1");
		assertTrue("finish text didn't display after loading",
				dynamicLoading.finishTextPresent());
	}
	
	@Test
	public void elementAppears() {
		dynamicLoading.loadExample("2");
		assertTrue("finish text didn't render after loading",
				dynamicLoading.finishTextPresent());
	}
}
