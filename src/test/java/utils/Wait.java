package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class Wait {
	static WebDriverWait wait;

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}
}
