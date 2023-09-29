package com.quruiqi.myadmin.system.repository;

import com.quruiqi.myadmin.system.domain.Menu;
import com.quruiqi.myadmin.system.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Set;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:00
 **/
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor {

    /**
     * findByName
     * @param name
     * @return
     */
    Menu findByName(String name);

    /**
     * findByRoles
     * @param roleSet
     * @return
     */
    Set<Menu> findByRoles(Set<Role> roleSet);

    /**
     * findByPid
     * @param pid
     * @return
     */
    List<Menu> findByPid(long pid);
}