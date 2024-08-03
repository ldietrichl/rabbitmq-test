package com.example.rabbitmq;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractRabbitMqTest {

    protected abstract void sendMessage(Sender sender) throws IOException, TimeoutException;

    protected abstract void prepareTest() throws IOException, TimeoutException;

    protected abstract String getExpectedValue();

    public void runTest() throws IOException, TimeoutException, InterruptedException, SQLException {
        Sender sender = new Sender();

        prepareTest();

        // Даем время для подготовки
        Thread.sleep(1000);

        sendMessage(sender);

        // Даем время для обработки сообщения
        Thread.sleep(1000);

        // Проверка обновления в базе данных
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM test_table WHERE column_name = '" + getExpectedValue() + "'")) {

            resultSet.next();
            int count = resultSet.getInt(1);
            assertEquals(1, count); // Предполагается, что одна строка будет обновлена до 'expected_value'
        }
    }
}
