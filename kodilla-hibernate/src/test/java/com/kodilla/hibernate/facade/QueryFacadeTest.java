package com.kodilla.hibernate.facade;

import com.kodilla.generators.EasyRandomConfigure;

import com.kodilla.hibernate.company.Company;
import com.kodilla.hibernate.company.Employee;
import com.kodilla.hibernate.dao.CompanyDao;
import com.kodilla.hibernate.dao.EmployeeDao;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.stream.Collectors;

import static com.kodilla.generators.EasyRandomConfigure.fillObject;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class QueryFacadeTest {

    @Autowired
    QueryFacade  queryFacade;

    @Autowired
     EmployeeDao employeeDao;

    @Autowired
    CompanyDao companyDao;

    @Test
    void getEmployeeLike() {
        //given
        Employee expected = fillObject(Employee.class);

        //when
        employeeDao.save(expected);
        Collection<Employee> actual = queryFacade.retrieveEmployeeLike(expected.getLastName());

        //then
        assertThat(actual.stream().map(s->s.getLastName()).collect(Collectors.toList()), contains(expected.getLastName()));
    }

    @Test
    void getCompanyLike() {
        //given
        Company expected = fillObject(Company.class);

        //when
        companyDao.save(expected);
        Collection<Company> actual = queryFacade.retrieveCompanyLike(expected.getCompanyName());

        //then
        assertThat(actual.stream().map(s-> s.getCompanyName()).collect(Collectors.toList()), contains(expected.getCompanyName()));
    }
}
