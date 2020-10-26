package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR = By.cssSelector("[data-test=error]");

    private String endpoint = "index.html";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login page was opened")
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Trying to log in with the following parameters:")
    public LoginPage attemptLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage openPage() {
        driver.get(URL + endpoint);
        return this;
    }

    @Step("Error appears")
    public String getErrorText() {
        isErrorAppears();
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(ERROR).getText();
    }

    public void isErrorAppears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
    }

}