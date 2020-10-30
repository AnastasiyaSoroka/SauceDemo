package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class CheckoutPage extends BasePage {

    private final By CONTINUE_BUTTON = By.cssSelector("[value=CONTINUE]");
    private final By ERROR = By.cssSelector("[data-test=error]");
    private final By FIRST_NAME = By.id("first-name");
    private final By LAST_NAME = By.id("last-name");
    private final By ZIP_CODE = By.id("postal-code");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checkout page was opened")
    public CheckoutPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CheckoutPage openPage() {
        return this;
    }

    @Step("User is clicking on Continue button")
    public CheckoutPage clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    @Step("Error appears on Checkout page")
    public String getErrorText() {
        isErrorAppears();
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(ERROR).getText();
    }

    public void isErrorAppears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
    }

    @Step("User populates First Name with the following value:")
    public CheckoutPage sendKeysToFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    @Step("User populates LastName Code with the following value:")
    public CheckoutPage sendKeysToLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    @Step("User populates ZIP Code with the following value:")
    public CheckoutPage sendKeysToZipCode(String zipCode) {
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        return this;
    }

}