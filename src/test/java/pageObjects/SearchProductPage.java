package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends BasePage {
	
	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='caption']//h4//a")
	WebElement validateProduct;
	
	public boolean isProductExist(String product) {
		return product.equals(validateProduct.getText()); 
	}
	
	public void clickProduct() {
		validateProduct.click();
	}
	
	
}
