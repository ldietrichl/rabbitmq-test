
# RabbitMQ Test Project

This project demonstrates how to integrate RabbitMQ with a Java application using Spring Boot. It includes examples of sending messages to a RabbitMQ queue and handling basic configuration settings.

## Prerequisites

- JDK 17
- Gradle
- RabbitMQ server

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/ldietrichl/rabbitmq-test.git
   cd rabbitmq-test
   ```

2. **Configure RabbitMQ:**
   Update the `application.properties` file in `src/main/resources` with your RabbitMQ settings.

3. **Build the project:**
   ```bash
   ./gradlew build
   ```

4. **Run the application:**
   ```bash
   ./gradlew bootRun
   ```

## Project Structure

- `src/main/java/com/example/rabbitmq/`: Main application code.
  - `App.java`: Main entry point.
  - `Sender.java`: Class for sending messages to RabbitMQ.

- `src/test/java/com/example/rabbitmq/`: Test cases.
  - `SenderTest.java`: Tests for sending messages.

- `src/main/resources/`: Configuration files.
  - `application.properties`

## Running Tests

To run tests, execute:
```bash
./gradlew test
```

## License

This project is licensed under the MIT License.
