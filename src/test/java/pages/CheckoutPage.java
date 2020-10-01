package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By CONTINUE_BUTTON = By.xpath("//input[@value='CONTINUE']");
    public static final By ERROR = By.xpath("//*[contains(text(),'Error')]");
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinue() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorText() {
        return driver.findElement(ERROR).getText();
    }

    public void sendKeysToFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void sendKeysToLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void sendKeysToZipCode(String zipCode) {
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
    }

}
