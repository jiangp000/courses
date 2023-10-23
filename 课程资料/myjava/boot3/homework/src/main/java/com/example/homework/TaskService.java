package com.example.homework;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @PACKAGE_NAME: com.example.demo
 * @NAME: TaskService
 * @USER: jiang000
 * @DATE: 2023/9/27
 **/
@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public TaskService() {
        tasks.add(new Task(1, "Learn Spring Boot", false));
        tasks.add(new Task(2, "Finish Vue Project", true));
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

}
