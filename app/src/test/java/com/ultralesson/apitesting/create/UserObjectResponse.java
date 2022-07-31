package com.ultralesson.apitesting.create;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserObjectResponse {
    private String name;
    private String email;
    private String gender;
    private String status;
    private int id;
    @Setter
    private int statusCode;
}
