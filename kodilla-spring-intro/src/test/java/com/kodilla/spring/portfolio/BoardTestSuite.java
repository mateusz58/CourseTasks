package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {BoardConfig.class,Board.class,TaskList.class})
@ExtendWith(SpringExtension.class)
class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        board.getToDoList().addTask("ToDoTask");
        board.getInProgressList().addTask("InProgressTask");
        board.getDoneList().addTask("DoneTask");

        //Then
        Assertions.assertEquals("DoneTask", board.getDoneList().getTasks().get(0));
        Assertions.assertEquals("ToDoTask", board.getToDoList().getTasks().get(0));
        Assertions.assertEquals("InProgressTask", board.getInProgressList().getTasks().get(0));
    }
}