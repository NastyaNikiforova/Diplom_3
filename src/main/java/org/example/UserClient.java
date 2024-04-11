package org.example;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {
    //метод для POST-запроса на ручку /api/auth/register (регистрация нового пользователя)
    public Response create(UserData userData) {
        return given()
                .header("Content-type", "application/json")
                .body(userData)
                .when()
                .post("/api/auth/register");
    }
    //метод для POST-запроса на ручку /api/auth/login (логин пользователя)
    public Response login(UserData userData) {
        return given()
                .header("Content-type", "application/json")
                .body(userData)
                .when()
                .post("/api/auth/login");
    }
    //метод для DELETE-запроса на ручку /api/auth/user (удаление пользователя)
    public Response delete(String accessToken) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .delete("/api/auth/user");
    }
}
