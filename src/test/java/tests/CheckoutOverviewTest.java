package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void checkCheckoutOverviewPageOpened() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(username, password);
        productPage.isPageOpened();
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.isPageOpened();
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
        checkoutPage.sendKeysToFirstName("blablabla");
        checkoutPage.sendKeysToLastName("blablabla");
        checkoutPage.sendKeysToZipCode("111jjj333");
        checkoutPage.clickContinue();
        checkOutOverviewPage.isPageOpened();
        Assert.assertEquals(checkOutOverviewPage.getCurrentURL(), "https://www.saucedemo.com/checkout-step-two.html", "CheckOut:Overview page should be opened");
    }

}
