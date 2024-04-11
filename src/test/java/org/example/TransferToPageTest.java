package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class TransferToPageTest extends BaseTest {
    private TransferToPage objTransferToPage;
    private UserClient userClient;

    @Before
    public void createAndLoginUser() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        userClient = new UserClient();
        userClient.create(new UserData("magenta@yandex.ru", "yellow", "Alex"));
        objTransferToPage = new TransferToPage(driver);
    }
    @Step("Click on the 'Personal Account' button")
    public void clickOnPersonalAccountButton() {
        objTransferToPage.clickPersonalAccountButton();
    }
    @Step("Click on the 'Constructor' button")
    public void clickOnConstructorButton() {
        objTransferToPage.clickConstructorButton();
    }
    @Step("Click on the Stellar Burgers logo")
    public void clickOnStellarBurgersLogo() {
        objTransferToPage.clickStellarBurgersLogo();
    }
    @Step("Log in user")
    public void loginUser() {
        objTransferToPage.clickPersonalAccountButton();
        objTransferToPage.setUserData(new UserData("magenta@yandex.ru", "yellow", ""));
        objTransferToPage.clickLoginButton();
    }
    @Step("Check visible of 'Profile' button")
    public void checkVisibleProfileButton() {
        objTransferToPage.waitVisibleProfileButton();
    }
    @Step("Check visible of menu header")
    public void checkVisibleMenuHeader() {
        objTransferToPage.waitVisibleMenuHeader();
    }
    @Test
    @DisplayName("Check the transfer to the Personal account")
    public void checkTransferToPersonalAccount() {
        loginUser();
        clickOnPersonalAccountButton();
        checkVisibleProfileButton();
    }
    @Test
    @DisplayName("Check the transfer in the menu of click on the 'Constructor'")
    public void checkTransferInMenuClickConstructor() {
        loginUser();
        clickOnPersonalAccountButton();
        clickOnConstructorButton();
        checkVisibleMenuHeader();
    }
    @Test
    @DisplayName("Check the transfer in the menu of click on the Stellar Burgers logo")
    public void checkTransferInMenuClickLogo() {
        loginUser();
        clickOnPersonalAccountButton();
        clickOnStellarBurgersLogo();
        checkVisibleMenuHeader();
    }
}
