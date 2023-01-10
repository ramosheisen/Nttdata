package com.nttdata.backend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nttdata.backend.entitys.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {

	@Query(value = "SELECT e.id, e.type_document, e.document, e.first_name, e.second_name, e.first_last_name, "
			+ "			   e.second_last_name, e.phone, e.address, e.city "
			+ " FROM employee e "
			+ " WHERE e.type_document = :type_document AND e.document = :document", nativeQuery = true)
    public Employee validateEmployee(String type_document, String document);
	
}
