package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MentorObserver implements Observer {
    private String mentorName;
    private int updateCount;

    public MentorObserver(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentObserveable student) {
        Map<String, String> homework = student.getHomeworks();
        String lastKey = "";
        for (String entry : homework.keySet()) {
            lastKey=entry;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Student ");
        sb.append(student.getSurname());
        sb.append(" from ");
        sb.append(student.getCourseName());
        sb.append(" course send new homework:\n");
        sb.append(lastKey);
        System.out.println(sb);
        updateCount++;
    }
}
