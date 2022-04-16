package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateQuantityPage {
	WebDriver driver;
	
	@FindBy(xpath = "//nav/a[@title='Home menu']")
	private WebElement nav_Home;

	@FindBy(xpath = "//button[contains(text(),'Create')]")
	private WebElement btn_Create;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement btn_Save;
	
	@FindBy(xpath = "//input[@name='inventory_quantity']")
	private WebElement txtbx_Quantity;

	public UpdateQuantityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_Title() {
		return driver.getTitle();
	}

	public void clickOn_Create() {
		btn_Create.click();
	}
	
	public void clickOn_Save() {
		btn_Save.click();
	}
	
	public void clickOn_Home() {
		nav_Home.click();
	}
	
	public void enter_Quantity(String qty) {
		txtbx_Quantity.clear();
		txtbx_Quantity.sendKeys(qty);
	}

}
