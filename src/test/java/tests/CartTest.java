package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void productShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.login(username, password);
        productPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getPriceForProduct("Sauce Labs Fleece Jacket"), "49.99");
        Assert.assertEquals(cartPage.getQuantityForProduct("Sauce Labs Fleece Jacket"), "1");
    }

}
