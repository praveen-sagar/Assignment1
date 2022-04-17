package tests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.FileReaderManager;

public class TestBase {
	public WebDriver driver;

	@BeforeSuite
	public void browserSetup() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// To maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(
				Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait()));

		// To open application site
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	@AfterSuite
	public void quitDriver() {
		// To quit the browser
		driver.quit();
	}
}
