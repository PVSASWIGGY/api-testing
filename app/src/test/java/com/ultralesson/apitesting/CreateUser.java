package com.ultralesson.apitesting;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class CreateUser {
    @Test
    public void testAddNewUser(){
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna54@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        createUser(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna54@gmail.com"));
    }

    @Test
    public void CreateFemaleUser(){
        String body = "{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"aditi.rao@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        createUser(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("aditi.rao@gmail.com"));
    }

    private Response createUser(String userInfo) {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .header("Authorization", "Bearer 8ed75a51d163800b750d03c69dc9c1a94c7eedb2c06642ad5c8377904a0d1a91")
                .body(userInfo)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
