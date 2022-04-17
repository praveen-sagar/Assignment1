package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//button/span[@class='oe_topbar_name']")
	private List<WebElement> btn_UserName;

	@FindBy(xpath = "//div[@role='listbox']/a/div[2]")
	private List<WebElement> btn_Feature;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean Check_Username_exists() {
		return btn_UserName.size() > 0;
	}

	public void clickOn_Menu(String featureLabel) {
		for (WebElement feature : btn_Feature) {
			if (feature.getText().equals(featureLabel)) {
				feature.click();
			}
		}
	}
}
