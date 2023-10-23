package com.example.week05homework.service;

import com.example.week05homework.entity.Task;
import com.example.week05homework.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * @PACKAGE_NAME: com.example.week05homework.service
 * @NAME: TaskService
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public List<Task> getAllTasks() {
        return taskMapper.getAllTasks();
    }

    public int addTask(Task task) {
        return taskMapper.insert(task);
    }

    public int updateTask(Task task) {
        return taskMapper.update(task);
    }

    public int deleteTask(long id) {
        return taskMapper.delete(id);
    }
}

