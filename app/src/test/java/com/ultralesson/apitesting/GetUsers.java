package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.get.UserObjectResponse;
import com.ultralesson.apitesting.users.UsersClient;
import com.ultralesson.apitesting.users.UsersService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetUsers {
    private UsersService usersService;
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){

        usersService =new UsersService();
        usersClient=new UsersClient();
    }
    @Test
    public void testGetAllUsers(){
        Response response = usersClient.getUsers();
        response
                .then()
                    .statusCode(200);
        List<UserObjectResponse> dataList= usersService.getUserObjectResponse(response);
        Assert.assertEquals(dataList.size(),10);
    }
}
