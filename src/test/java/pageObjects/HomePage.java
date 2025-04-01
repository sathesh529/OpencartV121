package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	//In page Object Model:
	//1.constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//2.Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(linkText = "Login")
	WebElement lnkLogin;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearch;
	
	@FindBy(xpath = " //button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	
	//3.Actions Method
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
	public void enterProduct(String product) {
		txtSearch.sendKeys(product);
	}
	
	public void clickSearch() {
		btnSearch.click();
	}
	    
}
