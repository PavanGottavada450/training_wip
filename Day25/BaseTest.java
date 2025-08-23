package Day25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                System.out.println("Unknown browser: " + browser + " → Launching Chrome by default");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
