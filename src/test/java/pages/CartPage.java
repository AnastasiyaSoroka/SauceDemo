package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private String endpoint = "cart.html";

    private String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    private String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";

    private final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    private final By CONTINUE_BUTTON = By.className("btn_secondary");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(URL + endpoint);
    }

    public String getPriceForProduct(String productName) {

        return driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
    }

    public String getQuantityForProduct(String productName) {
        return driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
    }

    public void clickCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickContinueShopping() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
