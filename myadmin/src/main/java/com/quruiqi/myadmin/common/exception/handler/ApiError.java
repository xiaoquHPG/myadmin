package com.quruiqi.myadmin.common.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author Lenovo
 * @Date 2023/9/26 21:23
 **/
@Data
public class ApiError {


    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
