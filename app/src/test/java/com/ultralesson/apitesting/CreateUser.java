package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.create.UserObject;
import com.ultralesson.apitesting.users.create.UserObjectResponse;
import com.ultralesson.apitesting.users.UsersService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;


public class CreateUser {
    private UsersService usersService;
    @BeforeClass
    public void beforeClass(){
        usersService=new UsersService();
    }
    @Test
    public void createMaleUser(){
        String email= UUID.randomUUID()+"@gmail.com";
        UserObject requestBody=new UserObject.Builder()
                .build();

        UserObjectResponse userObjectResponse = usersService.createUsers(requestBody);

        userObjectResponse.assertUser(requestBody);
    }

    @Test
    public void CreateFemaleUser(){
        String email=UUID.randomUUID()+"@gmail.com";
        UserObject requestBody=new UserObject.Builder()
                .gender("female")
                .build();

        UserObjectResponse userObjectResponse = usersService.createUsers(requestBody);

        userObjectResponse.assertUser(requestBody);
    }
}
