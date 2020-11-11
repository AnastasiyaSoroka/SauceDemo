package test;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.CapabilitiesGenerator;
import utils.PropertyReader;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    private WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckOutOverviewPage checkOutOverviewPage;
    InventoryItemPage inventoryItemPage;
    FinishPage finishPage;
    MenuPage menuPage;
    LoginPageFactory loginPageFactory;

    public static final String USERNAME = System.getProperty("username");
    //circle ci
    //System.getenv().getOrDefault("username",PropertyReader.getProperty("username"));
    public static final String PASSWORD = System.getProperty("password");
    //circle ci
    //System.getenv().getOrDefault("password",PropertyReader.getProperty("password"));

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setup(ITestContext context) {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        String variable = "driver";

        try {
            driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        } catch (IllegalStateException ex) {
            log.fatal(ex.getLocalizedMessage());
        }

        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
        inventoryItemPage = new InventoryItemPage(driver);
        finishPage = new FinishPage(driver);
        menuPage = new MenuPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        log.info("Setting driver into context with variable name " + variable);
        context.setAttribute(variable, driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}