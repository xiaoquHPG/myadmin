package com.quruiqi.myadmin.system.rest;

import com.quruiqi.myadmin.system.service.PermissionService;
import com.quruiqi.myadmin.system.service.query.PermissionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:01
 **/
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    private final PermissionQueryService permissionQueryService;

}
