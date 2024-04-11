package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

//класс страницы регистрации пользователя
public class UserRegistration extends BasePage {
    //локатор кнопки "Личный кабинет"
    private By personalAccountButton = By.cssSelector("[href='/account']");
    //локатор ссылки "Зарегистрироваться"
    private By registerLink = By.cssSelector("[href='/register']");
    //локатор поля "Имя"
    private By nameField = By.xpath("//label[text()='Имя']/following-sibling::input");
    //локатор поля "Email"
    private By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
    //локатор поля "Пароль"
    private By passwordField = By.xpath(".//input[@name='Пароль']");
    //локатор кнопки "Зарегистрироваться"
    private By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public UserRegistration(WebDriver driver) {
        super(driver);
    }
    //метод клик по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountButton));
        driver.findElement(personalAccountButton).click();
    }
    //метод клик по кнопке Зарегистрироваться
    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }
    //метод, заполняющий поле Имя
    private void setName(UserData userData) {
        driver.findElement(nameField).sendKeys(userData.getName());
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
    //метод, заполняющий поля в форме регистрации
    public void setUserData(UserData userData) {
        setEmail(userData);
        setPassword(userData);
        setName(userData);
    }
    //метод клик по кнопке Зарегистрироваться
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    //проверка успешной регистрации - переход на страницу авторизации
    public void waitOpenAuthForm() {
        By authForm = By.className("Auth_login__3hAey");
        String expectedText = "Вход";
        wait.until(ExpectedConditions.visibilityOfElementLocated(authForm));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(authForm, expectedText));
    }
    //проверка ошибки при некорректном пароле
    public void waitErrorMessage() {
        By errorMessage = By.xpath(".//p[contains(@class,'input__error')]");
        String expectedText = "Некорректный пароль";
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(errorMessage, expectedText));
    }
}
