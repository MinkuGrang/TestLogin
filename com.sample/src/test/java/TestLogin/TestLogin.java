package TestLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		WebDriverWait wait = new WebDriverWait(driver, 5);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	}

	@Test()
	public void dologin() {
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("MinkuGrang");
	}

	@AfterMethod
	public void tearoff() {
		driver.quit();
	}

}
