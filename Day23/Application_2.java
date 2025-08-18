package Day23;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Application_2 {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "firefox": driver = new FirefoxDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            default: driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void testFirstNameField() {
        WebElement firstName = driver.findElement(By.id("firstName"));
        Assert.assertTrue(firstName.isDisplayed());
        firstName.sendKeys("Pavan");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}