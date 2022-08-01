package com.ultralesson.apitesting.users.create;

import lombok.Getter;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserObjectErrorResponse {
    private String field;
    private String message;
}
