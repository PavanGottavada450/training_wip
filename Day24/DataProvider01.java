package Day24;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider01 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.out.println("Launching the browser.");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test(dataProvider = "logInTestData")
    public void logIn(String userName, String password) {
        System.out.println("Logging In with: " + userName + " / " + password);

        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        userField.sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        // Validation
        if (password.equals("admin123")) {
            // Valid login should take us to dashboard
            wait.until(ExpectedConditions.urlContains("/dashboard"));
            Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Valid login failed!");
        } else {
            // Invalid login should show error
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-alert-content-text")));
            Assert.assertTrue(error.isDisplayed(), "Error message not displayed for invalid login!");
        }
    }

    @DataProvider(name = "logInTestData")
    public Object[][] logInData() {
        return new Object[][] {
                {"Admin", "admin123"},   // valid login
                {"Admin", "wrongpass"}   // invalid login
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
