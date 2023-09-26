package com.quruiqi.myadmin.common.exception;


/**
 * @Author Lenovo
 * @Date 2023/9/26 21:50
 **/
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

}
