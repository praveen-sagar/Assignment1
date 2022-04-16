package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPopup {
	WebDriver driver;

	@FindBy(xpath = "//h4[@class='modal-title']")
	private WebElement txt_Title;

	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement btn_Close;

	@FindBy(xpath = "//footer[@class='modal-footer']//button")
	private List<WebElement> btn_footer;

	public ConfirmPopup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String get_AlertTitle() {
		return txt_Title.getText();
	}

	public void clickOn_Close() {
		btn_Close.click();
	}

	public void clickOn_OK() {
		btn_footer.get(0).click();
	}

	public void clickOn_Cancel() {
		btn_footer.get(1).click();
	}
}
