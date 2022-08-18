package com.krish.springjpamongodb.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("com.krish.springjpamongodb.repository")
public class MongoTemplateConfig {

    @Value("${spring.data.mongodb.host}")
    private  String host;
    @Value("${spring.data.mongodb.port}")
    private  int port;

    @Bean
    public MongoTemplate mongoTemplate()
    {
        String connString = String.format("mongodb://%s:%s",host,port);
        ConnectionString connectionString = new ConnectionString(connString);

        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoTemplate template = new MongoTemplate(mongoClient,"MyDB");
        return template;
    }
}
