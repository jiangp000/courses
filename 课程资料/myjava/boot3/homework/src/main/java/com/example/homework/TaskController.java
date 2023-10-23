package com.example.homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PACKAGE_NAME: com.example.demo
 * @NAME: TaskController
 * @USER: jiang000
 * @DATE: 2023/9/27
 **/
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public CommonResult<?> getAllTasks() {
        return CommonResult.success(taskService.getAllTasks());
    }
}