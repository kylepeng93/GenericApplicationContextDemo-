package com.github.kylepeng93.pojo;

import lombok.Data;

/**
 * 任务pojo
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:30
 */
@Data
public class TaskPojo {
    private Integer id;

    private String subject;

    private String startDate;

    private String endDate;

    private String description;
}
