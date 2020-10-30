package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    private String productName = "Sauce Labs Fleece Jacket";

    @Test(description = "Check if User clicks Add to Cart button, the Name of the button was changed to Remove")
    public void checkTextButtonChangedFromAddToRemove() {

        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        String nameButton = productPage
                .isPageOpened()
                .addToCart(productName)
                .getButtonValue(productName);

        assertEquals(nameButton, "REMOVE", "Button wasn't clicked");
    }

    @Test(description = "Check if User clicks Remove from Cart button, the Name of the button was changed to Add")
    public void checkTextButtonChangedFromRemoveToAdd() {

        loginPage
                .openPage()
                .isPageOpened()
                .attemptLogin(USERNAME, PASSWORD);

        String nameButton = productPage
                .isPageOpened()
                .addToCart(productName)
                .addToCart(productName)
                .getButtonValue(productName);

        assertEquals(nameButton, "ADD TO CART", "Button wasn't clicked");
    }

}
