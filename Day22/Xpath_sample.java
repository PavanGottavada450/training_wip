package Day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_sample {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://w3schools.com/");
		
		driver.findElement(By.xpath("//a[@id='navbtn_exercises']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
} 
