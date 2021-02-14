package com.homework.restassured;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserTest {

    @Test
    public void createUserTestSuccess() {
        JSONObject params = new JSONObject();
        params.put("id", 1092);
        params.put("username", "myname");
        params.put("firstName", "Ivan");
        params.put("lastName", "Ivanov");
        params.put("email", "testmail@mail.ru");
        params.put("password", "pass");
        params.put("phone", "89992227676");
        params.put("userStatus", 0);

        given()
                .header("Content-Type", "application/json")
                .body(params.toJSONString())
        .when()
                .post("https://petstore.swagger.io/v2/user")
        .then()
                .statusCode(200);
    }

    @Test
    public void createUserTestWithoutContentType() {
        JSONObject params = new JSONObject();
        params.put("id", 1092);
        params.put("username", "myname");
        params.put("firstName", "Ivan");
        params.put("lastName", "Ivanov");
        params.put("email", "testmail@mail.ru");
        params.put("password", "pass");
        params.put("phone", "89992227676");
        params.put("userStatus", 0);

        given()
                .body(params.toJSONString())
                .when()
                .post("https://petstore.swagger.io/v2/user")
                .then()
                .statusCode(415);
    }

    @Test
    public void getUserTestSuccess() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/user/myname")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserTestNotFound() {
        given()
                .when()
                .get("https://petstore.swagger.io/v2/user/over9000")
                .then()
                .statusCode(404);
    }
}
