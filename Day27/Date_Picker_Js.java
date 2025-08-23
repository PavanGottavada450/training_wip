package Day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Date_Picker_Js {
    WebDriver driver;

    @BeforeMethod
    public void LaunchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   // handling the page loading time
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
    }

    @Test
    public void DatePickerJS() {
        // As you can see an Iframe on the main page, we are suppose to switch to that particular iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

//      lets you to run Javascript directly within your browser using the scripts
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Set value directly using JavaScript
        js.executeScript("document.getElementById('datepicker').value = '21-06-2024';");
       
        driver.switchTo().defaultContent();
    }
	
	@AfterMethod
	public void tearDown() {
		if(driver != null)
			driver.quit();
	}
	
}
