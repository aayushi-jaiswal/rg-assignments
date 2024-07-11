package com.aayushi.employeecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aayushi.employeecrud.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
