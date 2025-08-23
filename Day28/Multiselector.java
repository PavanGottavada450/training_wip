package Day28;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.*;

public class Multiselector {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demoqa.com/checkbox");
        // Optional: collapse or expand as needed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Expand all']"))).click();
    }

    @Test
    public void selectMultipleCheckboxes() {
        String[] itemsToSelect = {"Desktop", "Documents", "Downloads"};

        for (String item : itemsToSelect) {
            String checkboxXPath = String.format("//span[@class='rct-title' and text()='%s']", item);
            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkboxXPath)));

            // JS click to avoid ad iframe intercept
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", checkbox);

            // Verify result
            WebElement result = driver.findElement(By.id("result"));
            Assert.assertTrue(result.getText().toLowerCase().contains(item.toLowerCase()),
                    item + " should appear in selected results.");
        }
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
