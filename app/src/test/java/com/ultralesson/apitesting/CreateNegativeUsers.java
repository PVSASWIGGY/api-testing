package com.ultralesson.apitesting;

import com.ultralesson.apitesting.create.UserObjectErrorResponse;
import com.ultralesson.apitesting.create.UserObject;
import com.ultralesson.apitesting.users.UsersClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateNegativeUsers {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
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
        UserObject requestBody=UserObject.builder()
                .name("Aditi Rao").email("aditi.raogmail.com")
                .gender("male").status("active")
                .build();
        Response response= usersClient.create(requestBody);
        List<UserObjectErrorResponse> errorList=usersClient.createNegativeUser(requestBody);
        Assert.assertEquals(response.statusCode(),422);
        assertResponse(errorList,"email","is invalid");
    }

    @Test
    public void createUserWithBlankStatusAndGender(){
        UserObject requestBody=UserObject.builder()
                .name("Aditi Rao").email("aditi.rao23@gmail.com")
                .gender("").status("")
                .build();
        Response response= usersClient.create(requestBody);
        List<UserObjectErrorResponse> errorList=usersClient.createNegativeUser(requestBody);
        assertResponse(errorList,"gender","can't be blank, can be male or female");
        assertResponse(errorList,"status","can't be blank");
        Assert.assertEquals(response.statusCode(),422);
    }
}
