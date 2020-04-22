package com.kodilla.patterns.factory.tasks;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {
    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task shopping = factory.completeTask(TaskFactory.SHOPPINGTASK);
        shopping.executeTask();

        //Then
        assertEquals("ShoppingTask", shopping.getTaskName());
        assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task painting = factory.completeTask(TaskFactory.PAINTINGTASK);
        painting.executeTask();

        //Then
        assertEquals("PaintingTask", painting.getTaskName());
        assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();

        //When
        Task driving = factory.completeTask(TaskFactory.DRIVINGTASK);
        driving.executeTask();

        //Then
        assertEquals("DrivingTask", driving.getTaskName());
        assertEquals(false, driving.isTaskExecuted());
    }
}
