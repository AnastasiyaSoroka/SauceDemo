package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckOutOverviewPage extends BasePage {

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By SUMMARY_LABEL = By.className("summary_total_label");

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(SUMMARY_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена сумма " + SUMMARY_LABEL);
        }
    }

}
