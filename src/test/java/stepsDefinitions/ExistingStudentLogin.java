package stepsDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import generics.BaseClass;

import pageObjects.ExistingLogin;

public class ExistingStudentLogin extends BaseClass 
{
	public static ExistingLogin login;
	

//		@Given("Student enter {string} mobile number")
//		public void student_enter_mobile_number(String number) throws Exception {
	
	@Given("^Student enter \"([^\"]*)\" mobile number$")
	public void student_enter_mobile_number(String number) throws Throwable {
			
			
			login = new ExistingLogin(driver);
			login.enterMobileNumber(number);
			login.clickProceedBtn();
			Thread.sleep(4000);
		}


//	@When("Student enter OTP")
//	public void student_enter_otp() {
	@When("^Student enter OTP$")
	public void student_enter_OTP() throws Throwable {
		login = new ExistingLogin(driver);
		login.fetchOtp();
		login.clickOtpOkBtn();
		login.enterOtp(driver);


	}

//	@And("Student successfully navigate into Dashboard")
//	public void student_successfully_navigate_into_dashboard() throws Exception {
	
	@And("^Student successfully navigate into Dashboard$")
	public void student_successfully_navigate_into_Dashboard() throws Throwable {
		login = new ExistingLogin(driver);
		login.signInBtn();
		Thread.sleep(4000);
		login.successOtpOkBtn();
		driver.close();
	}
}
