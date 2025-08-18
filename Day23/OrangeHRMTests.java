package Day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class OrangeHRMTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver(); // Ensure chromedriver is in PATH or configured
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(groups = {"smoke"})
    public void testLoginSuccess() {
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        user.sendKeys("Admin");
        pass.sendKeys("admin123");
        loginBtn.click();

        // Wait for Dashboard URL
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        assert driver.getCurrentUrl().contains("/dashboard");
    }

    @Test(groups = {"regression"})
    public void testLoginFailure() {
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        user.sendKeys("Admin");
        pass.sendKeys("wrongpass");
        loginBtn.click();

        // Wait for error message
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".oxd-alert-content-text")));
        assert error.isDisplayed();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
