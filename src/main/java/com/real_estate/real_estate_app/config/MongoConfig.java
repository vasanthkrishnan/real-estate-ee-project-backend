package com.real_estate.real_estate_app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

//@Configuration
//@EnableMongoAuditing
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "realestate";
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
