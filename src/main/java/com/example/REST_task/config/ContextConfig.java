package com.example.REST_task.config;

import com.example.REST_task.service.ClientService;
import com.example.REST_task.service.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ContextConfig {
    @Bean
    public ClientService clientService () { return new ClientServiceImpl(); }

}
