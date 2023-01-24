package SeleniumAutomation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
	
WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	 @FindBy(css=".inventory_item_name")   WebElement productNameOverview;
	 @FindBy(css="#finish")   WebElement finishButton;
	 
	 public String getProductNameFromOverview() {
		return productNameOverview.getText();
	 }
	 
	 public PurchaseResultPage gotToPurchaseResult() {
		 finishButton.click();
		 return new PurchaseResultPage(driver);
		 }
	 

}
