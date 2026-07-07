# 05. Kafka Topics

## Overview

Apache Kafka is the communication backbone of VisionFlow.

Each microservice communicates by publishing and consuming events instead of making direct synchronous API calls. This keeps services loosely coupled and allows them to scale independently.

---

# Kafka Topics

| Topic Name               | Producer                 | Consumer                 | Purpose                    |
| ------------------------ | ------------------------ | ------------------------ | -------------------------- |
| image-uploaded           | Image Upload Service     | AI Analysis Service      | Trigger AI image analysis  |
| image-analysis-completed | AI Analysis Service      | Image Management Service | Send AI validation results |
| notification-events      | Image Management Service | Notification Service     | Notify seller              |

---

# Topic Details

## image-uploaded

### Producer

Image Upload Service

### Consumer

AI Analysis Service

### Description

Published immediately after an image is successfully uploaded and metadata is stored.

---

## image-analysis-completed

### Producer

AI Analysis Service

### Consumer

Image Management Service

### Description

Contains AI analysis results including image quality, detected object, confidence score and validation status.

---

## notification-events

### Producer

Image Management Service

### Consumer

Notification Service

### Description

Used to notify sellers once image validation has completed.

---

# Consumer Groups

| Consumer Group         | Service                  |
| ---------------------- | ------------------------ |
| ai-analysis-group      | AI Analysis Service      |
| image-management-group | Image Management Service |
| notification-group     | Notification Service     |

---

# Message Key

Kafka message key:

```
productId
```

Using Product ID as the message key ensures that all events related to the same product are routed to the same partition, preserving event order.

---

# Topic Naming Convention

VisionFlow follows lowercase, hyphen-separated topic names.

Examples:

- image-uploaded
- image-analysis-completed
- notification-events

---

# Delivery Guarantee

Version 1 targets **At-Least-Once Delivery**.

This means a message may be processed more than once in rare failure scenarios. Consumers should therefore be designed to be idempotent where possible.

---

# Error Handling

If a consumer fails to process an event:

- Log the failure.
- Retry processing.
- Keep the offset uncommitted until successful processing.

Future versions will introduce:

- Dead Letter Queue (DLQ)
- Retry Topics
- Exponential Backoff

---

# Scalability

Kafka enables independent scaling.

Example:

- 1 Upload Service
- 3 AI Analysis Service instances
- 2 Image Management Service instances
- 5 Notification Service instances

Each service can scale without affecting the others.

---

# Monitoring

Kafka metrics that should be monitored:

- Consumer Lag
- Topic Throughput
- Failed Messages
- Processing Time
- Retry Count

These metrics can later be visualized using Prometheus and Grafana.

---

# Future Improvements

- Schema Registry
- Avro Serialization
- Retry Topics
- Dead Letter Queue
- Kafka Streams
- Event Replay
