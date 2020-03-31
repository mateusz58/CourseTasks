package com.kodilla.hibernate.company;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "companies")
@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name = "Company.findCompanyByLetters",
                query = "SELECT * FROM companies WHERE substring(company_name,1,3) = :ARGUMENT",
                resultClass = Company.class),

        @NamedNativeQuery(
                name = "Company.findCompanyByName",
                query = "SELECT * FROM companies WHERE company_name LIKE :ARGUMENT",
                resultClass = Company.class)
}
)
public final class Company {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "company_name")
    private String companyName;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "employee_company",
            joinColumns = {@JoinColumn(name = "company_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")})
    private Collection<Employee> employees;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
