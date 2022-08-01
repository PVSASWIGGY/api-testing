package com.ultralesson.apitesting.users;

import com.ultralesson.apitesting.users.create.UserObject;
import com.ultralesson.apitesting.users.create.UserObjectErrorResponse;
import com.ultralesson.apitesting.users.create.UserObjectResponse;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsersService {
    public UserObjectResponse createUsers(UserObject userInfo) {
        Response response= new UsersClient().create(userInfo);
        UserObjectResponse userObjectResponse=response.as(UserObjectResponse.class);
        userObjectResponse.setStatusCode(response.statusCode());
        return userObjectResponse;

    }

    public List<UserObjectErrorResponse> createNegativeUser(UserObject userInfo){
        Response response=new UsersClient().create(userInfo);
        List<UserObjectErrorResponse> errorList= Arrays.stream(response.as(UserObjectErrorResponse[].class)).collect(Collectors.toList());
        return errorList;
    }

    public List<com.ultralesson.apitesting.users.get.UserObjectResponse> getUserObjectResponse(Response response) {
        List<com.ultralesson.apitesting.users.get.UserObjectResponse> dataList=Arrays.stream(response.as(com.ultralesson.apitesting.users.get.UserObjectResponse[].class)).collect(Collectors.toList());
        return dataList;
    }

    public com.ultralesson.apitesting.users.get.UserObjectResponse getUserResponse(int id){
        Response response=new UsersClient().getUser(id);
        return response.as(com.ultralesson.apitesting.users.get.UserObjectResponse.class);
    }
}
