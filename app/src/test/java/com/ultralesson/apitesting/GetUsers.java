package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void testGetAllUsersAPI(){
        usersClient.getUsers()
                .then()
                .statusCode(200)
                .log().body()
                .body("body", Matchers.hasSize(10));
    }

}
