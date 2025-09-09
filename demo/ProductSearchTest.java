package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ProductSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void searchValidProduct() {
        // Enter product name in search box
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iPhone");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        // Validate product appears in results
        WebElement product = driver.findElement(By.linkText("iPhone"));
        Assert.assertTrue(product.isDisplayed(), "iPhone not found in search results!");
    }

    @Test(priority = 2)
    public void searchInvalidProduct() {
        // Enter invalid product name
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("NonExistingProduct");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        // Validate "no results" message
        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'There is no product')]"));
        Assert.assertTrue(message.isDisplayed(), "No results message not displayed for invalid product!");
    }
}
