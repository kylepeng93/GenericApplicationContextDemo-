package com.github.kylepeng93.controller;

import com.github.kylepeng93.common.CommonResponse;
import com.github.kylepeng93.dto.TaskUpdateRequest;
import com.github.kylepeng93.pojo.TaskPojo;
import com.github.kylepeng93.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 任务控制器
 * https://kylepeng93.github.io
 *
 * @author pengkai
 * @date 2021-08-11 下午10:26
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    private static Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/getTaskInfo")
    public CommonResponse<List<TaskPojo>> getTaskInfo(Integer id) {
        return CommonResponse.success(taskService.getTaskInfo(id));
    }

    @PostMapping("update")
    public CommonResponse<Boolean> updateTask(@RequestBody TaskUpdateRequest request){
        return CommonResponse.success(taskService.updateTask(request));
    }
}
