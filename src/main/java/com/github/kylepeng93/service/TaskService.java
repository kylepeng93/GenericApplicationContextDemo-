package com.github.kylepeng93.service;

import com.github.kylepeng93.dto.TaskUpdateRequest;
import com.github.kylepeng93.pojo.TaskPojo;

/**
 * 任务相关服务接口
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:32
 */
public interface TaskService {
    /**
     * 根据id获取task信息
     * @param id
     * @return
     */
    TaskPojo getTaskInfo(Integer id);

    /**
     * 条件更新或者插入task表
     * @param request
     * @return
     */
    Boolean updateTask(TaskUpdateRequest request);
}
