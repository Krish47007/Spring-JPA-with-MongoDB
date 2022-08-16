package com.krish.mongo.springembeddedmongo.repository;

import com.krish.mongo.springembeddedmongo.entity.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Repository
public class EmployeeRepository {

    private final MongoClient mongoClient;

    public EmployeeRepository(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public List<Employee> getAllEmp() {

        MongoDatabase database = mongoClient.getDatabase("MyDB");
        MongoCollection<Document> mongoCollection = database.getCollection("employee");

        List<Employee> empList = new ArrayList<>();
        // find() returns all the records
        mongoCollection.find().forEach((Consumer<? super Document>) document -> {
            Employee e = new Employee(document.get("_id").toString(),document.getString("firstName"),
                    document.getString("lastName"),document.getDouble("salary"));
            empList.add(e);
        });

        return empList;
    }

    public Employee save(Employee employee) {

        try
        {
            MongoDatabase database = mongoClient.getDatabase("MyDB");
            MongoCollection<Document> mongoCollection = database.getCollection("employee");

            Document doc = new Document();
            doc.append("firstName",employee.getFirstName());
            doc.append("lastName",employee.getLastName());
            doc.append("salary",employee.getSalary());

            mongoCollection.insertOne(doc);

            return employee;
        }catch (Exception e)
        {
            throw new RuntimeException("Exception occurred : "+e.getMessage());
        }
    }

    public Employee update(Employee employee) {

        try
        {
            MongoDatabase database = mongoClient.getDatabase("MyDB");
            MongoCollection<Document> mongoCollection = database.getCollection("employee");

            Document doc = new Document();
            doc.append("firstName",employee.getFirstName());
            doc.append("lastName",employee.getLastName());
            doc.append("salary",employee.getSalary());

            /*
                Basically we're telling our collection to update one record
                based on the filter passed. If matched with any record then update that with the new one.
             */
            BasicDBObject filter = new BasicDBObject("_id",new ObjectId(employee.getId()));
            Document oldVal = mongoCollection.findOneAndUpdate(filter, new BasicDBObject("$set", doc));
            if(oldVal != null)
                return employee;
            else throw new RuntimeException("update failed , No matching records");
        }catch (Exception e)
        {
            throw new RuntimeException("Exception occurred : "+e);
        }
    }

    public String delete(String id) {

        String response = null;
        try
        {
            MongoDatabase database = mongoClient.getDatabase("MyDB");
            MongoCollection<Document> mongoCollection = database.getCollection("employee");

            BasicDBObject filter = new BasicDBObject("_id",new ObjectId(id));
            mongoCollection.deleteOne(filter);
            response = "Deletion Successful with id : "+id;
        }catch (Exception e)
        {
            response = e.getMessage();
        }
        return response;
    }
}
