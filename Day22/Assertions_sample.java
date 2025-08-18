package Day22;

//import static org.testng.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions_sample {

	@Test
	public void TestDemo() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		Thread.sleep(5000);
		
		SoftAssert softAssert = new SoftAssert();
		
		// Title assertion
		String expectedTitle = "";
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(actualTitle, expectedTitle,"Title is Mismatched");
		
		// URL assertion
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://demoqa.com/";
		softAssert.assertEquals(actualUrl, expectedUrl, "URL is mismatched");
		
		driver.quit();
		softAssert.assertAll();
	}
}
