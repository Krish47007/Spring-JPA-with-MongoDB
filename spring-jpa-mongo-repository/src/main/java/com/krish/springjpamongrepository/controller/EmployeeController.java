package com.krish.springjpamongrepository.controller;

import com.krish.springjpamongrepository.entity.Employee;
import com.krish.springjpamongrepository.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

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
        employeeService.deleteEmp(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Map<String,Object>> getAllEmployeesByPage(@RequestParam(value = "pageNum",defaultValue = "0") int pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "20")int pageSize,
                                                     @RequestParam(value = "sortBy",defaultValue = "id") String sortBy)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAllEmpByPage(pageNum,pageSize,sortBy));
    }
/*
    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalary(@PathParam("salary") Double salary)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalary(salary));
    }
*/
    @GetMapping("/first-name")
    public ResponseEntity<List<Employee>> getAllEmployeesByFirstNameMatching(@PathParam("firstName") String firstName)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByFirstName(firstName));
    }

    @GetMapping("/last-name")
    public ResponseEntity<List<Employee>> getAllEmployeesByLastNameMatching(@PathParam("lastName") String lastName)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByLastName(lastName));
    }

    @GetMapping("/zipcode")
    public ResponseEntity<List<Employee>> getAllEmployeesByZipcode(@PathParam("zipcode") int zipcode)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByZipCode(zipcode));
    }

    @GetMapping("/salary")
    public ResponseEntity<List<Employee>> getAllEmployeesBySalary(@PathParam("salary") int salary)
    {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getBySalary(salary));
    }
}
