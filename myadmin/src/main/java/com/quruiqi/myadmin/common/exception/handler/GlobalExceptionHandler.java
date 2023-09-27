package com.quruiqi.myadmin.common.exception.handler;

import com.quruiqi.myadmin.common.exception.BadRequestException;
import com.quruiqi.myadmin.common.exception.EntityExistException;
import com.quruiqi.myadmin.common.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * @Author Lenovo
 * @Date 2023/9/27 21:10
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ApiError> badRequestException(BadRequestException e) {
        log.error(e.getMessage());
        return buildResponseEntity(new ApiError(BAD_REQUEST.value(), e.getMessage()));
    }

    /**
     * 处理实体类存在
     * @param e
     * @return
     */
    @ExceptionHandler(value = EntityExistException.class)
    public ResponseEntity<ApiError> entityExistException(EntityExistException e) {
        log.error(e.getMessage());
        return buildResponseEntity(new ApiError(BAD_REQUEST.value(), e.getMessage()));
    }

    /**
     * 处理实体类不存在异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFoundException(EntityNotFoundException e) {
        log.error(e.getMessage());
        return buildResponseEntity(new ApiError(BAD_REQUEST.value(), e.getMessage()));
    }

    private ResponseEntity<ApiError> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity(apiError, HttpStatus.valueOf(apiError.getStatus()));
    }

}
