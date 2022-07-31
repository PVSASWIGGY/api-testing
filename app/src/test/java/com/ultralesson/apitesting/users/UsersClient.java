package com.ultralesson.apitesting.users;

import com.ultralesson.apitesting.create.UserObject;
import com.ultralesson.apitesting.create.UserObjectResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class UsersClient {

    public UserObjectResponse createUsers(UserObject userInfo) {
        Response response= create(userInfo);
        UserObjectResponse userObjectResponse=response.as(UserObjectResponse.class);
        userObjectResponse.setStatusCode(response.statusCode());
        return userObjectResponse;

    }

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
        return given()
                .when()
                .get("https://gorest.co.in/public/v2/users");
    }
}
