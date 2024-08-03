package com.example.rabbitmq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        ConfigLoader config = ConfigLoader.getInstance(System.getProperty("profile", "dev"));
        URL = config.getProperty("db.url");
        USER = config.getProperty("db.username");
        PASSWORD = config.getProperty("db.password");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
