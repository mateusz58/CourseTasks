package com.kodilla.hibernate.dao;

import com.kodilla.hibernate.company.Employee;
import java.util.Collection;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	@Query
	Collection<Employee> findByLastName(@Param("last_name") String last_name );
}
