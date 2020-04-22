package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Board extends Prototype {
    private Set<TaskList> taskLists = new HashSet<>();
    private final String name;

    public Board(final String name) {
        this.name = name;
    }

    public void addTaskList(TaskList taskList) {
        taskLists.add(taskList);
    }

    public boolean removeTaskList(TaskList taskList) {
        return taskLists.remove(taskList);
    }

    public List<TaskList> getTaskLists() {
        return new ArrayList<>(taskLists);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Board{" + "\n" +
            "companyName='" + name + '\'' + ",\n" +
            "taskLists=" + taskLists + "\n" +
            '}';
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }
    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board) super.clone();
        clonedBoard.taskLists = new HashSet<>();
        for (TaskList theList : taskLists) {
            TaskList clonedList = new TaskList(theList.getName());
            for (Task task : theList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            clonedBoard.getTaskLists().add(clonedList);
        }
        return clonedBoard;
    }
}