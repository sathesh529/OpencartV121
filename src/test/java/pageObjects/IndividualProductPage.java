package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndividualProductPage extends BasePage {
	
	public IndividualProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement inputQuantity;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btnAddCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement verifyMsg;
	
	@FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btnCart;
	
	@FindBy(xpath = "//td[@class='text-left']//a")
	List<WebElement> verifyProducts;
	
	@FindBy(xpath = " //strong[normalize-space()='View Cart']")
	WebElement btnViewCart;
	
	public void clearQuantity() {
		inputQuantity.clear();
	}
	
	public void enterQuantity(String quantity) {
		inputQuantity.sendKeys(quantity);
	}
	
	public void clickAddcart() {
		btnAddCart.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(verifyMsg.getText());
	} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	public void clickCart() {
		btnCart.click();
	}
	
	public void clickViewCart() {
		btnViewCart.click();
	}
	
	public List<WebElement> getVerifyProducts(){
		return verifyProducts;
	}
	
}
