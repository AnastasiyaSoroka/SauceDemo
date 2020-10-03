package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button\n";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }

}
