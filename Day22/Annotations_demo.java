package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotations_demo {
	WebDriverWait wait;
	WebDriver driver;
	
	@BeforeTest
	public void InitialiseBrowser() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
	
	@Test
	public void logIn() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	
	
}
