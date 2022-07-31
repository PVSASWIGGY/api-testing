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
        String name="Aditi Rao";
        String email="aditi.raogmail.com";
        String gender="male";
        String status="active";
        String body = "{\n" +
                "    \"name\":" +name+"\"\",\n" +
                "    \"gender\":" +gender+"\",\n" +
                "    \"email\":"+email+",\n" +
                "    \"status\":"+status+ "\"\n" +
                "}";
        UserObject requestBody=new UserObject(name,email,gender,status);
        usersClient.createUsers(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("field[0]", Matchers.equalTo("email"))
                .body("message[0]",Matchers.equalTo("is invalid"));
    }
}
