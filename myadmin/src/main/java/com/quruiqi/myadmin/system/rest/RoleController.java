package com.quruiqi.myadmin.system.rest;

import com.quruiqi.myadmin.common.aop.log.Log;
import com.quruiqi.myadmin.common.exception.BadRequestException;
import com.quruiqi.myadmin.system.domain.Role;
import com.quruiqi.myadmin.system.service.RoleService;
import com.quruiqi.myadmin.system.service.dto.RoleDTO;
import com.quruiqi.myadmin.system.service.query.RoleQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:01
 **/
@RestController
@RequestMapping("api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleQueryService roleQueryService;

    private static final String ENTITY_NAME = "role";

    @GetMapping(value = "/roles/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','ROLE_SELECT')")
    public ResponseEntity getRoles(@PathVariable Long id){
        return new ResponseEntity(roleService.findById(id), HttpStatus.OK);
    }

    /**
     * 返回全部的角色，新增用户时下拉选择
     * @return
     */
    @GetMapping(value = "/roles/tree")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','USER_ALL','USER_ADD','USER_EDIT')")
    public ResponseEntity getRoleTree(){
        return new ResponseEntity(roleService.getRoleTree(),HttpStatus.OK);
    }

    @Log(description = "查询角色")
    @GetMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','ROLE_SELECT')")
    public ResponseEntity getRoles(RoleDTO resources, Pageable pageable){
        return new ResponseEntity(roleQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log(description = "新增角色")
    @PostMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','ROLE_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Role resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(roleService.create(resources),HttpStatus.CREATED);
    }

    @Log(description = "修改角色")
    @PutMapping(value = "/roles")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','ROLE_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Role resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        roleService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log(description = "删除角色")
    @DeleteMapping(value = "/roles/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','ROLE_ALL','ROLE_DELETE')")
    public ResponseEntity delete(@PathVariable Long id){
        roleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

