package com.krish.springjpamongodb.service;

import com.krish.springjpamongodb.entity.Employee;
import com.krish.springjpamongodb.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmp() {

        return employeeRepository.getAll();
    }

    public Employee addEmp(Employee employee) {

        employee.setJoiningDate(new Date());
        return employeeRepository.save(employee);
    }

    public Employee updateEmp(Employee employee) {
        return employeeRepository.update(employee);
    }

    public Employee deleteEmp(String id) {

        return employeeRepository.delete(id);
    }

    public List<Employee> getBySalary(Double salary) {
        return employeeRepository.getBySal(salary);
    }

    public List<Employee> getByFirstName(String firstName) {
        return employeeRepository.getByFirstName(firstName);
    }
}
