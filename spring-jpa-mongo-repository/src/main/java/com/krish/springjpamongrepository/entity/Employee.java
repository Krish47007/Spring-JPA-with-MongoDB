package com.krish.springjpamongrepository.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("employee-mongo-repo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Double salary;
    private Date joiningDate;
}
