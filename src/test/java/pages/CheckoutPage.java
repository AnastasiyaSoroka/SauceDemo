package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By CONTINUE_BUTTON = By.cssSelector("[value=CONTINUE]");
    private final By ERROR = By.cssSelector("[data-test=error]");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP_CODE = By.id("postal-code");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        return this;
    }

    public CheckoutPage openPage() {
        return this;
    }

    public CheckoutPage clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    public String getErrorText() {
        isErrorAppears();
        return driver.findElement(ERROR).getText();
    }

    public void isErrorAppears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
    }

    public CheckoutPage sendKeysToFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    public CheckoutPage sendKeysToLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    public CheckoutPage sendKeysToZipCode(String zipCode) {
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        return this;
    }

}