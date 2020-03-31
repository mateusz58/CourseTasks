package com.kodilla.hibernate.facade;

import com.kodilla.hibernate.company.Company;
import com.kodilla.hibernate.company.Employee;
import com.kodilla.hibernate.dao.CompanyDao;
import com.kodilla.hibernate.dao.EmployeeDao;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QueryFacade {

    private CompanyDao companyDao;

    private EmployeeDao employeeDao;

    public QueryFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public Collection<Company> retrieveCompanyLike(String fragmentOfTheName) {
        return companyDao.findCompanyByLetters(fragmentOfTheName);
    }

    public Collection<Employee> retrieveEmployeeLike(String fragmentOfTheName){
        return employeeDao.findByLastName(fragmentOfTheName);
    }
}
