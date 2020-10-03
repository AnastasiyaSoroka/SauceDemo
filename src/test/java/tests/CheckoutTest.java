package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkCheckoutPageOpened() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(username, password);
        productPage.isPageOpened();
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.isPageOpened();
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
        Assert.assertEquals(checkoutPage.getCurrentURL(), "https://www.saucedemo.com/checkout-step-one.html", "CheckOut page should be opened");
    }

    @Test
    public void checkContinueShoppingRedirectToInventoryPage() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(username, password);
        productPage.isPageOpened();
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.isPageOpened();
        cartPage.clickContinueShopping();
        productPage.isPageOpened();
        Assert.assertEquals(productPage.getCurrentURL(), "https://www.saucedemo.com/inventory.html", "Inventory page should be opened");
    }

    @Test
    public void checkErrorWithFirstNameEmpty() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(username, password);
        productPage.isPageOpened();
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.isPageOpened();
        cartPage.clickCheckout();
        checkoutPage.isPageOpened();
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: First Name is required", "Incorrect error appears");
    }


    @Test
    public void checkErrorWithLastNameEmpty() {
        loginPage.openPage();
        loginPage.login(username, password);
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.sendKeysToFirstName("blablabla");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required", "Incorrect error appears");
    }

    @Test
    public void checkErrorWithZipCodeEmpty() {
        loginPage.openPage();
        loginPage.login(username, password);
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.sendKeysToFirstName("blablabla");
        checkoutPage.sendKeysToLastName("blablabla");
        checkoutPage.clickContinue();
        Assert.assertEquals(checkoutPage.getErrorText(), "Error: Postal Code is required", "Incorrect error appears");
    }

}
