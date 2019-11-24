package com.in.opalina.dao;

import org.springframework.data.repository.CrudRepository;

import com.in.opalina.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{

}
