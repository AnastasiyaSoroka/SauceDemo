package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

import java.util.List;

public class CheckOutOverviewPage extends BasePage {

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By SUMMARY_ITEM = By.className("summary_subtotal_label");
    private final By PRICE_ITEM = By.className("inventory_item_price");

    @Step("Checkout page was opened")
    public CheckOutOverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_ITEM));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена сумма " + SUMMARY_ITEM);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public CheckOutOverviewPage openPage() {
        return this;
    }

    public String getItemTotal() {
        return driver.findElement(SUMMARY_ITEM).getText();
    }

    public String getItemsTotalPrice() {
        return driver.findElement(SUMMARY_ITEM).getText().substring(13);
    }

    public String getItemsTotalSum() {
        List<WebElement> items = driver.findElements(PRICE_ITEM);
        double summary = 0;

        for (WebElement element : items) {
            summary += Double.valueOf(element.getText().substring(1));
        }
        String sum = String.valueOf(summary);
        return sum;
    }

}
