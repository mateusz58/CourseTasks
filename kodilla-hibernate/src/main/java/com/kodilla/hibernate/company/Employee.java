package com.kodilla.hibernate.company;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "employees")
@NamedQuery(
        name = "Employee.findByLastName",
        query = "FROM Employee Where last_name = :last_name"
)
public final class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    @ManyToMany(mappedBy = "employees" ,fetch = FetchType.EAGER)
    private Collection<Company> companies;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
