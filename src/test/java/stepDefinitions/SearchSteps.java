package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchSteps {
	
	WebDriver driver;
	private HomePage hp;
	private SearchResultPage srp;
	//private DriverFactory df;

	@Given("User opens the application")
	public void user_opens_the_application() {
	    
		//df = new DriverFactory();
		//driver = df.getDriver();
		driver = new DriverFactory().getDriver(); //this step reduce code
	}

	@When("User enters valid product {string} into Search box field")
	public void user_enters_valid_product_into_search_box_field(String valid_product) {
	    
		 hp = new HomePage(driver);
		 hp.enterSearchText(valid_product);
		
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		
		srp=hp.clickSearchBtn();
	   
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		
		Assert.assertTrue(srp.displayStatusOfValidProduct());
	    
	}

	@When("User enters invalid product {string} into Search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalid_product) {
	    
		hp = new HomePage(driver);
		hp.enterSearchText(invalid_product);
		
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		Assert.assertEquals("There is no product that matches the search criteria.", srp.getNoProductMessage());
	   // Assert.fail();
	}

	@When("User dont enter any product name into Search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	    
		hp =new HomePage(driver);
		
	}
}
