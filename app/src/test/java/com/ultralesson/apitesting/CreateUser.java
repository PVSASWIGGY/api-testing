package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class CreateUser {
    @Test
    public void createFemaleUser(){
        String body = "{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"tenali.ramakrishna5@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUsers(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("tenali.ramakrishna5@gmail.com"));
    }

    @Test
    public void CreateFemaleUser(){
        String body = "{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"aditi.rao1@gmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUsers(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo("aditi.rao1@gmail.com"));
    }



}
