package com.kodilla.spring.forumuser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
    @SpringBootTest(classes = ForumUser.class)
    public class ForumTestSuite {
        @Test
        public void testGetUsername() {
            //Given
            ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
            ForumUser user = context.getBean(ForumUser.class);
            //When
            String name = user.getUserName();
            //Then
            assertEquals("John Smith", name);
        }
    }