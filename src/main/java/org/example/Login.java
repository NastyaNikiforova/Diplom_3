package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

//класс страницы входа в личный кабинет
public class Login extends BasePage {
    //локатор кнопки "Войти в аккаунт" на главной
    private By loginAccountButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //локатор кнопки «Личный кабинет»
    private By personalAccountButton = By.cssSelector("[href='/account']");
    //локатор ссылки "Войти" в форме регистрации и на странице восстановления пароля
    private By loginLink = By.cssSelector("[href='/login']");
    //локатор поля "Email"
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    //локатор поля "Пароль"
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //локатор кнопки "Войти"
    private By loginButton = By.xpath(".//button[text()='Войти']");
    //локатор ссылки "Зарегистрироваться"
    private By registerLink = By.cssSelector("[href='/register']");
    //локатор ссылки "Восстановить пароль"
    private By forgotPasswordLink = By.cssSelector("[href='/forgot-password']");
    //локатор кнопки "Оформить заказ"
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    public Login(WebDriver driver) {
        super(driver);
    }
    //метод клик по кнопке "Войти в аккаунт"
    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }
    //метод клик по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    //метод клик по ссылке "Войти" в форме регистрации
    public void clickLoginLinkInRegistrationForm() {
        driver.findElement(loginAccountButton).click();  //клик по кнопке "Войти в аккаунт"
        driver.findElement(registerLink).click();        //клик по ссылке "Зарегистрироваться"
        driver.findElement(loginLink).click();           //клик по ссылке "Войти"
    }
    //метод клик по ссылке "Войти" на странице восстановления пароля
    public void clickLoginLinkOnPasswordRecoveryPage() {
        driver.findElement(loginAccountButton).click();  //клик по кнопке "Войти в аккаунт"
        driver.findElement(forgotPasswordLink).click();  //клик по ссылке "Восстановить пароль"
        driver.findElement(loginLink).click();           //клик по ссылке "Войти"
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
    //проверка успешного входа (на главной странице появляется кнопка "Оформить заказ")
    public void waitVisibleOrderButton() {
        String expectedText = "Оформить заказ";
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(orderButton, expectedText));
    }
}