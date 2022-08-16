package com.krish.mongo.springembeddedmongo.service;

import com.krish.mongo.springembeddedmongo.entity.Employee;
import com.krish.mongo.springembeddedmongo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
        return employeeRepository.getAllEmp();
    }

    public Employee addEmp(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Employee updateEmp(Employee employee) {
        return employeeRepository.update(employee);
    }

    public String deleteEmp(String id) {
        return employeeRepository.delete(id);
    }
}
