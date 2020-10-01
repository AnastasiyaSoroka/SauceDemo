package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class Settings {

    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckOutOverviewPage checkOutOverviewPage;
    public static final String username = "standard_user";
    public static final String password = "secret_sauce";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkOutOverviewPage = new CheckOutOverviewPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}