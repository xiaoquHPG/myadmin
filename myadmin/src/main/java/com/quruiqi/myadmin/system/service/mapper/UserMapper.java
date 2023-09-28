package com.quruiqi.myadmin.system.service.mapper;

import com.quruiqi.myadmin.common.mapper.EntityMapper;
import com.quruiqi.myadmin.system.domain.User;
import com.quruiqi.myadmin.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:04
 **/
@Mapper(componentModel = "spring", uses = {RoleMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
