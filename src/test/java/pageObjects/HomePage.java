package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {

	WebDriver driver;

	@FindBy(xpath = "//div[@role='listbox']/a/div[2]")
	private List<WebElement> menuItems;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// To click Menu Item.
	public void clickOn_Menu(String menu) {

		for (WebElement webElement : menuItems) {
			if (webElement.getText().equals(menu)) {
				webElement.click();
			}
		}
	}
}
