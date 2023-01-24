package SeleniumAutomation.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumAutomation.Pages.LoginPage;
import SeleniumAutomation.Pages.ProductPage;
import SeleniumAutomation.TestComponents.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test(groups={"Smoke test"})
	public void login_with_valid_credentials() {
		
		LoginPage login = new LoginPage(driver);
		ProductPage product = login.loginToApplication(read.getUserName(), read.getPassword());
		Assert.assertTrue(product.IsProductPageDisplayes());
	}
	
	@Test
	public void login_with_invalid_credentials() {
		
		LoginPage login = new LoginPage(driver);
		login.loginToApplication("standard_user1", "secret_sauce");
		Assert.assertEquals(login.getErrorMessage(), "Epi2c sadface: Username and password do not match any user in this service");
	}

}
