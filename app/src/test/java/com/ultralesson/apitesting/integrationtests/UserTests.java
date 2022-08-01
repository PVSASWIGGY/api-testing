package com.ultralesson.apitesting.integrationtests;

import com.ultralesson.apitesting.users.create.UserObject;
import com.ultralesson.apitesting.users.get.UserObjectResponse;
import com.ultralesson.apitesting.users.UsersService;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserTests {
    @Test
    public void createAndGetUser(){
        String email= UUID.randomUUID()+"@gmail.com";
        UserObject user= new UserObject.Builder().build();
        int id= new UsersService().createUsers(user).getId();

        UserObjectResponse getUserObjectResponse=new UsersService().getUserResponse(id);
        getUserObjectResponse.assertUser(user);
      }

}
