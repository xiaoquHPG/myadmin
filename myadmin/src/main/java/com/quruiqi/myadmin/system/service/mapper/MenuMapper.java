package com.quruiqi.myadmin.system.service.mapper;

import com.quruiqi.myadmin.common.mapper.EntityMapper;
import com.quruiqi.myadmin.system.domain.Menu;
import com.quruiqi.myadmin.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:03
 **/
@Mapper(componentModel = "spring", uses = {RoleMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {
}
