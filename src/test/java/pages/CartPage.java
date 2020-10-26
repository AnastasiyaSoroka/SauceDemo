package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class CartPage extends BasePage {

    private String endpoint = "cart.html";

    private String itemNameLocator = "//*[contains(text(),'%s')]";

    private String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    private String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    private final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    private final By CONTINUE_BUTTON = By.xpath("//*[contains(@class,'checkout_button')]/../*[contains(text(),'Continue Shopping')]");
    public static final By REMOVE_BUTTON = By.xpath("//*[contains(@class,'item_pricebar')]/*[contains(text(),'REMOVE')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Cart page was opened")
    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + CONTINUE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CartPage openPage() {
        driver.get(URL + endpoint);
        return this;
    }

    @Step("User clicks on Item Name button")
    public void clickOnItemNameLocator(String productName) {
        driver.findElement(By.xpath(String.format(itemNameLocator, productName))).click();
    }

    public String getPriceForProduct(String productName) {
        return driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
    }

    public String getQuantityForProduct(String productName) {
        return driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
    }

    @Step("User clicks on Checkout button")
    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("User clicks on Continue Shopping button")
    public void clickContinueShopping() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("User clicks on Remove selected product from the Cart")
    public CartPage clickRemoveItemFromCart() {
        driver.findElement(REMOVE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}