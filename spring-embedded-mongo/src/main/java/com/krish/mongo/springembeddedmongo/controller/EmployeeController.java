package com.krish.mongo.springembeddedmongo.controller;

import com.krish.mongo.springembeddedmongo.entity.Employee;
import com.krish.mongo.springembeddedmongo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.addEmp(employee),HttpStatus.CREATED);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.updateEmp(employee),HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id)
    {
        return new ResponseEntity<>(employeeService.deleteEmp(id),HttpStatus.OK);
    }

}
