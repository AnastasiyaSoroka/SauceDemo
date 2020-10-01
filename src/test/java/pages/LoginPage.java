package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR = By.xpath("//*[contains(text(),'Epic')]");
    public static final String URL = "https://www.saucedemo.com/index.html";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

    public void openPage() {
        driver.get(URL);
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}