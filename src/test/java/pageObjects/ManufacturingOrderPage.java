package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class ManufacturingOrderPage {
	WebDriver driver;

	@FindBy(xpath = "//button[@title='Save record']")
	private WebElement btn_Save;

	@FindBy(xpath = "//button[@name='action_confirm']")
	private WebElement btn_Confirm;

	@FindBy(xpath = "//a[@name='product_id']/span")
	private WebElement txt_ProductName;

	@FindBy(xpath = "//button[@class='btn btn-primary']//span[contains(text(),'Mark as Done')]")
	private WebElement btn_MarkAsDone;

	public ManufacturingOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public void clickOn_Save() {
		Wait.waitForElementToBeClickable(driver, btn_Save).click();
	}

	public void clickOn_Confirm() {
		Wait.waitForElementToBeClickable(driver, btn_Confirm).click();
	}

	public void clickOn_MarkAsDone() {
		Wait.waitForElementToBeClickable(driver, btn_MarkAsDone).click();
	}

	public String get_ProductName() {
		return txt_ProductName.getText();

	}
}
