package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.IndividualProductPage;
import pageObjects.SearchProductPage;
import pageObjects.ViewCartPage;
import testBase.BaseClass;

public class TC006_ViewCartPageTest extends BaseClass {
	
	@Test(groups = {"Master"})
	public void verify_viewCart() {
		logger.info("***** Started TC006_ViewCartPageTest ******");
		
		try {
			
			HomePage hp = new HomePage(driver);
			hp.enterProduct(p.getProperty("searchProductName"));
			hp.clickSearch();
			
			SearchProductPage spp = new SearchProductPage(driver);
			spp.clickProduct();
			
			IndividualProductPage ipp = new IndividualProductPage(driver);
			ipp.clearQuantity();
			Thread.sleep(3000);
			ipp.enterQuantity("3");
			ipp.clickAddcart();
			Thread.sleep(3000);
			ipp.clickCart();
			
			List<WebElement> products = ipp.getVerifyProducts();
			for(WebElement product:products) {
				if(product.getText().equals(p.getProperty("searchProductName"))) {
					Thread.sleep(2000);
					ipp.clickViewCart();
					break;
				};
			}
			
			ViewCartPage vcp = new ViewCartPage(driver);
			Assert.assertEquals(true, vcp.verifycartTextDiplay());
			
		} catch (Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("***** Finished TC006_ViewCartPageTest ******");
	}
}
