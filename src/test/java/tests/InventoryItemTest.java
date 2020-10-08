package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InventoryItemTest extends BaseTest {

    private String productName = "Sauce Labs Fleece Jacket";
    private String productPrice = "$49.99";

    @Test
    public void productShouldBeCorrectOnItemPage() {
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
                .clickOnItemNameLocator(productName);

        String actualName = inventoryItemPage
                .openPage()
                .isPageOpened()
                .getNameForProduct();

        String actualPrice = inventoryItemPage
                .getPriceForProduct();

        assertEquals(actualName,productName,"Incorrect items's name is displayed");
        assertEquals(actualPrice,productPrice,"Incorrect items's price is displayed");

    }

}
