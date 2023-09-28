package com.quruiqi.myadmin.system.repository;

import com.quruiqi.myadmin.system.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:00
 **/
public interface MenuRepository extends JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {
}
