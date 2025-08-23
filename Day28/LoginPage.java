package Day28;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Locators with PageFactory
    @FindBy(id = "userName")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(id = "newUser")
    WebElement newUserBtn;

    @FindBy(id = "name")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Page actions
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isNewUserBtnDisplayed() {
        return newUserBtn.isDisplayed();
    }
}
