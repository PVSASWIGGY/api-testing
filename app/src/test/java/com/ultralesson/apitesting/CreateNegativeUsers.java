package com.ultralesson.apitesting;

import com.ultralesson.apitesting.users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateNegativeUsers {
    @Test
    public void createInvalidUser(){
        String body = "{\n" +
                "    \"name\": \"Aditi Rao\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"email\": \"aditi.raogmail.com\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClient().createUsers(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("field[0]", Matchers.equalTo("email"))
                .body("message[0]",Matchers.equalTo("is invalid"));
    }
}
