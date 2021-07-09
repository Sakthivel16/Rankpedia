package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExistingLogin {
	
//	WebDriver driver;
	public ExistingLogin(WebDriver driver) 
	{
//		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public static String otp;

	@FindBy(xpath = "//input[@placeholder='+91 - 9876512345']")
	private WebElement mobNumTextField;
	
	@FindBy(xpath = "//*[@id=\"__next\"]/div[4]/div/div/div/div[2]/div/div[3]/a")
	private WebElement ProceedBtn;
	
	
	@FindBy(xpath = "//div[@class='swal-text']")
	private WebElement OTP_Popup;
	
	@FindBy (css= ".swal-button.swal-button--confirm")
	private WebElement OtpPopupOkBtn;
	
	@FindBy(css = "div[class='logain-btn'] a")
	private WebElement signInBtn;
	
	@FindBy(css = ".swal-button.swal-button--confirm")
	private WebElement successOtpPopup;
	
	
	public void enterMobileNumber(String number) 
	{
		mobNumTextField.sendKeys(number);
	}
	
	
	public void clickProceedBtn() 
	{
		ProceedBtn.click();
	}
	
	public void clickOtpOkBtn() 
	{
		OtpPopupOkBtn.click();
	}
	
	public void fetchOtp() 
	{
		otp = OTP_Popup.getText();
		
	}
	
	public void enterOtp(WebDriver driver)
	{
        char[] num = otp.toCharArray();
		
		driver.findElement(By.xpath("//input[@aria-label='Please enter verification code. Digit 1']")).sendKeys(String.valueOf(num[6]));
		driver.findElement(By.xpath("//input[@aria-label='Digit 2']")).sendKeys(String.valueOf(num[7]));
		driver.findElement(By.xpath("//input[@aria-label='Digit 3']")).sendKeys(String.valueOf(num[8]));
		driver.findElement(By.xpath("//input[@aria-label='Digit 4']")).sendKeys(String.valueOf(num[9]));
		driver.findElement(By.xpath("//input[@aria-label='Digit 5']")).sendKeys(String.valueOf(num[10]));
		driver.findElement(By.xpath("//input[@aria-label='Digit 6']")).sendKeys(String.valueOf(num[11]));
	}
	
	public void signInBtn() 
	{
		signInBtn.click();
	}
	
	public void successOtpOkBtn() 
	{
		successOtpPopup.click();
	}
}
