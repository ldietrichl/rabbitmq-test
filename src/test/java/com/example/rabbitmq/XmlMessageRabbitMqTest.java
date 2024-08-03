package com.example.rabbitmq;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class XmlMessageRabbitMqTest extends AbstractRabbitMqTest {

    @Override
    protected void sendMessage(Sender sender) throws IOException, TimeoutException {
        String xmlFilePath = "path/to/your/message.xml";
        sender.sendMessageFromXml(xmlFilePath);
    }

    @Override
    protected void prepareTest() {
        // Не требуется дополнительных подготовительных шагов для XML сообщения
    }

    @Override
    protected String getExpectedValue() {
        return "expected_value";
    }

    @Test
    public void testSendFromXmlAndDbUpdate() throws IOException, TimeoutException, InterruptedException, SQLException {
        runTest();
    }
}
