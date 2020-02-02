package com.kodilla.spring.portfolio;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Getter
public final class TaskList {
    private final List<String> tasks;

    @Autowired
    public TaskList() {
        tasks = new LinkedList<>();
    }

    void addTask(String task) {
        tasks.add(task);
    }
}