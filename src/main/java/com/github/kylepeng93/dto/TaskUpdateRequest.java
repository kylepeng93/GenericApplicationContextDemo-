package com.github.kylepeng93.dto;

import lombok.Data;

/**
 * 更新请求
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-12 下午10:56
 */
@Data
public class TaskUpdateRequest {
    private Integer id;

    private String subject;

    private String description;
}
