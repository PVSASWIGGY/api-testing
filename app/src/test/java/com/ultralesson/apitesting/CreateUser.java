package com.ultralesson.apitesting;

import com.ultralesson.apitesting.create.UserObject;
import com.ultralesson.apitesting.create.UserObjectResponse;
import com.ultralesson.apitesting.users.UsersClient;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;


public class CreateUser {
    private UsersClient usersClient;
    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void createMaleUser(){
        String email= UUID.randomUUID()+"@gmail.com";
        UserObject requestBody=UserObject.builder()
                .name("Tenali Ramakrishna").email(email)
                .gender("male").status("active")
                .build();

        UserObjectResponse userObjectResponse = usersClient.createUsers(requestBody);

        userObjectResponse.assertUser(requestBody);
    }

    @Test
    public void CreateFemaleUser(){
        String email=UUID.randomUUID()+"@gmail.com";
        UserObject requestBody=UserObject.builder()
                .name("Aditi Rao").email(email)
                .gender("female").status("active")
                .build();

        UserObjectResponse userObjectResponse = usersClient.createUsers(requestBody);

        userObjectResponse.assertUser(requestBody);
    }
}
