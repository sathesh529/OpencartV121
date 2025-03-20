package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass=DataProviders.class, groups = "DataDriven") //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp) { 
		
		logger.info("***** Starting TC003_LoginDDT *****");
		try {
			//Home
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//myAccount
			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean targetPage = myAcc.isMyAccountPageExists();
			
			/*
			 Data is valid - login sucess - test pass - logout
			 				 login fail   - test fail		 
			  Data is Invalid - login sucess - test fail - logout
			 				 	login fail   - test pass		
			  */
			
			if(exp.equalsIgnoreCase("valid")) {
				
				if(targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(true);
				
				}else {
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid")) {
						
				if(targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(false);
				
				}else {
					Assert.assertTrue(true);
				}	
			}
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC003_LoginDDT *****");

	}
}