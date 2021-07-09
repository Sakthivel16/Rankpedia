package stepsDefinitions;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import generics.BaseClass;
import generics.Utilities;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pageObjects.ExistingLogin;
import pageObjects.NewLogin;
import static io.restassured.RestAssured.given;

public class NewRegistrationLogin extends BaseClass {

	public static NewLogin newlog;
	public static ExistingLogin login;
	public static String id;
	
//	@Then("Student Click on Signin button")
//	public void Student_Click_on_Signin_button() throws Exception {
	
	@Then("^Student Click on Signin button$")
	public void student_Click_on_Signin_button() throws Throwable {
		login = new ExistingLogin(driver);
		login.signInBtn();
		Thread.sleep(4000);
		login.successOtpOkBtn();
		
	}

//	@And("Student filled their details")
//	public void student_filled_their_details() {
	
	@Then("^Student filled their details$")
	public void student_filled_their_details() throws Throwable {
		 newlog = new NewLogin(driver);
		 
		 newlog.firstName("Sakthivel");
		 newlog.gender();
		 newlog.parentName("ParentName");
		 newlog.parentPhoneNumber("1234567890");
		 newlog.state();
		 newlog.city();
		 newlog.board();
		 newlog.enterSchoolName("ACS", driver);
		 newlog.ClassName();
	}

//	@And("Student clicks on Register button")
//	public void student_clicks_on_register_button() {
	
	@Then("^Student clicks on Register button$")
	public void student_clicks_on_Register_button() throws Throwable {
		 newlog = new NewLogin(driver);
		 
		 newlog.clickRegisterButton();
		 driver.close();
	}
//	@Given("^Admin trying to get all student ids$")
//    public void admin_trying_to_get_all_student_ids() throws Throwable {
//	 RestAssured.baseURI="https://3k06rt8n4h.execute-api.ap-south-1.amazonaws.com/local/api";
//	String student = given().log().all().queryParam("name", "Sakthivel").header("Content-Type", "application/json").
//	 when().log().all().get("/students/searchForStudent").then().log().all().statusCode(200).extract().asString();
//	
//	JsonPath js = new JsonPath(student);
//	 int size = js.getInt("students.size()");
//	 for(int i=0;i<size;i++)
//	    {
//	    	String studentID = js.getString("students["+i+"]._id");
//	    	System.out.println(studentID);
//	    	if(studentID.equalsIgnoreCase("Sakthivel"))
//	    	   {
//	    		    id = js.getString("students["+i+"]._id");
//	    		   System.out.println(id);
//	    		   break;
//	    	   }
//	    }
//    }
//
// @When("^Delete Student using by id$")
//    public void delete_student_using_by_id() throws Throwable {
//	 RestAssured.baseURI="https://3k06rt8n4h.execute-api.ap-south-1.amazonaws.com/local/api";
//	String deleteResponse= given().log().all().header("Content-Type", "application/json").body("{\"id\":\""+id+"\"}").when().log().all()
//	 .post("students/deleteStudent").then().log().all().statusCode(200).extract().asString();
//	 JsonPath js = new JsonPath(deleteResponse);
//	 String actual = js.getString("status");
//	 Assert.assertEquals(actual, "status");
//	
//    }
}
