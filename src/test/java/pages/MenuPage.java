package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

public class MenuPage extends BasePage {

    private By CLOSE_BUTTON = By.xpath("//button[text()='Close Menu']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Menu was opened")
    public MenuPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найден product label по локатору " + CLOSE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public MenuPage openPage() {
        return this;
    }

}
