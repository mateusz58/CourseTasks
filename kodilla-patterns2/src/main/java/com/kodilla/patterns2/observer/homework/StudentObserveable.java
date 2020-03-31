package com.kodilla.patterns2.observer.homework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentObserveable implements Observable {
    private  String surname;
    @Builder.Default
    private List<Observer> observers = new ArrayList<>();
    @Builder.Default
    private Map<String, String> homeworks = new HashMap<>();
    private  KodillaCourses courseName;

    public void addHomework(String homeworkNumber, String answer) {
        homeworks.put(homeworkNumber, answer);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}