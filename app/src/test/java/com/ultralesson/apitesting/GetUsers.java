package com.ultralesson.apitesting;

import com.ultralesson.apitesting.get.UserObjectResponse;
import com.ultralesson.apitesting.users.UsersClient;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUsers {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void testGetAllUsersAPI(){
        Response response = usersClient.getUsers();
        response
                .then()
                    .statusCode(200);
        List<UserObjectResponse> dataList=usersClient.getUserObjectResponse(response);
        Assert.assertEquals(dataList.size(),10);
    }
}
