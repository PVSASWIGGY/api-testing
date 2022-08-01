package com.ultralesson.apitesting.users.get;

import com.ultralesson.apitesting.users.create.UserObject;
import lombok.Getter;
import org.testng.Assert;

@Getter
public class UserObjectResponse {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public void assertUser(UserObject user) {
        Assert.assertEquals(this.name,user.getName());
        Assert.assertEquals(this.email,user.getEmail());
        Assert.assertEquals(this.gender,user.getGender());
        Assert.assertEquals(this.status,user.getStatus());
    }
}
