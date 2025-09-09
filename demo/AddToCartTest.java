package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AddToCartTest {

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
    public void addProductToCart() {
        // Search for product (iPhone)
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("iPhone");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        // Click "Add to Cart"
        driver.findElement(By.xpath("//span[text()='Add to Cart']/..")).click();

        // Validate success message
        WebElement successMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"));
        Assert.assertTrue(successMsg.getText().contains("Success: You have added iPhone to your shopping cart!"),
                "Success message not displayed after adding product to cart!");

        // Open Shopping Cart
        driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]")).click();

        // Validate cart updates with correct product
        WebElement productName = driver.findElement(By.linkText("iPhone"));
        Assert.assertTrue(productName.isDisplayed(), "iPhone not found in shopping cart!");

        // Validate quantity
        String quantity = driver.findElement(By.xpath("//input[contains(@name,'quantity')]")).getAttribute("value");
        Assert.assertEquals(quantity, "1", "Cart quantity is incorrect!");

        // Validate price (fetch unit price and total)
        String unitPrice = driver.findElement(By.xpath("//td[@class='text-right'][2]")).getText();
        String totalPrice = driver.findElement(By.xpath("//td[@class='text-right'][3]")).getText();

        Assert.assertEquals(unitPrice, totalPrice, "Total price does not match unit price for single item!");
    }
}
