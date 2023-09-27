package com.quruiqi.myadmin.common.mapper;

import java.util.List;

/**
 * @Author Lenovo
 * @Date 2023/9/27 21:20
 **/
public interface EntityMapper<M, E> {

    /**
     * dto转换为entity
     * @param dto
     * @return
     */
    E toEntity(M dto);

    /**
     * entity转换为dto
     * @param entity
     * @return
     */
    M toDto(E entity);

    /**
     * dto集合转换为entity集合
     * @param dto
     * @return
     */
    List<E> toEntity(List<M> dto);

    /**
     * entity集合转换为dto集合
     * @param entity
     * @return
     */
    List<M> toDto(List<E> entity);

}
