package Day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrames {
	WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // handling the page loading time
		driver.get("https://practice-automation.com/iframes/");
		driver.manage().window().maximize();
	}

	// Frame 1
	@Test(priority = 1)
	public void Frame1(){
		// Switching to the particular frame
		WebElement iframe1 = driver.findElement(By.id("iframe-1"));
		driver.switchTo().frame(iframe1);

		// Wait until button is clickable and click
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".DocSearch.DocSearch-Button"))).click();

		// Thread.sleep(3000);

		/* If we directly try to find this element, it will throw an error stating "Unable to locate the element" 
		so we should first SwitchTo that particular Iframe */
		driver.findElement(By.className("DocSearch-Input")).sendKeys("Wassup Everyone");

		// Return to main page from iframe
		driver.switchTo().defaultContent();
	}

	// Frame 2
	@Test(priority = 2)
	public void Frame2() {
		// Switching to the particular frame
		WebElement iframe2 = driver.findElement(By.id("iframe-2"));
		driver.switchTo().frame(iframe2);
		
 		/* 1st if we try to get this element, it will throw an error because it is inside the Iframe so       
 		 we need to switch to that frame */
		driver.findElement(By.xpath("//span[normalize-space()='Downloads']")).click();

		// Coming back to the main page
		driver.switchTo().defaultContent();
	}
	
	@AfterClass
	public void tearDown() {
		if(driver != null)
			driver.quit();
	}

	
	
}
