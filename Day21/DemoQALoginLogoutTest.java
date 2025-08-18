package Day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQALoginLogoutTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");
    }

    @Test
    public void validLoginLogoutTest() {
        driver.findElement(By.id("userName")).sendKeys("pavanG");
        driver.findElement(By.id("password")).sendKeys("Pavan@123");
        driver.findElement(By.id("login")).click();

        // Assert profile page loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
        Assert.assertTrue(logoutBtn.isDisplayed(), "Logout button not found!");

        logoutBtn.click();

        // Assert redirected to login page
        Assert.assertTrue(driver.findElement(By.id("login")).isDisplayed(), "Login button not displayed after logout!");
    }

    @Test
    public void invalidLoginTest() {
        driver.findElement(By.id("userName")).sendKeys("wrongUser");
        driver.findElement(By.id("password")).sendKeys("wrongPass123");
        driver.findElement(By.id("login")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        Assert.assertTrue(errorMsg.isDisplayed(), "Error message not displayed!");
        Assert.assertEquals(errorMsg.getText().trim(), "Invalid username or password!");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
