package com.quruiqi.myadmin.monitor.rest;

import com.quruiqi.myadmin.monitor.domain.Logging;
import com.quruiqi.myadmin.monitor.service.query.LoggingQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:05
 **/
@RestController
@RequestMapping("api")
public class LoggingController {

    @Autowired
    private LoggingQueryService loggingQueryService;

    @GetMapping(value = "logs")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity getLogs(Logging logging, Pageable pageable){
        return new ResponseEntity(loggingQueryService.queryAll(logging,pageable), HttpStatus.OK);
    }
}
