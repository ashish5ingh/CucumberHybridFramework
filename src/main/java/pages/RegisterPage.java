package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	private ElementUtils eu;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		eu = new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=\"1\"]")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	public void enterFirstName(String firstName) {
		
		eu.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}
	
	public void enterLastName(String lastName) {
		
		eu.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterEmail(String email) {
		
		eu.typeTextIntoElement(emailField, email, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterPhoneNumber(String telephone) {
		
		eu.typeTextIntoElement(telephoneField, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterPassword(String password) {
		
		eu.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void enterConfirmPassword(String password) {
		
		eu.typeTextIntoElement(confirmPasswordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public void clickPrivacyPolicyCheckbox() {
		
		eu.clickOnElement(privacyPolicyCheckbox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public AccountSuccessPage clickContinueBtn() {
		
		eu.clickOnElement(continueBtn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void selectYesNewsletterOption() {
		
		eu.clickOnElement(yesNewsletterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String displayWarningMessage() {
		
		return eu.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		 
	}
	
	public String getPrivacyPolicyWarning() {
		
		return eu.getTextFromElement(privacyPolicyWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getFirstNameWarning() {
		
		return eu.getTextFromElement(firstNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getLastNameWarning() {
		
		return eu.getTextFromElement(lastNameWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getEmailWarning() {
		
		return eu.getTextFromElement(emailWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getTelephoneWarning() {
		
		return eu.getTextFromElement(telephoneWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public String getPasswordWarning() {
		
		return eu.getTextFromElement(passwordWarning, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
}
