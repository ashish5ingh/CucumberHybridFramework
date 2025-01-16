package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	private ElementUtils eu;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eu = new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		
		eu.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterPassword(String pwdText) {
		
		eu.typeTextIntoElement(passwordField, pwdText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public AccountPage clickLoginBtn() {
		eu.clickOnElement(loginBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}
	
	public String getWarningMessageText() {
		
		return eu.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
