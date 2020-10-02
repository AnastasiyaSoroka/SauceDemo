package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR = By.xpath("//*[contains(text(),'Epic')]");

    private String endpoint = "index.html";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

    public void openPage() {
        driver.get(URL+endpoint);
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }

    public void clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
    }
}