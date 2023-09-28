package com.quruiqi.myadmin.core.security;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Lenovo
 * @Date 2023/9/28 10:24
 **/
@Getter
@Setter
public class AuthenticationUser {

    private String username;

    private String password;

    @Override
    public String toString() {
        return "AuthenticationUser{" +
                "username='" + username + '\'' +
                ", password='" + "********" + '\'' +
                '}';
    }
}
