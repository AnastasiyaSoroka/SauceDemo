package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void checkErrorWithUsernameEmpty() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Incorrect error appears");
    }

}
