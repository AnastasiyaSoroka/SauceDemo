package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static pages.ProductPage.PRODUCT_LABEL;

public class CheckoutTest extends BaseTest {

    private String productName = "Sauce Labs Fleece Jacket";

    @Test
    public void checkContinueShoppingRedirectToInventoryPage() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage.openPage()
                .isPageOpened()
                .clickContinueShopping();

        boolean isProductPageOpened = productPage
                .isPageOpened()
                .isElementDisplayed(PRODUCT_LABEL);

        assertTrue(isProductPageOpened,"Page is not opened");
     }

    @Test
    public void checkErrorWithFirstNameEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);

        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .sendKeysToFirstName("blablabla")
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: First Name is required", "Incorrect error appears");
    }

    @Test
    public void checkErrorWithLastNameEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .sendKeysToFirstName("blablabla")
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: Last Name is required", "Incorrect error appears");
    }

    @Test
    public void checkErrorWithZipCodeEmpty() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(productName);
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        String actualErrorMessage = checkoutPage
                .sendKeysToFirstName("blablabla")
                .sendKeysToLastName("blablabla")
                .clickContinue()
                .getErrorText();

        assertEquals(actualErrorMessage, "Error: Postal Code is required", "Incorrect error appears");
    }

}
