package com.github.kylepeng93.mapper;

import com.github.kylepeng93.pojo.TaskPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务相关的数据访问接口
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:35
 */
public interface TaskMapper {
    int insert(TaskPojo taskPojo);

    int updateById(TaskPojo taskPojo);

    List<TaskPojo> getTaskInfo(@Param("id") Integer id);
}
