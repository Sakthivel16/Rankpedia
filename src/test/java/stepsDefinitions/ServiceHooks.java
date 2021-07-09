package stepsDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import generics.BaseClass;
import generics.LoggerHelper;

public class ServiceHooks {
	
//	public static BaseClass base;
	
	Logger log= LoggerHelper.getLogger(ServiceHooks.class);

	@Before
	public void intializeBrowser() throws Exception
	{
//		base = new BaseClass();
		BaseClass.openBrowser();
	}
	
	@After
	public void endTest(Scenario scenario)  {
		if (scenario.isFailed()) {

			try {
				log.info(scenario.getName() + " is Failed");
				final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // ... and embed it in
			} catch (WebDriverException e) {
				e.printStackTrace();
			}

		} else {
			try {
				log.info(scenario.getName() + " is pass");
				scenario.embed(((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES), "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		BaseClass.driver.quit();

	}                                                    
}
