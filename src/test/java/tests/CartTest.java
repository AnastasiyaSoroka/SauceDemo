package tests;

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

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

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

    @Test
    public void productCouldBeRemovedFromCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

        productPage
                .isPageOpened()
                .addToCart(firstProductName);

        boolean isRemovedDisplayed = cartPage
                .openPage()
                .isPageOpened()
                .clickRemoveItemFromCart().isElementDisplayed(REMOVE_BUTTON);

        assertFalse(isRemovedDisplayed, "Remove button is on the page");
    }

    @Test
    public void twoProductsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

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

    @Test
    public void productRemovedFromItemPageNotInCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

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
