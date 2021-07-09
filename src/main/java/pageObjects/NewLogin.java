package pageObjects;

import java.awt.event.ActionEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generics.Utilities;

public class NewLogin {

//	WebDriver driver;
	public NewLogin(WebDriver driver) 
	{
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Select sel;

	@FindBy(css = "#fullName")
	private WebElement firstName;

	@FindBy(xpath = "//select[@id='gender']")
	private WebElement gender;

	@FindBy(xpath = "//input[@id='parentName']")
	private WebElement parentName;

	@FindBy(xpath = "//input[@id='phoneNumber']")
	private WebElement parentNumber;

	@FindBy(xpath = "//select[@id='state']")
	private WebElement state;

	@FindBy(xpath = "//select[@id='city']")
	private WebElement city;

	@FindBy(xpath = "//select[@id='syllabus']")
	private WebElement board;
	
	@FindBy(xpath = "//div[text()='KV Public School']")
	private WebElement schoolName;

	@FindBy(xpath = "//select[@id='classGrade']")
	private WebElement Class;

	@FindBy(css = "button[type='submit']")
	private WebElement registerBtn;



	public void firstName(String name) 
	{

		firstName.sendKeys(name);
	}

	public void gender()
	{

		sel = new Select(gender);
		sel.selectByVisibleText("Male");
	}

	public void parentName(String name) 
	{

		parentName.sendKeys(name);
	}

	public void parentPhoneNumber(String number) 
	{

		parentNumber.sendKeys(number);
	}

	public void state() {

		sel = new Select(state);
		sel.selectByIndex(3);
	}

	public void city() 
	{

		sel = new Select(city);
		sel.selectByIndex(2);
	}

	public void board() {

		sel = new Select(board);
		sel.selectByIndex(1);
		
	}
	
	public void enterSchoolName(String schoolname, WebDriver driver) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		
//		WebElement schoolName = driver.findElement(By.xpath("//div[text()='KV Public School']"));
//		schoolName.sendKeys(schoolname);
//		WebElement mySchool = driver.findElement(By.xpath("//div[text()='ACS School']"));
//		mySchool.sendKeys(Keys.ARROW_DOWN);
//		mySchool.sendKeys(Keys.ENTER);
		
		 Utilities.ExplicitWait(driver, "//div[text()='KV Public School']");
		schoolName.sendKeys(schoolname);
		schoolName.sendKeys(Keys.ARROW_DOWN);
		schoolName.sendKeys(Keys.ENTER);
	}

	public void ClassName() 
	{

		sel = new Select(Class);
		sel.selectByIndex(1);
	}

	public void clickRegisterButton() 
	{

		registerBtn.click();
	}

}
