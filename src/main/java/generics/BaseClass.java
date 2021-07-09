package generics;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;
	
	public static WebDriver openBrowser() throws Exception {
		
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();	
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	        
		}
		
		else if(browserName == "firefox")
		{
			WebDriverManager.firefoxdriver().setup();
//			ChromeOptions options = new ChromeOptions();	
//			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		else
		{
			
		}
		return driver;
  }
}
