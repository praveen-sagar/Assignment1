package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {
	WebDriver driver;

	@FindBy(xpath = "//button[@title ='Create record']")
	private WebElement btn_Create;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement txtbx_ProductName;

	@FindBy(xpath = "//div[@class='o_form_buttons_edit']/button")
	private List<WebElement> btn_ControlPanel;

	@FindBy(xpath = "//div[@class = 'o_statusbar_buttons']/button")
	private List<WebElement> btn_StatusBar;

	public ProductsListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOn_Create() {
		btn_Create.click();
	}

	public void enter_ProductName(String name) {
		txtbx_ProductName.sendKeys(name);
	}

	public void select_ControlPanel(String cpLabel) {
		for (WebElement webElement : btn_ControlPanel) {
			if (webElement.getText().equals(cpLabel)) {
				webElement.click();
				break;
			}
		}
	}

	public void select_StatusBar(String statusBarLabel) {
		for (WebElement webElement : btn_StatusBar) {
			if (webElement.getText().equals(statusBarLabel)) {
				webElement.click();
				break;
			}
		}
	}

}
