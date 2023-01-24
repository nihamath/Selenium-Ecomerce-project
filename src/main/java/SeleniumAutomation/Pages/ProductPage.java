package SeleniumAutomation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumAutomation.Utils.WaitHelper;

public class ProductPage {
	
	WaitHelper waits;
	WebDriver driver;
	public ProductPage(WebDriver driver){
		
		 waits = new WaitHelper(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	
	@FindBy(xpath="//span[@class='title']")  WebElement productListTitle;
	 @FindBy(xpath="//div[@class='inventory_item_name']")  List<WebElement> productList;
	 
	 public ProductDetailsPage viewDeatilsOfSelectedProduct(String productName) {
		 
		 waits.waitFroElementToVisible(productList.get(0));
			for(WebElement product: productList) {
				if(product.getText().equalsIgnoreCase(productName)) {
					product.click();
					break;
				}
			}
		 return new ProductDetailsPage(driver);
	 }
	 
	 public boolean IsProductPageDisplayes() {
	 
	 
		return productListTitle.isDisplayed();
	 }

}
