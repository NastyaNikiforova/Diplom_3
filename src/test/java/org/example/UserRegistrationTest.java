package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest extends BaseTest {
    UserRegistration objUserRegistration;

    @Before
    public void setting() {
        objUserRegistration = new UserRegistration(driver);
    }
    @Step("Click on the 'Personal Account' button")
    public void clickOnPersonalAccountButton() {
        objUserRegistration.clickPersonalAccountButton();
    }
    @Step("Click registration link")
    public void clickRegistrationLink() {
        objUserRegistration.clickRegisterLink();
    }
    @Step("Set valid user data in the fields in the registration form")
    public void setUserDataInRegForm() {
        objUserRegistration.setUserData(new UserData("magenta@yandex.ru", "yellow", "Alex"));
    }
    @Step("Set user data and invalid password in the fields in the registration form")
    public void setUserDataAndInvalidPasswordInRegForm() {
        objUserRegistration.setUserData(new UserData("magenta@yandex.ru", "yell", "Alex"));
    }
    @Step("Click 'Sign up' button")
    public void clickSignUpButton() {
        objUserRegistration.clickSignUpButton();
    }
    @Step("Check of successful registration - go to the authorization page")
    public void checkOpenAuthForm() {
        objUserRegistration.waitOpenAuthForm();
    }
    @Step("Check the appearance of the error message")
    public void checkErrorMessage() {
        objUserRegistration.waitErrorMessage();
    }
    @Test
    @DisplayName("Check of successful user registration and access to the authorization page")
    public void successfulUserRegistrationTest() {
        clickOnPersonalAccountButton();
        clickRegistrationLink();
        setUserDataInRegForm();
        clickSignUpButton();
        checkOpenAuthForm();
    }
    @Test
    @DisplayName("Check of registration with an invalid password and an error message appears")
    public void userRegistrationWithInvalidPasswordTest() {
        clickOnPersonalAccountButton();
        clickRegistrationLink();
        setUserDataAndInvalidPasswordInRegForm();
        clickSignUpButton();
        checkErrorMessage();
    }
}
