package com.krish.springjpamongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("employee-new")
public class Employee {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Double salary;
    private Date joiningDate;
}
