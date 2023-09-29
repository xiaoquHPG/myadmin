package com.quruiqi.myadmin.system.service;

import com.quruiqi.myadmin.system.domain.Role;
import com.quruiqi.myadmin.system.service.dto.RoleDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:04
 **/
@CacheConfig(cacheNames = "role")
public interface RoleService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    RoleDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    RoleDTO create(Role resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Role resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * role tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getRoleTree();
}
