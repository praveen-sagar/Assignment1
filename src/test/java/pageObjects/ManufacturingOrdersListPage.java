package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Wait;

public class ManufacturingOrdersListPage {
	WebDriver driver;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btn_create;

	public ManufacturingOrdersListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public void clickOn_Create() {
		Wait.waitForElementToBeClickable(driver, btn_create).click();
	}
}
