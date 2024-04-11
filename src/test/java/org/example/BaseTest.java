package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.example.Constants.URL_STELLAR_BURGERS;
import static org.hamcrest.Matchers.equalTo;

public class BaseTest {
    protected WebDriver driver;
    private UserClient userClient;
    private UserData userData;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);
        driver.get(URL_STELLAR_BURGERS);
        userClient = new UserClient();
        userData = new UserData("kadabra@yandex.ru", "magical", "Fiona");
    }

    @After
    public void deleteTestData() {
        //удаление созданного юзера через API
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        Response loginResponse = userClient.login(userData);
        if (loginResponse.getStatusCode() == 200) {
            String token = loginResponse.then().extract().path("accessToken");
            StringBuilder builder = new StringBuilder(token);
            String accessToken = builder.substring(7);
            Response deleteResponse = userClient.delete(accessToken);
            deleteResponse.then().statusCode(202)
                    .and().assertThat().body("message", equalTo("User successfully removed"));
        }
        //закрытие браузера
        driver.quit();
    }

    private WebDriver getDriver(String browser) {

        switch (browser.toLowerCase()) {
            case "chrome":
                // WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser");
        }
    }
}