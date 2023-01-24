package SeleniumAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends HeaderMenu{
	
	WebDriver driver;
	public ProductDetailsPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	 @FindBy(xpath="//div[@class='inventory_details_desc_container']/button")   WebElement addToCartButton;
	 
	 public void addProductToCart() {
		 addToCartButton.click();
	 }

}
