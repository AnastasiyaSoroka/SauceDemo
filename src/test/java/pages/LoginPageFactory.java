package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {

    private String endpoint = "index.html";
    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory isPageOpened() {
        return this;
    }


    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public LoginPageFactory openPage() {
        driver.get(URL + endpoint);
        return this;
    }


}
