package com.example.week05homework.controller;

import com.example.week05homework.CommonResult;
import com.example.week05homework.entity.Task;
import com.example.week05homework.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @PACKAGE_NAME: com.example.week05homework.controller
 * @NAME: TaskController
 * @USER: jiang000
 * @DATE: 2023/10/12
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
    @PostMapping("/tasks")
    public CommonResult<?> addTask(@RequestBody Task task) {
        return CommonResult.success(taskService.addTask(task));
    }

    @PutMapping("/tasks/{id}")
    public CommonResult<?> updateTask(@PathVariable long id, @RequestBody Task task) {
        task.setId(id);
        return CommonResult.success(taskService.updateTask(task));
    }
    @DeleteMapping("/tasks/{id}")
    public CommonResult<?> deleteTask(@PathVariable long id) {
        return CommonResult.success(taskService.deleteTask(id));
    }
    @GetMapping("**")
    public String indexPage(){
        return "index page";
    }


}
