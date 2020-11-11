package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.AllureUtils;

@Log4j2
public class MenuPage extends BasePage {

    private By CLOSE_BUTTON = By.xpath("//button[text()='Close Menu']");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Menu was opened")
    public MenuPage isPageOpened() {
        try {
            log.info("Opening Menu Page. Waiting till element appears by locator " + CLOSE_BUTTON);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CLOSE_BUTTON));
        } catch (TimeoutException ex) {
            log.fatal("Menu Page is not opened. The button is not founded by locator " + CLOSE_BUTTON);
        }
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public MenuPage openPage() {
        return this;
    }

}
