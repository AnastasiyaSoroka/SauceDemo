package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkErrorWithUsernameEmpty() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("", "dfgdfgdfgdf")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Username is required", "Incorrect error appears");
    }

    @Test
    public void checkErrorWithPasswordEmpty() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("", "dfgdfgdfgdf")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Password is required", "Incorrect error appears");
    }

    @Test
    public void checkErrorWithUsernamePasswordIncorrect() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("", "dfgdfgdfgdf")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service", "Incorrect error appears");
    }

    @Test
    public void checkLoginPageByFactory() {
        loginPageFactory
                .openPage()
                .login(USERNAME, PASSWORD);
    }

}
