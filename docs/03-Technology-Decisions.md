# 03. Technology Decisions

## Overview

VisionFlow is designed using technologies that are commonly used in modern product-based companies. Each technology has been selected based on its strengths and responsibility within the system.

---

# Technology Decisions

## Java (Spring Boot)

### Why Java?

Java is widely used for enterprise backend development because of its reliability, scalability, and rich ecosystem.

### Responsibilities

- Build REST APIs
- Handle business logic
- Store image metadata
- Produce and consume Kafka events
- Update image validation status

---

## Python

### Why Python?

Python provides a rich ecosystem for Artificial Intelligence, Machine Learning, and Computer Vision.

### Responsibilities

- Image analysis
- AI model execution
- Object detection
- Image quality validation
- Generate AI confidence score

---

## Go

### Why Go?

Go is lightweight, fast, and efficient for concurrent processing.

### Responsibilities

- Consume notification events
- Notify sellers
- Handle asynchronous background processing
- Generate notification logs

---

## Apache Kafka

### Why Kafka?

Image processing is a time-consuming operation. Instead of making users wait for AI processing, Kafka enables asynchronous communication between services.

### Responsibilities

- Event streaming
- Decouple microservices
- Reliable message delivery
- Independent service scaling

---

## PostgreSQL

### Why PostgreSQL?

PostgreSQL is a reliable relational database suitable for storing structured business data.

### Responsibilities

- Store image metadata
- Store processing status
- Store AI analysis results
- Maintain audit information

---

## Docker

### Why Docker?

Docker provides a consistent environment across development and deployment.

### Responsibilities

- Containerize services
- Simplify local development
- Ensure environment consistency

---

# Design Principles

The system follows these principles:

- Single Responsibility Principle (SRP)
- Event-Driven Architecture
- Loose Coupling
- High Cohesion
- Asynchronous Processing
- Scalability
- Fault Tolerance

---

# Why Microservices?

Instead of building a single large application, VisionFlow separates responsibilities into independent services.

Benefits include:

- Independent deployment
- Easier maintenance
- Better scalability
- Technology flexibility
- Fault isolation

---

# Why Not a Monolithic Application?

A monolithic architecture would tightly couple AI processing, uploads, notifications, and business logic into a single application.

As the system grows, this becomes difficult to scale and maintain.

Using microservices allows each component to evolve independently while communicating through Apache Kafka.

---

# Future Technology Improvements

- Redis for caching
- MinIO / AWS S3 for image storage
- Grafana & Loki for log monitoring
- Prometheus for metrics
- OpenTelemetry for distributed tracing
- Kubernetes for orchestration
- GitHub Actions for CI/CD
