package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class FinishPage extends BasePage {

    private final By FINISH_LABEL = By.className("subheader");

    @Step("Finish page was opened")
    public FinishPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору " + FINISH_LABEL);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public FinishPage openPage() {
        return this;
    }

    public FinishPage(WebDriver driver) {
        super(driver);
    }
}
