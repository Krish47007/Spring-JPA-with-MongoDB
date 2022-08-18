package com.krish.springjpamongodb.controller;

import com.krish.springjpamongodb.entity.Employee;
import com.krish.springjpamongodb.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmp());
    }

    @PostMapping("/")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmp(employee));
    }

    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmp(employee));
    }

    @DeleteMapping("/")
    public ResponseEntity<Employee> deleteEmployee(@PathParam("id") String id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteEmp(id));
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalary(@PathParam("salary") Double salary)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalary(salary));
    }

    @GetMapping("/first-name")
    public ResponseEntity<List<Employee>> getAllEmployeesByFirstNameMatching(@PathParam("firstName") String firstName)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByFirstName(firstName));
    }
}
