package com.quruiqi.myadmin.system.service;

import com.quruiqi.myadmin.system.domain.Permission;
import com.quruiqi.myadmin.system.service.dto.PermissionDTO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:04
 **/
@CacheConfig(cacheNames = "permission")
public interface PermissionService {

    /**
     * get
     * @param id
     * @return
     */
    @Cacheable(key = "#p0")
    PermissionDTO findById(long id);

    /**
     * create
     * @param resources
     * @return
     */
    @CacheEvict(allEntries = true)
    PermissionDTO create(Permission resources);

    /**
     * update
     * @param resources
     */
    @CacheEvict(allEntries = true)
    void update(Permission resources);

    /**
     * delete
     * @param id
     */
    @CacheEvict(allEntries = true)
    void delete(Long id);

    /**
     * permission tree
     * @return
     */
    @Cacheable(key = "'tree'")
    Object getPermissionTree(List<Permission> permissions);

    /**
     * findByPid
     * @param pid
     * @return
     */
    @Cacheable(key = "'pid:'+#p0")
    List<Permission> findByPid(long pid);

    /**
     * build Tree
     * @param permissionDTOS
     * @return
     */
    Object buildTree(List<PermissionDTO> permissionDTOS);
}
