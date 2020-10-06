package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage {

    private String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button\n";
    private final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найден product label по локатору " + PRODUCT_LABEL);
        }
    }

}
