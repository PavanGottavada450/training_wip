package Day28;

//import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1, groups = "negative", dataProvider = "invalidLoginData")
    public void invalidLoginTest(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), "Error message should appear");
    }

    @Test(priority = 2, groups = "positive")
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("pavan"); // use real username
        loginPage.enterPassword("Test@123"); // use real password
        loginPage.clickLogin();
        Assert.assertTrue(driver.getCurrentUrl().contains("profile"), "User should be navigated to profile page");
    }

    @DataProvider
    public Object[][] invalidLoginData() {
        return new Object[][]{
                {"wrongUser", "wrongPass"},
                {"pavan", "wrongPass"},
                {"", "Test@123"}
        };
    }
}
