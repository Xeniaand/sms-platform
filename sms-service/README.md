# SMS Service

## Overview
The SMS Service is responsible for:
- Exposing REST endpoints to send SMS messages and list them by user
- Validating incoming requests
- Asynchronously dispatching accepted messages to a message queue

## Endpoints

- `POST /sms` — Accepts a message and enqueues it
- `GET /sms/{userId}` — Lists messages for a given user

## Build and Run

### Using Maven:
```bash
cd sms-service
mvn clean package
```

### Using Docker:
```bash
docker build -t sms-service .
docker run -p 8080:8080 sms-service
```

### Using Docker Compose:
```bash
docker-compose up --build
```

## Tests
```bash
mvn test
```

## Configuration
No Kafka or RabbitMQ required for local development.
Messages are mocked using `Emitter<SmsMessage>` in tests.

Author: Xenia Andreou