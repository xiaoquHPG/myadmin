package com.quruiqi.myadmin.monitor.service;

import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:06
 **/
public interface VisitsService {

    /**
     * 新增记录
     * @param request
     */
    @Async
    void save(HttpServletRequest request);

    /**
     * 获取数据
     * @return
     */
    Object get();

    /**
     * getChartData
     * @return
     */
    Object getChartData();
}
