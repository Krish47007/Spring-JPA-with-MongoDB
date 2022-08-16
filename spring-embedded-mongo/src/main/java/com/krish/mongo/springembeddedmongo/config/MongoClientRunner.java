package com.krish.mongo.springembeddedmongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MongoClientRunner implements CommandLineRunner {

    //Get the connection
    @Autowired
    private MongoClient mongoClient;
    @Override
    public void run(String... args) throws Exception {
/*


        //MongoClient client = mongoClient();
        //Get Database - If it can't find one then it will create one
        MongoDatabase database = mongoClient.getDatabase("MyDB");
        //Get Collection - If it can't find one then it will create one
        MongoCollection<Document> employeeCollection = database.getCollection("employee");

        Document employee = new Document();
        employee.put("firstName","Krish"); //1st time we can use put/append but next time its append
        employee.append("lastName","Gupta");
        employee.append("salary","5000");

        //Fire the query
        employeeCollection.insertOne(employee);
*/

    }
}
