package com.quruiqi.myadmin.system.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * @Author Lenovo
 * @Date 2023/9/28 10:59
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MenuVO {

    private String name;

    private String path;

    private String component;

    private Boolean alwaysShow;

    private MenuMetaVO meta;

    private List<MenuVO> children;
}
