package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {
    private Login objLogin;
    private UserClient userClient;
    @Before
    public void setUpAndCreateUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userClient = new UserClient();
        userClient.create(new UserData("magenta@yandex.ru", "yellow", "Alex"));
        objLogin = new Login(driver);
    }
    @Step("Click on the 'Log in to account' button")
    public void clickLogInToAccountButton() {
        objLogin.clickLoginAccountButton();
    }
    @Step("Click on the 'Personal Account' button")
    public void clickOnPersonalAccountButton() {
        objLogin.clickPersonalAccountButton();
    }
    @Step("Click on the 'Log in' link in the registration form")
    public void clickOnLoginLinkInRegForm() {
        objLogin.clickLoginLinkInRegistrationForm();
    }
    @Step("Click on the 'Log in' link on the password recovery page")
    public void clickLoginLinkOnPasswordPage() {
        objLogin.clickLoginLinkOnPasswordRecoveryPage();
    }
    @Step("Set user data in the fields in the authorization form")
    public void setUserDataInAuthForm() {
        objLogin.setUserData(new UserData("magenta@yandex.ru", "yellow", ""));
    }
    @Step("Click on the 'Log in' button")
    public void clickLogInButton() {
        objLogin.clickLoginButton();
    }
    @Step("Check the visibility of the 'Place an order' button")
    public void checkVisibilityOrderButton() {
        objLogin.waitVisibleOrderButton();
    }
    @Test
    @DisplayName("Check login with 'Log in to account' button")
    public void checkLoginWithLogInToAccountButton() {
        clickLogInToAccountButton();
        setUserDataInAuthForm();
        clickLogInButton();
        checkVisibilityOrderButton();
    }

    @Test
    @DisplayName("Check login with 'Personal Account' button")
    public void checkLoginWithPersonalAccountButton() {
        clickOnPersonalAccountButton();
        setUserDataInAuthForm();
        clickLogInButton();
        checkVisibilityOrderButton();
    }

    @Test
    @DisplayName("Check login with 'Log in' link in the registration form")
    public void checkLoginWithLogInLinkInRegForm() {
       clickOnLoginLinkInRegForm();
       setUserDataInAuthForm();
       clickLogInButton();
       checkVisibilityOrderButton();
    }

    @Test
    @DisplayName("Check login with 'Log in' link on the password recovery page")
    public void checkLoginWithLogInLinkOnPasswordPage() {
        clickLoginLinkOnPasswordPage();
        setUserDataInAuthForm();
        clickLogInButton();
        checkVisibilityOrderButton();
    }
}
