package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.create.UserObjectErrorResponse;
import com.ultralesson.apitesting.users.create.UserObject;
import com.ultralesson.apitesting.users.UsersClient;
import com.ultralesson.apitesting.users.UsersService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class CreateNegativeUsers {
    private UsersClient usersClient;
    private UsersService usersService;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
        usersService=new UsersService();
    }

    private void assertResponse(List<UserObjectErrorResponse> errorList, String field, String message){
        int size=errorList.stream()
                .filter(data-> data.getField().equals(field))
                .filter(data-> data.getMessage().equals(message))
                .collect(Collectors.toList())
                .size();
        Assert.assertEquals(size,1);
    }
    @Test
    public void createUserWithInvalidEmail(){
        UserObject requestBody= new UserObject.Builder()
                .email("aditi.raogmail.com")
                .build();
        Response response= usersClient.create(requestBody);
        List<UserObjectErrorResponse> errorList=usersService.createNegativeUser(requestBody);
        Assert.assertEquals(response.statusCode(),422);
        assertResponse(errorList,"email","is invalid");
    }

    @Test
    public void createUserWithBlankStatusAndGender(){
        UserObject requestBody=new UserObject.Builder()
                .gender("").status("")
                .build();
        Response response= usersClient.create(requestBody);
        List<UserObjectErrorResponse> errorList=usersService.createNegativeUser(requestBody);
        assertResponse(errorList,"gender","can't be blank, can be male or female");
        assertResponse(errorList,"status","can't be blank");
        Assert.assertEquals(response.statusCode(),422);
    }
}
