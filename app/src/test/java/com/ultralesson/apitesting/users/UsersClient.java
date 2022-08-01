package com.ultralesson.apitesting.users;

import com.ultralesson.apitesting.users.create.UserObject;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersClient {



    public Response create(UserObject userInfo) {
        Response response = given()
                .accept(JSON)
                .contentType(JSON)
                .header("Authorization", "Bearer 8ed75a51d163800b750d03c69dc9c1a94c7eedb2c06642ad5c8377904a0d1a91")
                .body(userInfo)
                .when()
                .post("https://gorest.co.in/public/v2/users");
        response
            .then()
                .log().body();
        return response;

    }


    public Response getUsers() {
        Response response= given()
                            .when()
                            .get("https://gorest.co.in/public/v2/users");
        return response;
    }


    public Response getUser(int id){
        return given()
                .pathParam("id",id)
                .header("Authorization","Bearer 8ed75a51d163800b750d03c69dc9c1a94c7eedb2c06642ad5c8377904a0d1a91")
            .when()
                .get("https://gorest.co.in/public/v2/users/{id}");
    }
}
