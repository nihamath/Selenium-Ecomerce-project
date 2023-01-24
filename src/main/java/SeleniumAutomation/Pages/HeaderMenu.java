package SeleniumAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderMenu {
	WebDriver driver;
	
	public HeaderMenu(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	 @FindBy(xpath="//a[@class='shopping_cart_link']")   WebElement cartButton;
	 
	 public CartPage gotoCart() {
		 cartButton.click();
		 return new CartPage(driver);
	 }

}
