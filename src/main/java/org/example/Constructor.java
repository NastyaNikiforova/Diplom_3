package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Constructor extends BasePage {
    //локатор кнопки "Булки"
    private By bunButton = By.xpath(".//span[text()='Булки']/parent::div");
    //локатор кнопки "Соусы"
    private By sauceButton = By.xpath(".//span[text()='Соусы']/parent::div");
    //локатор кнопки "Начинки"
    private By fillingButton = By.xpath(".//span[text()='Начинки']/parent::div");
    //локатор заголовка в меню "Булки"
    private By bunHeader = By.xpath(".//h2[text()='Булки']");
    //локатор заголовка в меню "Соусы"
    private By sauceHeader = By.xpath(".//h2[text()='Соусы']");
    //локатор заголовка в меню "Начинки"
    private By fillingHeader = By.xpath(".//h2[text()='Начинки']");
    public Constructor(WebDriver driver) {
        super(driver);
    }
    //метод клик по кнопке "Булки"
    public void clickBunButton() {
        driver.findElement(bunButton).click();
    }
    //метод клик по кнопке "Соусы"
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }
    //метод клик по кнопке "Начинки"
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }
    //проверка успешного перехода на вкладку "Булки" - в выбранном элементе класс содержит слово "current"
    public void checkBunClassChanges() {
        String className = driver.findElement(bunButton).getAttribute("class");
        String expectedWord = "current";
        Assert.assertTrue(className.contains(expectedWord));
        String expectedHeader = "Булки";
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunHeader));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(bunHeader, expectedHeader));
    }
    //проверка успешного перехода на вкладку "Соусы" - в выбранном элементе класс содержит слово "current"
    public void checkSauceClassChanges() {
        String className = driver.findElement(sauceButton).getAttribute("class");
        String expectedWord = "current";
        Assert.assertTrue(className.contains(expectedWord));
        String expectedHeader = "Соусы";
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceHeader));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(sauceHeader, expectedHeader));
    }
    //проверка успешного перехода на вкладку "Начинки" - в выбранном элементе класс содержит слово "current"
    public void checkFillingClassChanges() {
        String className = driver.findElement(fillingButton).getAttribute("class");
        String expectedWord = "current";
        Assert.assertTrue(className.contains(expectedWord));
        String expectedHeader = "Начинки";
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingHeader));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(fillingHeader, expectedHeader));
    }
}
