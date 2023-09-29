package com.quruiqi.myadmin.monitor.service;

import com.quruiqi.myadmin.monitor.domain.Logging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:05
 **/
public interface LoggingService {

    /**
     * 新增日志
     * @param joinPoint
     * @param logging
     */
    @Async
    void save(ProceedingJoinPoint joinPoint, Logging logging);
}
