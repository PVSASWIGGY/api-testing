package com.ultralesson.apitesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsers {
    @Test
    public void testGetAllUsersAPI(){
        given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log().body()
                .body("body", Matchers.hasSize(10));
    }
}
