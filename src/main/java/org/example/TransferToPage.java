package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransferToPage extends BasePage {
    //локатор кнопки "Личный кабинет"
    private By personalAccountButton = By.cssSelector("[href='/account']");
    //локатор "Конструктор"
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //локатор логотипа Stellar Burgers
    private By stellarBurgersLogo = By.xpath(".//div[contains(@class, 'logo')]");
    //локатор кнопки "Профиль"
    private By profileButton = By.cssSelector("[href='/account/profile'");
    //локатор заголовка "Соберите бургер"
    private By menuHeader = By.xpath(".//h1[text()='Соберите бургер']");
    public TransferToPage(WebDriver driver) {
        super(driver);
    }
    //метод клик по кнопке "Личный кабинет"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }
    //метод клик по кнопке "Конструктор"
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    //метод клик по логотипу Stellar Burgers
    public void clickStellarBurgersLogo() {
        driver.findElement(stellarBurgersLogo).click();
    }

    //метод, заполняющий поле Email
    private void setEmail(UserData userData) {
        By emailField = By.xpath("//label[text()='Email']/following-sibling::input");
        driver.findElement(emailField).sendKeys(userData.getEmail());
    }
    //метод, заполняющий поле Пароль
    private void setPassword(UserData userData) {
        By passwordField = By.xpath(".//input[@name='Пароль']");
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
        By loginButton = By.xpath(".//button[text()='Войти']");
        driver.findElement(loginButton).click();
    }
    //проверка успешного перехода (видна кнопка "Профиль" на странице пользователя)
    public void waitVisibleProfileButton() {
        String expectedText = "Профиль";
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(profileButton, expectedText));
    }
    //проверка успешного перехода (виден заголовок "Соберите бургер")
    public void waitVisibleMenuHeader() {
        String expectedText = "Соберите бургер";
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuHeader));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(menuHeader, expectedText));
    }
}