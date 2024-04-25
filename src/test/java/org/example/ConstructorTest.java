package org.example;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

public class ConstructorTest extends BaseTest {
    private Constructor objConstructor;

    @Before
    public void setObj() {
        objConstructor = new Constructor(driver);
    }
    @Step("Click on bun button")
    public void clickOnBunButton() {
        objConstructor.clickBunButton();
    }
    @Step("Click on sauce button")
    public void clickOnSauceButton() {
        objConstructor.clickSauceButton();
    }
    @Step("Click on filling button")
    public void clickOnFillingButton() {
        objConstructor.clickFillingButton();
    }
    @Step("Check successful transfer to bun tab")
    public void checkTransferToBunTab() {
        objConstructor.checkBunClassChanges();
    }
    @Step("Check successful transfer to sauce tab")
    public void checkTransferToSauceTab() {
        objConstructor.checkSauceClassChanges();
    }
    @Step("Check successful transfer to filling tab")
    public void checkTransferToFillingTab() {
        objConstructor.checkFillingClassChanges();
    }
    @Test
    @DisplayName("Click on sauce button and check successful transfer")
    public void clickSauceButtonAndCheck() {
        clickOnSauceButton();
        checkTransferToSauceTab();
    }
    @Test
    @DisplayName("Click on bun button and check successful transfer")
    public void clickBunButtonAndCheck() {
        clickOnSauceButton();
        clickOnBunButton();
        checkTransferToBunTab();
    }
    @Test
    @DisplayName("Click on filling button and check successful transfer")
    public void clickFillingButtonAndCheck() {
        clickOnFillingButton();
        checkTransferToFillingTab();
    }
}
