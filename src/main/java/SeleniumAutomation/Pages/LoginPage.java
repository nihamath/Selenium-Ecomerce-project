package SeleniumAutomation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumAutomation.Utils.WaitHelper;

public class LoginPage {
	
	WebDriver driver;
	WaitHelper waits;
	public LoginPage(WebDriver driver){
		
		waits = new WaitHelper(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 @FindBy(name="user-name")   WebElement userName;
	 @FindBy(name="password")   WebElement passowrd;
	 @FindBy(name="login-button")   WebElement loginButton;
	 @FindBy(xpath="//h3[@data-test='error']")   WebElement errorMessage;
	 
	 public ProductPage loginToApplication(String username, String password) {
		 userName.sendKeys(username);
		 passowrd.sendKeys(password);
		 loginButton.click();
		 return new ProductPage(driver);
	 }
	 
	 public String getErrorMessage() {
		 waits.waitFroElementToVisible(errorMessage);
		 return errorMessage.getText();
	 }

}
