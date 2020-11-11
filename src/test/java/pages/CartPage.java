package pages;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

@Log4j2
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
            log.info("Opening Cart Page. Waiting till element appears by locator " + CONTINUE_BUTTON);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        } catch (TimeoutException ex) {
            log.fatal("Cart Page is not opened. The button is not founded by locator " + CONTINUE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CartPage openPage() {
        log.info("Cart page URL is " + URL + endpoint);
        driver.get(URL + endpoint);
        return this;
    }

    @Step("User clicks on Item Name button")
    public void clickOnItemNameLocator(String productName) {
        log.info("User is clicking on Item Name button by locator: " + By.xpath(String.format(itemNameLocator, productName)));
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
        log.info("User is clicking on Checkout button by locator: " + CHECKOUT_BUTTON);
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("User clicks on Continue Shopping button")
    public void clickContinueShopping() {
        log.info("User is clicking on Continue Shopping button by locator: " + CONTINUE_BUTTON);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("User clicks on Remove selected product from the Cart")
    public CartPage clickRemoveItemFromCart() {
        log.info("User is clicking on Remove selected product from the Cart by locator: " + REMOVE_BUTTON);
        driver.findElement(REMOVE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}