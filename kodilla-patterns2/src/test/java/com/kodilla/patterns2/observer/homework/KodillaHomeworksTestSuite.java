package com.kodilla.patterns2.observer.homework;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KodillaHomeworksTestSuite {

    @Test
    public void testUpdateHomeworks(){
        //Given
        StudentObserveable student = StudentObserveable.builder().courseName(KodillaCourses.Java_Developer).surname("student").build();
        StudentObserveable student2 = StudentObserveable.builder().courseName(KodillaCourses.Java_Developer).surname("student2").build();

        MentorObserver mentor = MentorObserver.builder().mentorName("Mentor").build();
        MentorObserver mentor2 = MentorObserver.builder().mentorName("Mentor2").build();

        student.registerObserver(mentor);
        student2.registerObserver(mentor2);

        //When
        student.addHomework("6.4", "ShapeCollector");
        student2.addHomework("6.4", "ShapeCollector2");

        //Then
        assertEquals(1,mentor.getUpdateCount());
        assertEquals(1,mentor2.getUpdateCount());
    }
}