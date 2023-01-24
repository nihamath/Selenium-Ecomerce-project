package SeleniumAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumAutomation.Utils.WaitHelper;

public class CartPage {

	WebDriver driver;
	WaitHelper waits;
	
	public CartPage(WebDriver driver) {
		waits = new WaitHelper(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath="//span[@class='title']")   WebElement cartPageHeading;
	@FindBy(css=".inventory_item_name")   WebElement selectedProductName;
	@FindBy(css="#checkout")   WebElement checkOutButton;
	public String getProuctName() {
		waits.waitFroElementToVisible(cartPageHeading);
		return selectedProductName.getText();
	}
	public CheckoutPage gotCheckOut() {
		checkOutButton.click();
		return new CheckoutPage(driver);
	}

}
