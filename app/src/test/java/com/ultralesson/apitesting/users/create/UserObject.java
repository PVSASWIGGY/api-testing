package com.ultralesson.apitesting.users.create;

import lombok.Getter;

import java.util.UUID;

@Getter
public class UserObject {
    private String name;
    private String email;
    private String gender;
    private String status;

    public UserObject(Builder builder) {
        this.name= builder.name;
        this.email= builder.email;
        this.gender= builder.gender;
        this.status= builder.status;
    }

    public static class Builder{
        private String name;
        private String email;
        private String gender;
        private String status;

        public Builder(){
            this.name="dummy user";
            this.email= UUID.randomUUID()+"@gmail.com";
            this.gender="male";
            this.status="active";
        }

        public Builder gender(String gender){
            this.gender=gender;
            return this;
        }
        public Builder status(String status){
            this.status=status;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public UserObject build(){
            UserObject user=new UserObject(this);
            return user;
        }
    }
}
