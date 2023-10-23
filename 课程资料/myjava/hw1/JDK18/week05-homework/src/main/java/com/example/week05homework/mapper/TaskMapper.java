package com.example.week05homework.mapper;

import com.example.week05homework.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import java.util.*;

@Mapper
public interface TaskMapper {
    List<Task> getAllTasks();
    int insert(Task task);
    int update(Task task);
    int delete(long id);
}
