package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuBar {
	WebDriver driver;

	@FindBy(xpath = "//div[@class='o_menu_sections']/div/button/span")
	private List<WebElement> menuItems;

	@FindBy(xpath = "//div[@class='o_menu_sections']/div/div/a")
	private List<WebElement> subMenuItems;

	public TopMenuBar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// To click Menu Item.
	public void clickOn_Menu(String menuLabel) {
		for (WebElement webElement : menuItems) {
			if (webElement.getText().equals(menuLabel)) {
				webElement.click();
				break;
			}
		}
	}

	// To click subMenu Item.
	public void clickOn_SubMenu(String subMenuLabel) {
		for (WebElement webElements : subMenuItems) {
			if (webElements.getText().equals(subMenuLabel)) {
				webElements.click();
				break;
			}
		}
	}
}
