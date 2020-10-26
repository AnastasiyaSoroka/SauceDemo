package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static pages.CartPage.REMOVE_BUTTON;

public class CartTest extends BaseTest {

    private String firstProductName = "Sauce Labs Fleece Jacket";
    private String secondProductName = "Sauce Labs Bike Light";
    private String quantity = "1";
    private String firstProductPrice = "49.99";
    private String secondProductPrice = "9.99";

    @Test(description = "Check that Product can be added into the Cart")
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        productPage
                .isPageOpened()
                .addToCart(firstProductName);

        String actualPrice = cartPage
                .openPage()
                .isPageOpened()
                .getPriceForProduct(firstProductName);

        assertEquals(actualPrice, firstProductPrice, "Price is not correct");

        String actualQuantity = cartPage
                .getQuantityForProduct(firstProductName);

        assertEquals(actualQuantity, quantity, "Quantity is not correct");
    }

    @Test(description = "Check that Product can be removed from the Cart")
    public void productCouldBeRemovedFromCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        productPage
                .isPageOpened()
                .addToCart(firstProductName);

        boolean isRemovedDisplayed = cartPage
                .openPage()
                .isPageOpened()
                .clickRemoveItemFromCart().isElementDisplayed(REMOVE_BUTTON);

        assertFalse(isRemovedDisplayed, "Remove button is on the page");
    }

    @Test(description = "Check that two Products can be added Into the Cart")
    public void twoProductsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        productPage
                .isPageOpened()
                .addToCart(firstProductName)
                .addToCart(secondProductName);

        String actualPriceFirst = cartPage
                .openPage()
                .isPageOpened()
                .getPriceForProduct(firstProductName);

        assertEquals(actualPriceFirst, firstProductPrice, "Price is not correct for the first product");

        String actualQuantityFirst = cartPage
                .getQuantityForProduct(firstProductName);

        assertEquals(actualQuantityFirst, quantity, "Quantity is not correct for the first product");

        String actualPriceSecond = cartPage
                .getPriceForProduct(secondProductName);

        assertEquals(actualPriceSecond, secondProductPrice, "Price is not correct for the second product");

        String actualQuantitySecond = cartPage
                .getQuantityForProduct(secondProductName);

        assertEquals(actualQuantitySecond, quantity, "Quantity is not correct for the second product");

    }

    @Test(description = "Check that Product can be removed from the Cart, check that the Cart is empty")
    public void productRemovedFromItemPageNotInCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        productPage
                .isPageOpened()
                .addToCart(firstProductName);

        cartPage
                .openPage()
                .isPageOpened()
                .clickOnItemNameLocator(firstProductName);

        inventoryItemPage
                .openPage()
                .isPageOpened().clickRemoveItemFromCart();

        boolean isRemovedDisplayed = cartPage
                .openPage()
                .isPageOpened()
                .isElementDisplayed(REMOVE_BUTTON);

        assertFalse(isRemovedDisplayed, "Remove button is on the page");

    }

}
