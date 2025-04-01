package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.IndividualProductPage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC005_AddToCartPageTest extends BaseClass {
	@Test (groups = {"Master"})
	public void verify_addToCart() {
		
		logger.info("***** Started TC005_AddToCartPageTest ******");
		
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
			Thread.sleep(3000);
			ipp.clickAddcart();
			
			String successMsg = ipp.getConfirmationMsg();
			Assert.assertTrue(successMsg.contains("Success: You have added " + p.getProperty("searchProductName") + " to your shopping cart!"));
			
		} catch (Exception e) {
			logger.error("Test Failed");
			//logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("***** Finished TC005_AddToCartPageTest ******");
		
	}
}
