package com.aayushi.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aayushi.crud.model.Employee;
import com.aayushi.crud.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> getEmployees() {
		return repository.findAll();
	}

	public Employee getEmployeeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public String deleteEmployee(int id) {
		repository.deleteById(id);
		return "Employee removed !! " + id;
	}

	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		if (existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setDepartment(employee.getDepartment());
			return repository.save(existingEmployee);
		} else {
			return null;
		}
	}
}
