package com.example.homework;

import lombok.Data;

/**
 * @PACKAGE_NAME: com.example.demo
 * @NAME: Task
 * @USER: jiang000
 * @DATE: 2023/9/27
 **/
@Data
public class Task {
    private long id;
    private String name;
    private boolean completed;

    public Task(long id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

}