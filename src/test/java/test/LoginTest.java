package test;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Check Error message if Username is empty")
    public void checkErrorWithUsernameEmpty() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("", "dfgdfgdfgdf")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Username is required", "Incorrect error appears");
    }

    @Test(description = "Check Error message if Password is empty")
    public void checkErrorWithPasswordEmpty() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("dfgdfgdfgdfg", "")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Password is required", "Incorrect error appears");
    }

    @Test(description = "Check Error message if Username and Password are incorrect")
    public void checkErrorWithUsernamePasswordIncorrect() {

        String errorText = loginPage
                .openPage()
                .attemptLogin("", "dfgdfgdfgdf")
                .getErrorText();

        assertEquals(errorText, "Epic sadface: Username is required", "Incorrect error appears");
    }

}
