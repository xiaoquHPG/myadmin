package com.quruiqi.myadmin.monitor.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @Author Lenovo
 * @Date 2023/9/29 10:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisVo {

    @NotBlank
    private String key;

    @NotBlank
    private String value;
}
