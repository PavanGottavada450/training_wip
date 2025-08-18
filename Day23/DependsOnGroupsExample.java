package Day23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class DependsOnGroupsExample {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
    }

    @Test(groups = {"smoke"})
    public void loginTest() {
        driver.findElement(By.name("username")).sendKeys("Admin");;
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        wait.until(ExpectedConditions.urlContains("/dashboard"));
        assert driver.getCurrentUrl().contains("/dashboard");
    }

    
    @Test(groups = {"regression"})
    public void invalidLoginTest() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".oxd-alert-content-text")));
        assert error.isDisplayed();
    }
    

    @Test(dependsOnGroups = {"smoke", "regression"})
    public void finalReportGeneration() {
        System.out.println("This runs only after SMOKE and REGRESSION groups have passed.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
