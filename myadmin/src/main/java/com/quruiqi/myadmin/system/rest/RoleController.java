package com.quruiqi.myadmin.system.rest;

import com.quruiqi.myadmin.system.service.RoleService;
import com.quruiqi.myadmin.system.service.query.RoleQueryService;
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
public class RoleController {

    private final RoleService roleService;

    private final RoleQueryService roleQueryService;

}
