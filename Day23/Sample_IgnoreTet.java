package Day23;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Sample_IgnoreTet {
    WebDriver driver;
    WebDriverWait wait;

    @Test(enabled = false)
    public void disabledTest() {
        // This test is disabled and will not run
        System.out.println("Disabled test – should not execute");
    }

    @Ignore
    @Test
    public void ignoredTest() {
        // This test is ignored by TestNG
        System.out.println("Ignored test – should not execute");
    }


    @Test
    public void normalTest() {
        // This one runs normally
        System.out.println("Normal test – runs as expected");
    }
}
