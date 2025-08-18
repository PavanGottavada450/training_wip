package Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoqaGroupTests {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
    }

    @Test(groups = {"smoke"})
    public void verifyHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("ToolsQA"), "Home page title verification");
    }

    @Test(groups = {"functional"})
    public void openPracticeForm() {
        driver.findElement(By.xpath("//h5[text()='Forms']")).click();
        driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
        Assert.assertTrue(
            driver.getCurrentUrl().contains("automation-practice-form"),
            "Practice Form page should open"
        );
    }

    @Test(groups = {"functional"})
    public void fillPracticeForm() {
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john.doe@example.com");
        // Optionally submit or validate form, etc.
        Assert.assertTrue(driver.findElement(By.id("firstName")).getAttribute("value").equals("John"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
