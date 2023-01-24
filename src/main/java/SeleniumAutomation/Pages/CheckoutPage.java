package SeleniumAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	 @FindBy(css="#first-name")   WebElement firstNameField;
	 @FindBy(css="#last-name")   WebElement lastNameField;
	 @FindBy(css="#postal-code")   WebElement postalCodeield;
	 @FindBy(css="#continue")   WebElement btnContinue;
	 
	 public void enterFirstName(String fname) {
		 firstNameField.sendKeys(fname);
	 }
	 
	 public void enterLastName(String lname) {
		 lastNameField.sendKeys(lname);
	 }
	 
	 public void enterPostalCode(String post) {
		 postalCodeield.sendKeys(post);
	 }
	 
	 public OverviewPage gotPurchaseOverview() {
		 btnContinue.click();
		 return new OverviewPage(driver);
	 }


}
