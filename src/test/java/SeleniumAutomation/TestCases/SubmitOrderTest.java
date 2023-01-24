package SeleniumAutomation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumAutomation.Pages.CartPage;
import SeleniumAutomation.Pages.CheckoutPage;
import SeleniumAutomation.Pages.LoginPage;
import SeleniumAutomation.Pages.OverviewPage;
import SeleniumAutomation.Pages.ProductDetailsPage;
import SeleniumAutomation.Pages.ProductPage;
import SeleniumAutomation.Pages.PurchaseResultPage;
import SeleniumAutomation.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest {
	
	@Test(groups={"Smoke test"})
	
	public void user_submit_new_order() {
		
		
		LoginPage login = new LoginPage(driver);
		
		ProductPage products=login.loginToApplication(read.getUserName(), read.getPassword());
		ProductDetailsPage prodDetails=products.viewDeatilsOfSelectedProduct(read.getProduct());
		prodDetails.addProductToCart();
		CartPage cart=prodDetails.gotoCart();
		Assert.assertEquals(cart.getProuctName(), read.getProduct());
		CheckoutPage checkout=cart.gotCheckOut();
		checkout.enterFirstName("Nihamath");
		checkout.enterLastName("Op");
		checkout.enterPostalCode("678601");
		OverviewPage overview=checkout.gotPurchaseOverview();
		Assert.assertEquals(overview.getProductNameFromOverview(), read.getProduct());
		PurchaseResultPage result=overview.gotToPurchaseResult();
		Assert.assertEquals(result.getSucessMessage(), "THANK YOU FOR YOUR ORDER");
	}

}
