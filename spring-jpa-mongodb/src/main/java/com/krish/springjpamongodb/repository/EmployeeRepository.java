package com.krish.springjpamongodb.repository;

import com.krish.springjpamongodb.entity.Employee;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

@Repository
public class EmployeeRepository {

    private final MongoTemplate mongoTemplate;

    public EmployeeRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Employee> getAll() {

        return mongoTemplate.findAll(Employee.class,"employee-new");
    }

    public Employee save(Employee employee) {

        return mongoTemplate.save(employee);

    }

    public Employee update(Employee employee) {
        /*
            save() in MongoTemplate is upsert. If a matching record
            exists, it updates it else inserts a new record
         */
        return mongoTemplate.save(employee);
    }

    public Employee delete(String id) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.findAndRemove(query,Employee.class);
    }

    public List<Employee> getBySal(Double salary) {

        Query query = new Query(Criteria.where("salary").gt(salary));
        query.fields().exclude("address");
        return mongoTemplate.find(query,Employee.class);
    }

    public List<Employee> getByFirstName(String firstName) {

        //All the values starting with firstName
        Query query = new Query(Criteria.where("firstName").regex(Pattern.compile("^"+firstName,Pattern.CASE_INSENSITIVE)));
        return mongoTemplate.find(query,Employee.class);
    }
}

