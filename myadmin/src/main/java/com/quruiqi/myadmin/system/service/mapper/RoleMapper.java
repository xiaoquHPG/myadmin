package com.quruiqi.myadmin.system.service.mapper;

import com.quruiqi.myadmin.common.mapper.EntityMapper;
import com.quruiqi.myadmin.system.domain.Role;
import com.quruiqi.myadmin.system.service.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:04
 **/
@Mapper(componentModel = "spring", uses = {PermissionMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends EntityMapper<RoleDTO, Role> {
}
