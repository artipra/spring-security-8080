package com.example.springsecurity8080.jdbc;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class DataSourceConfig {

//    @Bean(name="insightDataSource")
    public DataSource dataSource(){
       DataSourceBuilder dataSource = DataSourceBuilder.create();
       dataSource.url("jdbc:mysql://localhost:3306/security");
       dataSource.username("root");
       dataSource.password("root");
       return dataSource.build();

    }
}
