package com.example.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

public class Sender {
    private static final String QUEUE_NAME = "hello";
    private static String HOST;
    private static String USERNAME;
    private static String PASSWORD;

    static {
        ConfigLoader config = ConfigLoader.getInstance(System.getProperty("profile", "dev"));
        HOST = config.getProperty("rabbitmq.host");
        USERNAME = config.getProperty("rabbitmq.username");
        PASSWORD = config.getProperty("rabbitmq.password");
    }

    public void sendMessage(String message) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }

    public void sendMessageFromXml(String filePath) throws IOException, TimeoutException {
        String message = new String(Files.readAllBytes(Paths.get(filePath)));
        sendMessage(message);
    }
}
