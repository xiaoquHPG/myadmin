package com.quruiqi.myadmin.system.repository;

import com.quruiqi.myadmin.system.domain.Permission;
import com.quruiqi.myadmin.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:00
 **/
public interface PermissionRepository extends JpaRepository<Permission, Long>, JpaSpecificationExecutor<Permission> {

    /**
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Permission> findByRoles(Set<Role> roleSet);

}
