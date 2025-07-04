# SMS Platform

## Overview

The SMS Platform is a microservice-based system built with Quarkus that allows sending and processing of SMS messages asynchronously. It consists of two services:

- **sms-service**: Handles REST API calls to send SMS messages, stores them per user, and publishes to a message broker.
- **processor-service**: Consumes SMS messages from the broker, simulates sending, and sends status callbacks.

## Requirements

- Java 17+
- Maven 3.8+
- Docker (for running containers)
- Kafka or RabbitMQ (can be mocked/stubbed)

## Getting Started

### 1. Build the Services

```bash
cd sms-service
mvn clean package -DskipTests

cd ../processor-service
mvn clean package -DskipTests
```

### 2. Run with Docker Compose

```bash
docker-compose up --build
```

### 3. Send an SMS

```bash
curl -X POST http://localhost:8080/sms -H "Content-Type: application/json" -d '{
  "userId": "user123",
  "content": "Hi there!"
}'
```

### 4. Check Stored Messages

```bash
curl http://localhost:8080/sms/user1
```

## Testing

Run tests for each service:

```bash
cd sms-service
mvn test

cd processor-service
mvn test
```

Author: Xenia Andreou

