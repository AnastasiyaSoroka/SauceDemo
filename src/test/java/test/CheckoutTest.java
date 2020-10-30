package test;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static pages.ProductPage.PRODUCT_LABEL;

public class CheckoutTest extends BaseTest {

    private String productName = "Sauce Labs Fleece Jacket";

    @Test(description = "Check if User clicks on Continue Shopping button, he is redirected to the Inventory Page")
    public void checkContinueShoppingRedirectToInventoryPage() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage.openPage()
                .isPageOpened()
                .clickContinueShopping();

        boolean isProductPageOpened = productPage
                .isPageOpened()
                .isElementDisplayed(PRODUCT_LABEL);

        assertTrue(isProductPageOpened, "Page is not opened");
    }

    @Test(description = "Check Error message if First Name is not populated on the Checkout Page")
    public void checkErrorWithFirstNameEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);

        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .isPageOpened()
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: First Name is required", "Incorrect error appears");
    }

    @Test(description = "Check Error message if Last Name is not populated on the Checkout Page")
    public void checkErrorWithLastNameEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .isPageOpened()
                .sendKeysToFirstName("blablabla")
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: Last Name is required", "Incorrect error appears");
    }

    @Test(description = "Check Error message if Zip/Postal Code is not populated on the Checkout Page")
    public void checkErrorWithZipCodeEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .isPageOpened()
                .sendKeysToFirstName("blablabla")
                .sendKeysToLastName("blablabla")
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: Postal Code is required", "Incorrect error appears");
    }

}
