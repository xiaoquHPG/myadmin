package com.quruiqi.myadmin.core.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @Author Lenovo
 * @Date 2023/9/28 10:23
 **/
@Getter
@AllArgsConstructor
public class AuthenticationToken implements Serializable {

    private static final long serialVersionUID = 7392891230445734907L;

    private final String token;

}
