package com.krish.springjpamongrepository.repository;

import com.krish.springjpamongrepository.entity.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {

    List<Employee> findByLastName(String lastName);

    List<Employee> findByAddressZipCode(int zipCode);

    @Query(value = "{'salary' : {$gte : ?0}}",fields = "{ 'firstName' : 1, 'lastName' : 1, 'id' : 1 }")
    List<Employee> employessWithSalary(int salary); //here function name doesn't matter for @Query annotated methods

    @Query(value = "{'id' : {$ne : null}}",fields = "{ 'address' : 0}",sort = "{ 'firstName' : 1}")
    List<Employee> getAllEmp();

}
