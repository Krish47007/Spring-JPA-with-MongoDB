package com.krish.springjpamongrepository.service;


import com.krish.springjpamongrepository.entity.Employee;
import com.krish.springjpamongrepository.repository.EmployeeRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmp() {

        return employeeRepository.getAllEmp();
    }

    public Employee addEmp(Employee employee) {

        employee.setJoiningDate(new Date());
        return employeeRepository.save(employee);
    }

    public Employee updateEmp(Employee employee) {
       return employeeRepository.save(employee);
    }

    public void deleteEmp(String id) {
        employeeRepository.deleteById(id);
    }

    public Map<String,Object> getAllEmpByPage(int pageNum, int pageSize, String sortBy) {

        Map<String,Object> response = new LinkedHashMap<>();
        Pageable page = PageRequest.of(pageNum,pageSize, Sort.by(sortBy));

        Page<Employee> data = employeeRepository.findAll(page);

        response.put("totalRecordCount",data.getTotalElements());
        response.put("totalPageCount",data.getTotalPages());
        response.put("currentPage",data.getNumber() + 1);
        response.put("data",data.getContent());

        return response;
    }

    public List<Employee> getByFirstName(String firstName) {

        Employee employee = new Employee();
        employee.setFirstName(firstName);

        Example example = Example.of(employee);
        return employeeRepository.findAll(example);
    }

    public List<Employee> getByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public List<Employee> getByZipCode(int zipcode) {
        return employeeRepository.findByAddressZipCode(zipcode);
    }

    public List<Employee> getBySalary(int salary) {

        return employeeRepository.employessWithSalary(salary);
    }

   /* public Employee updateEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee deleteEmp(String id) {

        return employeeRepository.deleteById(id);
    }

    public List<Employee> getBySalary(Double salary) {
        return employeeRepository.getBySal(salary);
    }

    public List<Employee> getByFirstName(String firstName) {
        return employeeRepository.getByFirstName(firstName);
    }*/
}
