package com.kodilla.hibernate.company;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
public class Company {

	public Company(String companyName) {
		this.companyName = companyName;
	}

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private String companyName;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_company",
			joinColumns = {@JoinColumn(name = "company_id")},
			inverseJoinColumns = {@JoinColumn(name = "employee_id")})
	private Collection<Employee> employees;

	public static final class Builder {

		private Long id;
		private String name;
		private Collection<Employee> employees;

		private Builder() {
		}

		public static Builder aCompany() {
			return new Builder();
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder employees(Collection<Employee> employees) {
			this.employees = employees;
			return this;
		}

		public Company build() {
			Company company = new Company();
			company.setId(id);
			company.setCompanyName(name);
			company.setEmployees(employees);
			return company;
		}
	}
}
