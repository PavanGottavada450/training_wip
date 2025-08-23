package Day25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelIntegrationTest {

    WebDriver driver;

    @Test(dataProvider="getdata", dataProviderClass = ExcelDataProvider.class)
    public void Login(String userName, String password, String expectedResult) throws InterruptedException {
        System.out.println("Logging in with: " + userName + " / " + password + " | Expected: " + expectedResult);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // enter username & password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName"))).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();

        Thread.sleep(2000);

        try {
            if(expectedResult.equalsIgnoreCase("Valid")) {
                // success: redirected to Profile page
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));
                String loggedUser = driver.findElement(By.id("userName-value")).getText();
                System.out.println("Login successful! Logged in as: " + loggedUser);
                Assert.assertEquals(loggedUser, userName, "Usernames should match after login.");
            } else {
                // failure: invalid credentials
                String errorMsg = driver.findElement(By.id("name")).getText();
                System.out.println("Login failed for user: " + userName + " | Message: " + errorMsg);
                Assert.assertTrue(errorMsg.contains("Invalid"), "Expected invalid login message.");
            }
        } finally {
            driver.quit();
        }
    }
}
