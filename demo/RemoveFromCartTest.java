package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class RemoveFromCartTest {

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

    @Test
    public void removeProductFromCart() {
        // Step 1: Search & add iPhone to cart
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iPhone");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        driver.findElement(By.xpath("//span[text()='Add to Cart']/..")).click();

        // Step 2: Navigate to Shopping Cart
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        // Validate product is in cart
        WebElement productName = driver.findElement(By.linkText("iPhone"));
        Assert.assertTrue(productName.isDisplayed(), "iPhone not found in shopping cart!");

        // Step 3: Click Remove (trash bin icon)
        driver.findElement(By.xpath("//i[@class='fa fa-times-circle']")).click();

        // Step 4: Validate cart is empty
        WebElement emptyCartMsg = driver.findElement(By.xpath("//div[@id='content']/p[contains(text(),'Your shopping cart is empty!')]"));
        Assert.assertTrue(emptyCartMsg.isDisplayed(), "Cart is not empty after removing product!");
    }
}
