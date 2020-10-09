package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutOverviewTest extends BaseTest {

    private String firstProductName = "Sauce Labs Fleece Jacket";
    private String secondProductName = "Sauce Labs Bolt T-Shirt";
    private String firstProductPrice = "49.99";

    @Test
    public void checkItemTotalTwoProducts() {

        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productPage
                .isPageOpened()
                .addToCart(firstProductName)
                .addToCart(secondProductName);
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckout();

        checkoutPage
                .sendKeysToFirstName("blablabla")
                .sendKeysToLastName("blablabla")
                .sendKeysToZipCode("1112s")
                .clickContinue();

        String priceTotal = checkOutOverviewPage
                .isPageOpened()
                .getItemsTotalPrice();

        String priceSummary = checkOutOverviewPage
                .isPageOpened()
                .getItemsTotalSum();

        assertEquals(priceTotal, priceSummary, "Total item is incorrect");

    }

    @Test
    public void checkItemTotalOneProduct() {

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
                .clickCheckout();

        checkoutPage
                .sendKeysToFirstName("blablabla")
                .sendKeysToLastName("blablabla")
                .sendKeysToZipCode("1112s")
                .clickContinue();

        String item_total = checkOutOverviewPage
                .isPageOpened()
                .getItemTotal();

        assertEquals(item_total, "Item total: $" + firstProductPrice, "Price is not correct");

    }

}
