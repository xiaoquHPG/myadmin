package com.quruiqi.myadmin.system.rest;

import com.quruiqi.myadmin.system.service.UserService;
import com.quruiqi.myadmin.system.service.query.UserQueryService;
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
public class UserController {

    private final UserService userService;

    private final UserQueryService userQueryService;

}
