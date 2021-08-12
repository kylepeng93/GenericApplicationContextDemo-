package com.github.kylepeng93.service.impl;

import com.github.kylepeng93.dto.TaskUpdateRequest;
import com.github.kylepeng93.mapper.TaskMapper;
import com.github.kylepeng93.pojo.TaskPojo;
import com.github.kylepeng93.service.TaskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * 任务相关服务实现类
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:34
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override

    public TaskPojo getTaskInfo(Integer id) {
        return taskMapper.getTaskInfo(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateTask(TaskUpdateRequest request) {
        boolean result = false;
        TaskPojo taskPojo = new TaskPojo();
        BeanUtils.copyProperties(request, taskPojo);
        if (Objects.isNull(request.getId())) {
            // 插入的场合
            if(taskMapper.insert(taskPojo) > 0) {
                result = true;
            }
        } else {
            // 更新的场合
            if (taskMapper.updateById(taskPojo) > 0) {
                result = true;
            }
        }
        return result;
    }
}
