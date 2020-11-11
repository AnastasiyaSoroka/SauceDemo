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
public class FinishPage extends BasePage {

    private final By FINISH_LABEL = By.className("subheader");

    @Step("Finish page was opened")
    public FinishPage isPageOpened() {
        try {
            log.info("Opening Finish Page. Waiting till element appears by locator " + FINISH_LABEL);
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_LABEL));
        } catch (TimeoutException ex) {
            log.fatal("Cart Page is not opened. The button is not founded by locator " + FINISH_LABEL);
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
