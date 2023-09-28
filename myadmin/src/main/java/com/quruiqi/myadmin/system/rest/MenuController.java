package com.quruiqi.myadmin.system.rest;

import com.quruiqi.myadmin.system.service.MenuService;
import com.quruiqi.myadmin.system.service.query.MenuQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:01
 **/
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    private final MenuQueryService menuQueryService;

}
