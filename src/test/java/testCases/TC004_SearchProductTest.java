package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchProductPage;
import testBase.BaseClass;

public class TC004_SearchProductTest extends BaseClass{
	
	@Test(groups = {"Master"})
	public void verify_searchProduct() {
		
		logger.info("***** Starting TC004_SearchProductTest ******");
		try {
			
			HomePage hp = new HomePage(driver);
			hp.enterProduct("iPhone");
			hp.clickSearch();
			 
			SearchProductPage spp = new SearchProductPage(driver);
			spp.isProductExist("iPhone");
			
			Assert.assertEquals(spp.isProductExist("iPhone"), true);
			
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC004_SearchProductTest ******");
	}
	
}
