package com.pdkj.jackmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JackmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JackmanagerApplication.class, args);
    }
}
