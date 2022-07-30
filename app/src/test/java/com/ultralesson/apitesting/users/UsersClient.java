package com.ultralesson.apitesting.users;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersClient {

    public Response createUsers(String userInfo) {
        return given()
                .accept(JSON)
                .contentType(JSON)
                .header("Authorization", "Bearer 8ed75a51d163800b750d03c69dc9c1a94c7eedb2c06642ad5c8377904a0d1a91")
                .body(userInfo)
                .when()
                .post("https://gorest.co.in/public/v2/users");
    }
}
