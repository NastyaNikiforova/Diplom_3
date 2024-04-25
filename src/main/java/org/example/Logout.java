package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Logout extends BasePage {
    //локатор кнопки «Личный кабинет»
    private By personalAccountButton = By.cssSelector("[href='/account']");
    //локатор поля "Email"
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    //локатор поля "Пароль"
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //локатор кнопки "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");
    //локатор кнопки "Выйти"
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    //локатор заголовка "Вход"
    private By loginHeader = By.xpath(".//h2[text()='Вход']");
    public Logout(WebDriver driver) {
        super(driver);
    }
    //метод клик по кнопке "Войти в аккаунт"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    //метод, заполняющий поле Email
    private void setEmail(UserData userData) {
        driver.findElement(emailField).sendKeys(userData.getEmail());
    }
    //метод, заполняющий поле Пароль
    private void setPassword(UserData userData) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(userData.getPassword());
    }
    //метод, заполняющий поля в форме авторизации
    public void setUserData(UserData userData) {
        setEmail(userData);
        setPassword(userData);
    }
    //метод клик по кнопке "Войти"
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    //метод клик по кнопке "Выйти"
    public void clickLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
    //проверка выхода из аккаунта - виден заголовок "Вход"
    public void waitVisibleLoginHeader() {
        String expectedText = "Вход";
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(loginHeader, expectedText));
    }
}
