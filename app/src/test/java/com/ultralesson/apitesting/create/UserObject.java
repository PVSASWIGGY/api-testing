package com.ultralesson.apitesting.create;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserObject {
    private String name;
    private String email;
    private String gender;
    private String status;
}
