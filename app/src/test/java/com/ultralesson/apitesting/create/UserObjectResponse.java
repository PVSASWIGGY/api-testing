package com.ultralesson.apitesting.create;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class UserObjectResponse {
    private String name;
    private String email;
    private String gender;
    private String status;
    private int id;
    @Setter
    private int statusCode;

    public void assertUser(UserObject requestBody) {
        Assert.assertEquals(this.getStatusCode(),201);
        Assert.assertNotNull(this.getId());
        Assert.assertEquals(this.getEmail(),requestBody.getEmail());
        Assert.assertEquals(this.getName(),requestBody.getName());
        Assert.assertEquals(this.getGender(),requestBody.getGender());
        Assert.assertEquals(this.getStatus(),requestBody.getStatus());

    }
}
