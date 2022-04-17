package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class ProductPage {
	WebDriver driver;

	@FindBy(xpath = "//button/span[contains(text(),'Update Quantity')]")
	private WebElement btn_updateQuantity;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public void clickOn_UpdateQuantity() {
		Wait.waitForElementToBeClickable(driver, btn_updateQuantity).click();
	}

}
