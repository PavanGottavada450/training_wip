package Day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"Admin", "Admin@123", true},
            {"invalidUser", "invalidPassword", false}
//            {"", "Admin@123", false},
//            {"Admin", "", false}
        };
    }

    @Test(dataProvider = "loginData", priority = 1, groups = {"smoke", "login"})
    public void testLogin(String username, String password, boolean shouldSucceed) {
        driver.get("https://demoqa.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']"))
        );
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='login']"));
        loginButton.click();

        if (shouldSucceed) {
            // Wait until we land on Profile page
            wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));

            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://demoqa.com/profile",
                    "User should be redirected to Profile page after successful login");
            
        } else {
            WebElement errorMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='name']"))
            );
            Assert.assertTrue(errorMsg.isDisplayed(), "Error message should be displayed for invalid login");
        }
    }

    @Test(priority = 2, dependsOnGroups = "login", groups = {"regression"})
    public void logoutTest() {
        driver.get("https://demoqa.com/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']"))
        );

        // Assuming valid credentials
        usernameField.sendKeys("validUser");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("validPassword");
        driver.findElement(By.xpath("//button[@id='login']")).click();

        WebElement logoutButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submit' and text()='Log out']"))
        );
        logoutButton.click();

        WebElement loginButton = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']"))
        );
        Assert.assertTrue(loginButton.isDisplayed(), "Login button should reappear after logout");
    }
}
