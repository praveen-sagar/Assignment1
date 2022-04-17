package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	static WebDriverWait wait;
	private static final int waitTime = 10;

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return webElement;
	}
}
