package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

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
            wait.until(ExpectedConditions.visibilityOfElementLocated(REMOVE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + REMOVE_BUTTON);
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
        driver.findElement(REMOVE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
