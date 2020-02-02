package com.kodilla.hibernate.dao;

import com.kodilla.hibernate.company.Company;
import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Long> {

	@Query(nativeQuery = true)
	Collection<Company> findCompanyByLetters(@Param("ARGUMENT") String parameter);

	@Query(nativeQuery = true)
	Collection<Company> findCompanyByName(@Param("ARGUMENT") String parameter);
}