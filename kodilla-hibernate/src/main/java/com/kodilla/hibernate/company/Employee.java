package com.kodilla.hibernate.company;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
@NamedQuery(
		name = "Employee.findByLastName",
		query = "FROM Employee Where last_name = :last_name"
)
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;

	@ManyToMany(mappedBy="employees")
	private List<Company> companies;

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public static final class Builder {

		private Long id;
		private String firstName;
		private String lastName;
		private List<Company> companies;

		private Builder() {
		}

		public static Builder anEmployee() {
			return new Builder();
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder companies(List<Company> companies) {
			this.companies = companies;
			return this;
		}

		public Employee build() {
			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setCompanies(companies);
			return employee;
		}
	}
}