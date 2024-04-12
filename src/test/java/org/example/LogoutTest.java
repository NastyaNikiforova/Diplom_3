package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class LogoutTest extends BaseTest {
    private Logout objLogout;
    private UserClient userClient;
    @Before
    public void createUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userClient = new UserClient();
        userClient.create(new UserData("magenta@yandex.ru", "yellow", "Alex"));
        objLogout = new Logout(driver);
    }
    @Step("Log in user")
    public void loginUser() {
        objLogout.clickPersonalAccountButton();
        objLogout.setUserData(new UserData("magenta@yandex.ru", "yellow", ""));
        objLogout.clickLoginButton();
    }
    @Step("Click 'Personal account' button")
    public void clickPersonalAccountButton() {
        objLogout.clickPersonalAccountButton();
    }
    @Step("Click 'Log out' button")
    public void clickLogOutButton() {
        objLogout.clickLogoutButton();
    }
    @Step("Check visible 'log in' header")
    public void checkLogInHeader() {
        objLogout.waitVisibleLoginHeader();
    }
    @Test
    @DisplayName("Check successful logout")
    public void checkSuccesfulLogout() {
        loginUser();
        clickPersonalAccountButton();
        clickLogOutButton();
        checkLogInHeader();
    }
}
