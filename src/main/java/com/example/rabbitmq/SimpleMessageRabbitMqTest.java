package com.example.rabbitmq;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class SimpleMessageRabbitMqTest extends AbstractRabbitMqTest {

    @Override
    protected void sendMessage(Sender sender) throws IOException, TimeoutException {
        String message = "Hello, RabbitMQ!";
        sender.sendMessage(message);
    }

    @Override
    protected void prepareTest() {
        // Не требуется дополнительных подготовительных шагов для простого сообщения
    }

    @Override
    protected String getExpectedValue() {
        return "expected_value";
    }

    @Test
    public void testSendAndDbUpdate() throws IOException, TimeoutException, InterruptedException, SQLException {
        runTest();
    }
}
