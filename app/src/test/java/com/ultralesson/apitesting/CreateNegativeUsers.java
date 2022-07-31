package com.ultralesson.apitesting;

import com.ultralesson.apitesting.create.UserObject;
import com.ultralesson.apitesting.users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNegativeUsers {
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient=new UsersClient();
    }
    @Test
    public void createInvalidUser(){
        UserObject requestBody=UserObject.builder()
                .name("Aditi Rao").email("aditi.raogmail.com")
                .gender("male").status("active")
                .build();
        usersClient.createUsers(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("field[0]", Matchers.equalTo("email"))
                .body("message[0]",Matchers.equalTo("is invalid"));
    }
}
