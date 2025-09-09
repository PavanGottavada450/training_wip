package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Random;

public class RegistrationTest {

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

    // Utility → generate unique email for positive registration
    public String getRandomEmail() {
        Random random = new Random();
        return "testuser" + random.nextInt(10000) + "@gmail.com";
    }

    @Test(priority = 1)
    public void registerNewUserSuccess() {
        // Navigate to My Account → Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Fill valid details
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Doe");
        driver.findElement(By.id("input-email")).sendKeys(getRandomEmail());
//        driver.findElement(By.id("input-email")).sendKeys("testuser@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.id("input-confirm")).sendKeys("Password123");

        // Accept privacy policy
        driver.findElement(By.name("agree")).click();

        // Submit form
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Validate success message
        WebElement successMsg = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertTrue(successMsg.isDisplayed(), "Account creation failed!");
    }

    @Test(priority = 2)
    public void registerWithExistingEmail() {
        // Navigate to My Account → Register
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();

        // Use existing email
        driver.findElement(By.id("input-firstname")).sendKeys("Jane");
        driver.findElement(By.id("input-lastname")).sendKeys("Smith");
        driver.findElement(By.id("input-email")).sendKeys("testuser@gmail.com"); // already registered email
        driver.findElement(By.id("input-telephone")).sendKeys("9876501234");
        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.id("input-confirm")).sendKeys("Password123");

        // Accept privacy policy
        driver.findElement(By.name("agree")).click();

        // Submit form
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Validate warning message
        WebElement warning = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertTrue(warning.getText().contains("Warning: E-Mail Address is already registered!"),
                "Expected error message not displayed!");
    }
}
