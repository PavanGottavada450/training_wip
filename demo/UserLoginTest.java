package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class UserLoginTest {

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
    public void loginWithValidCredentials() {
        // Navigate to My Account → Login
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // Enter valid login credentials (use an already registered email)
        driver.findElement(By.id("input-email")).sendKeys("pavan07@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Pavan123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Validate My Account page
        WebElement myAccountHeader = driver.findElement(By.xpath("//h2[text()='My Account']"));
        Assert.assertTrue(myAccountHeader.isDisplayed(), "Login failed with valid credentials!");
    }

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {
        // Navigate to My Account → Login
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        // Enter invalid login credentials
        driver.findElement(By.id("input-email")).sendKeys("invaliduser@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("WrongPass123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Validate warning message
        WebElement warning = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        Assert.assertTrue(warning.getText().contains("Warning: No match for E-Mail Address and/or Password."),
                "Expected warning not displayed for invalid login!");
    }
}
