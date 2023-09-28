package com.quruiqi.myadmin.system.service.mapper;

import com.quruiqi.myadmin.common.mapper.EntityMapper;
import com.quruiqi.myadmin.system.domain.Permission;
import com.quruiqi.myadmin.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:04
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {
}
