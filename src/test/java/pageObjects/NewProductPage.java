package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProductPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='name']")
	WebElement productName;
	
	@FindBy(xpath = "//button[@title ='Save record']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@class='o_form_buttons_edit']/button")
	List<WebElement> controlPanelButtons;

	@FindBy(xpath = "//div[@class = 'o_statusbar_buttons']/button")
	List<WebElement> statusBarButtons;

	public NewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void save() {
		saveButton.click();
	}

	public void enterProductName(String name) {
		productName.sendKeys(name);
	}

	public void selectControlPanelButton(String cpLabel) {
		for (WebElement webElement : controlPanelButtons) {
			System.out.println(webElement.getText());
			if (webElement.getText().equals(cpLabel)) {
				webElement.click();
				break;
			}
		}
	}

	public void selectStatusBarButton(String statusBarLabel) {
		for (WebElement webElement : statusBarButtons) {
			if (webElement.getText().equals(statusBarLabel)) {
				webElement.click();
				break;
			}
		}
	}

}
