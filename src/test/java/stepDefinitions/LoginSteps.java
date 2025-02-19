package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class LoginSteps {
	
	WebDriver driver;
	private LoginPage lp;
	private AccountPage ap;
	private CommonUtils cu;
	//private DriverFactory df;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		
		//df = new DriverFactory();
		//driver= df.getDriver();
		driver = new DriverFactory().getDriver(); //this step reduce code
		HomePage hp = new HomePage(driver);
	    hp.clickMyAccount();
	    lp = hp.clickLoginOption();
	}

	@When("User enters valid email address as {string} into email field")
	public void user_enters_valid_email_address_as_into_email_field(String valid_email) {
	    
		lp.enterEmailAddress(valid_email);
	}

	@When("User enters valid password as {string} into password field")
	public void user_enters_valid_password_as_into_password_field(String valid_password) {
		lp.enterPassword(valid_password);
	   
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		ap=lp.clickLoginBtn();
	    
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		
	    Assert.assertTrue(ap.displayStatusOfEditYourAccountInformationOption());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
	    cu = new CommonUtils();
		lp.enterEmailAddress(cu.getEmailWithTimeStamp());
		
	}

	@When("User enters invalid password as {string} into password field")
	public void user_enters_invalid_password_as_into_password_field(String invalid_password) {
		lp.enterPassword(invalid_password);
	
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	    Assert.assertTrue(lp.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		lp.enterEmailAddress("");
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		 lp.enterPassword("");
		
	}
	
	

}
