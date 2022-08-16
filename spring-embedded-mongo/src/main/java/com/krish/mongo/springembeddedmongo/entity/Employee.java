package com.krish.mongo.springembeddedmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private Double salary;

}
