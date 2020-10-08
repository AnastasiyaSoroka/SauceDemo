package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class MenuPage extends BasePage {

    private By CLOSE_BUTTON = By.xpath("//button[text()='Close Menu']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найден product label по локатору " + CLOSE_BUTTON);
        }
        return this;
    }

    public MenuPage openPage() {
        return this;
    }

}
