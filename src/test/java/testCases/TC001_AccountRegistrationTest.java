package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = {"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("***** starting TC001_AccountRegistrationTest *****");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount Link");
			
			hp.clickRegister();
			logger.info("Clicked on Register Link");
			
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			
			logger.info("providing customer details...");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");
			regpage.setTelephone(randomeNumber());
			
			String password = randomeAlphaNumeric();
			
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected message...");
			String confmsg = regpage.getConfirmatonMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("Test Failed");
			//logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("***** finished TC001_AccountRegistrationTest *****");
	}
	

	
	
}
