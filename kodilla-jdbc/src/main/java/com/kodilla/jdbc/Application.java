package com.kodilla.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Application{

    public static void main(String[] args) throws SQLException {
        SpringApplication application = new SpringApplication (Application.class);
        application.run(args);

        DbManager dbManager = DbManager.getInstance();
    }
}
