package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewManufacturingOrderPage {
	WebDriver driver;

	@FindBy(xpath = "//button[@title='Save record']")
	private WebElement btn_Save;
	
	@FindBy(xpath = "//button[@name='action_confirm']")
	private WebElement btn_Confirm;
	
	@FindBy(xpath = "//div[@name='product_id']/div/div/input")
	private WebElement txtbx_ProductName;
	
	@FindBy(xpath = "//li[@class='ui-menu-item'][1]")
	private WebElement opt_Product;
	
	////button[@class='btn btn-primary']//span[contains(text(),'Mark as Done')]
	
	public NewManufacturingOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public void clickSaveButton() {
		btn_Save.click();
	}
	
	public void clickOn_Confirm() {
		btn_Confirm.click();
	}
	
	public void select_Product(String name) {
		txtbx_ProductName.sendKeys(name);
		opt_Product.click();
	}
}
