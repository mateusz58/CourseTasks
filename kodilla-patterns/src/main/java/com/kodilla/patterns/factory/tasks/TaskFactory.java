package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";

    public final Task completeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPINGTASK:
                return new ShoppingTask("ShoppingTask", "Random",1);
            case PAINTINGTASK:
                return new PaintingTask("PaintingTask", "Random", "Random");
            case DRIVINGTASK:
                return new DrivingTask("DrivingTask", "Random", "Random");
            default:
                return null;
        }
    }
}
