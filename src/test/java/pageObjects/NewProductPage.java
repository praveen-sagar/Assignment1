package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class NewProductPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='name']")
	WebElement productName;

	@FindBy(xpath = "//button[@title ='Save record']")
	WebElement btn_Save;

	@FindBy(xpath = "//div[@class='o_form_buttons_edit']/button")
	List<WebElement> btn_ControlPanel;

	@FindBy(xpath = "//div[@class = 'o_statusbar_buttons']/button")
	List<WebElement> btn_StatusBar;

	public NewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOn_save() {
		Wait.waitForElementToBeClickable(driver, btn_Save).click();;
	}

	public void enter_ProductName(String name) {
		productName.sendKeys(name);
	}

	public void select_ControlPanel_Button(String cpLabel) {
		for (WebElement webElement : btn_ControlPanel) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(cpLabel)) {
				webElement.click();
				break;
			}
		}
	}

	public void select_StatusBar_Button(String statusBarLabel) {
		for (WebElement webElement : btn_StatusBar) {
			if (webElement.getText().equals(statusBarLabel)) {
				webElement.click();
				break;
			}
		}
	}

}
