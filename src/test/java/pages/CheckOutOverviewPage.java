package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

import java.util.List;

@Log4j2
public class CheckOutOverviewPage extends BasePage {

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By SUMMARY_ITEM = By.className("summary_subtotal_label");
    private final By PRICE_ITEM = By.className("inventory_item_price");

    @Step("Checkout page was opened")
    public CheckOutOverviewPage isPageOpened() {
        try {
            log.info("Opening CheckOutOverview Page. Waiting till element appears by locator " + SUMMARY_ITEM);
            wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_ITEM));
        } catch (TimeoutException ex) {
            log.fatal("CheckOutOverview Page is not opened. The button is not founded by locator " + SUMMARY_ITEM);
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
