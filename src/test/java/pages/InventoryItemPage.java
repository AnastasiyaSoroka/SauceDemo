package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;
@Log4j2
public class InventoryItemPage extends BasePage {


    private By REMOVE_BUTTON = By.xpath("//button[contains(text(),'REMOVE')]");
    private By itemName = By.className("inventory_details_name");
    private By itemPrice = By.className("inventory_details_price");

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    @Step("Inventory Item page was opened")
    public InventoryItemPage isPageOpened() {
        try {
            log.info("Opening InventoryItem Page. Waiting till element appears by locator " + REMOVE_BUTTON);
            wait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_BUTTON));
        } catch (TimeoutException ex) {
            log.fatal("InventoryItem Page is not opened. The button is not founded by locator " + REMOVE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public InventoryItemPage openPage() {
        return this;
    }

    public String getPriceForProduct() {
        return driver.findElement(itemPrice).getText();
    }

    public String getNameForProduct() {
        return driver.findElement(itemName).getText();
    }

    @Step("User clicks on Remove selected product from the Cart")
    public InventoryItemPage clickRemoveItemFromCart() {
        log.info("User is clicking on Remove selected product from the Cart by locator: " + REMOVE_BUTTON);
        driver.findElement(REMOVE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
