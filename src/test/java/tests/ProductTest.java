package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    private String productName = "Sauce Labs Fleece Jacket";

    @Test
    public void checkTextButtonChangedFromAddToRemove() {

        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

        String nameButton = productPage
                .isPageOpened()
                .addToCart(productName)
                .getButtonValue(productName);

        assertEquals(nameButton, "REMOVE", "Button wasn't clicked");
    }

    @Test
    public void checkTextButtonChangedFromRemoveToAdd() {

        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);

        String nameButton = productPage
                .isPageOpened()
                .addToCart(productName)
                .addToCart(productName)
                .getButtonValue(productName);

        assertEquals(nameButton, "ADD TO CART", "Button wasn't clicked");
    }

}
