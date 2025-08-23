package Day29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderExample {
	WebDriver driver;
	WebDriverWait wait;
	
	@Parameters({"browserName","url"})
	@BeforeClass
	public void LaunchBrowser(String browserName, String url) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid Browser");
			break;
		}
		
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
	}
	
	@Test(dataProvider= "registerData")
	   public void RegisterNewUser(String firstname, String lastname, String streetname, String city, String state,
	           String zipcode, String phonenumber, String ssn, String username, String password, String repeatedpassword) {
	       // Click Register link
	       wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer.firstName"))).sendKeys(firstname);
	       driver.findElement(By.name("customer.lastName")).sendKeys(lastname);
	       driver.findElement(By.name("customer.address.street")).sendKeys(streetname);
	       driver.findElement(By.name("customer.address.city")).sendKeys(city);
	       driver.findElement(By.name("customer.address.state")).sendKeys(state);
	       driver.findElement(By.name("customer.address.zipCode")).sendKeys(zipcode);
	       driver.findElement(By.name("customer.phoneNumber")).sendKeys(phonenumber);
	       driver.findElement(By.name("customer.ssn")).sendKeys(ssn);
	       driver.findElement(By.name("customer.username")).sendKeys(username);
	       driver.findElement(By.name("customer.password")).sendKeys(password);
	       driver.findElement(By.name("repeatedPassword")).sendKeys(repeatedpassword);
	       // Submit
	       driver.findElement(By.xpath("//input[@value='Register']")).click();
	       // Validate successful registration
	       Assert.assertTrue(
	               wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Welcome")),
	               "Registration failed!");
	       // Logout
	       wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out"))).click();
	   }

	
	public void afterClass() throws InterruptedException {
		if(driver != null) {
			Thread.sleep(2000);
			driver.quit();
		}
	}
	
	@DataProvider(name = "registerData")
	public Object[][] registerdata(){
		return new Object[][] {
			{"pavan", "g", "abc Street", "Eluru", "AP", "12345", "1234567890", "1234567890", "PAVAN123" , "pa1@123", "pa1@123"},
			{"asdf", "as", "asd street" , "wer", "KA", "12345", "1234567890", "1234567890", "asdf123", "asd@123", "asd@123"}
		};
	}
}
