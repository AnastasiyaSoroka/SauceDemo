package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

@Log4j2
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
        try {
            log.info("Opening Checkout Page. Waiting till element appears by locator " + CONTINUE_BUTTON);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        } catch (TimeoutException ex) {
            log.fatal("Checkout Page is not opened. The button is not founded by locator " + CONTINUE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CheckoutPage openPage() {
        return this;
    }

    @Step("User is clicking on Continue button")
    public CheckoutPage clickContinue() {
        log.info("User is clicking on Continue button by locator: " + CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
        return this;
    }

    @Step("Error appears on Checkout page")
    public String getErrorText() {
        isErrorAppears();
        log.info("The following error appears: " + driver.findElement(ERROR).getText());
        AllureUtils.takeScreenshot(driver);
        return driver.findElement(ERROR).getText();
    }

    public void isErrorAppears() {
        log.info("User is waiting till error appears by locator: " + ERROR);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR));
    }

    @Step("User populates First Name with the following value:")
    public CheckoutPage sendKeysToFirstName(String firstName) {
        log.info("User is updating First Name with " + firstName + " by locator: " + FIRST_NAME);
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        return this;
    }

    @Step("User populates LastName Code with the following value:")
    public CheckoutPage sendKeysToLastName(String lastName) {
        log.info("User is updating Last Name with " + lastName + " by locator: " + LAST_NAME);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        return this;
    }

    @Step("User populates ZIP Code with the following value:")
    public CheckoutPage sendKeysToZipCode(String zipCode) {
        log.info("User is updating ZIP Code with " + zipCode + " by locator: " + ZIP_CODE);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        return this;
    }

}