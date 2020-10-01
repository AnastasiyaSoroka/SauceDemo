package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Settings {


    @Test
    public void checkErrorWithUsernameEmpty() {
        loginPage.openPage();
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Incorrect error appears");
    }


}
