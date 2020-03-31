package com.kodilla.hibernate.tasklist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TASKLISTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class TaskList {

    @Id
    @GeneratedValue
    private int id;
    private String listName;
    private String description;
}