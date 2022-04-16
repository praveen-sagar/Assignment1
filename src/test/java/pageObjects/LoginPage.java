package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {

	WebDriver driver;

	@FindBy(xpath = "// div/input[@id='login']")
	private WebElement txtbx_Email;

	@FindBy(xpath = "// div/input[@id='password']")
	private WebElement txtbx_Password;

	@FindBy(xpath = "// div/button[@type ='submit']")
	private WebElement btn_Login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_Email(String email) {
		txtbx_Email.sendKeys(email);
	}

	public void enter_Password(String password) {
		txtbx_Password.sendKeys(password);
	}

	public void clickOn_Login() {
		btn_Login.click();
	}

	public void do_Login(String username, String password) {
		enter_Email(username);
		enter_Password(password);
		clickOn_Login();
	}
}
