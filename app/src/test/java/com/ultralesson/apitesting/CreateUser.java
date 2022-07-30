package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class CreateUser {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void createMaleUser(){
        String email= UUID.randomUUID()+"@gmail.com";
        String body = String.format("{\n" +
                "    \"name\": \"Tenali Ramakrishna\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        usersClient.createUsers(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email));
    }

    @Test
    public void CreateFemaleUser(){
        String email=UUID.randomUUID()+"@gmail.com";
        String body = String.format("{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        new UsersClient().createUsers(body)
                .then()
                .statusCode(201)
                .log().body()
                .body("id", Matchers.notNullValue())
                .body("email",Matchers.equalTo(email));
    }



}
