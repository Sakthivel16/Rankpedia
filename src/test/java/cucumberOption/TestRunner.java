package cucumberOption;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
	 @CucumberOptions(features="src/test/java/FeatureFile",glue={"stepsDefinitions"},
	 tags= {"@smoke"},
//	 monochrome=true, 
	 plugin = { "pretty", "html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" })
	 
//	 plugin = {"pretty","html:target/HtmlReports","json:target/JSONReports/report.json",
//	 "junit:target/JUnitReports/reports.xml"})	
    
   	
public class TestRunner {

private TestNGCucumberRunner run;
	
	@BeforeClass(alwaysRun = true)
	public void setupclass()
	{
		//create a object for testng cucumberrunner in setupclass
		run = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Run cucumber features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper wrap)
	{
		//use run method and wrapper interface to get features files.
		run.runCucumber(wrap.getCucumberFeature());
	}
	
	
	@DataProvider
	public Object [][] features()
	{
		return run.provideFeatures();
	}
	
	
	@AfterClass
	public void teatdownclass()
	{
		run.finish();
	}

}
