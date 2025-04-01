package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage extends BasePage{

	public ViewCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	WebElement verifyCartText;
	
	public Boolean verifycartTextDiplay() {
		return verifyCartText.isDisplayed();
	}

}
