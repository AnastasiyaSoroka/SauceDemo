package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

@Log4j2
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
        try {
            log.info("Opening Login Page. Waiting till element appears by locator " + LOGIN_BUTTON);
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException ex) {
            log.fatal("Login Page is not opened. The button is not founded by locator " + LOGIN_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Trying to log in with the following parameters:")
    public LoginPage attemptLogin(String username, String password) {
        log.info("Populating Username by locator: " + USERNAME_INPUT);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info("Populating Password by locator: " + PASSWORD_INPUT);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Clicking on Login button" );
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public LoginPage openPage() {
        log.info("Login page URL is " + URL + endpoint);
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