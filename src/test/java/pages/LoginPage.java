package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR = By.cssSelector("[data-test=error]");

    private String endpoint = "index.html";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public LoginPage attemptLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public ProductPage login(String username, String password) {
        attemptLogin(username, password);
        return new ProductPage(driver);
    }


    public LoginPage openPage() {
        driver.get(URL + endpoint);
        return this;
    }

    public String getErrorText() {
        isErrorAppears();
        return driver.findElement(ERROR).getText();
    }

    public void isErrorAppears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}