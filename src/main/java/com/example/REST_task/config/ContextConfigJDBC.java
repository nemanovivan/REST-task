package com.example.REST_task.config;

import com.example.REST_task.service.ClientServiceJDBC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class ContextConfigJDBC {
    @Bean
    public ClientServiceJDBC clientServiceJDBC(DataSource dataSource) { return new ClientServiceJDBC(dataSource); }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:receipts.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }

}