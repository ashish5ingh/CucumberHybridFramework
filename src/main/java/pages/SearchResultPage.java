package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultPage {

    WebDriver driver;
    private ElementUtils eu;
	
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eu = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
    private WebElement noProductMessage;
	
	public boolean displayStatusOfValidProduct() {
		
		return eu.displayStatusOfElement(validHPProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getNoProductMessage() {
		
		return eu.getTextFromElement(noProductMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 
	}
}
