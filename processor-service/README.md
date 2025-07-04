# Processor Service

## Overview
The Processor Service listens for incoming SMS messages from the queue and updates their status.

## Responsibilities:
- Consumes messages from the queue (Kafka/RabbitMQ placeholder)
- Processes and updates status for each message
- Exposes REST endpoint to receive status callbacks

## Endpoints

- `POST /callback` — Receives status update callbacks for messages

## Build and Run

### Using Maven:
```bash
cd processor-service
mvn clean package
```

### Using Docker:
```bash
docker build -t processor-service .
docker run -p 8081:8080 processor-service
```

### Using Docker Compose:
```bash
docker-compose up --build
```

## Tests
```bash
mvn test
```

## Note
Currently the integration with Kafka/RabbitMQ is pending.

Author: Xenia Andreou