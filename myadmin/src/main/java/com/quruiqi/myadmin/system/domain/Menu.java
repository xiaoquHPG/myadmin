package com.quruiqi.myadmin.system.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @Author Lenovo
 * @Date 2023/9/28 10:59
 **/
@Entity
@Getter
@Setter
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(unique = true)
    private Long soft;

    @Column(name = "path")
    private String path;

    private String component;

    private String icon;

    /**
     * 上级菜单ID
     */
    @Column(name = "pid",nullable = false)
    private Long pid;

    /**
     * 是否为外链 true/false
     */
    private Boolean iFrame;

    @ManyToMany
    @JoinTable(name = "menus_roles", joinColumns = {@JoinColumn(name = "menu_id",referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")})
    private Set<Role> roles;

    @CreationTimestamp
    private Timestamp createTime;
}