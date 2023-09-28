package com.quruiqi.myadmin.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:02
 **/
@Data
public class MenuDTO {

    private Long id;

    private String name;

    private Long soft;

    private String path;

    private String component;

    private Long pid;

    private Boolean iFrame;

    private String icon;

    private Set<RoleDTO> roles;

    private List<MenuDTO> children;

    private Timestamp createTime;
}