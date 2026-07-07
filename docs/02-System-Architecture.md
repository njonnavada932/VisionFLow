# 02. System Architecture

## Architecture Overview

VisionFlow follows an Event-Driven Microservices Architecture.

Instead of making synchronous service-to-service calls, services communicate through Apache Kafka using events. This allows each service to work independently, improving scalability, reliability, and fault tolerance.

---

## High-Level Architecture

````text

                       Seller
   │
   ▼
Image Upload Service (Java)
   │
   ├── Save Image
   ├── Save Metadata (PENDING)
   ├── Generate Product ID
   ├── Generate Request ID
   └── Publish image-uploaded event
            │
            ▼
      Kafka Topic
            │
            ▼
AI Analysis Service (Python)
   │
   ├── Analyze Image
   ├── Generate Result
   └── Publish image-analysis-completed
            │
            ▼
      Kafka Topic
            │
            ▼
Image Management Service (Java)
   │
   ├── Update Metadata
   ├── Status = APPROVED / REJECTED
   └── Publish notification-event
            │
            ▼
      Kafka Topic
            │
            ▼
Notification Service (Go)
   │
   └── Notify Seller

---

# Microservices

## 1. Image Upload Service (Java)

Responsibilities:

- Accept image upload requests.
- Store image metadata.
- Generate Product ID.
- Generate Request ID.
- Publish the `image-uploaded` event.

---

## 2. AI Analysis Service (Python)

Responsibilities:

- Consume uploaded image events.
- Perform AI-based image validation.
- Generate analysis results.
- Publish the `image-analysis-completed` event.

---

## 3. Image Management Service (Java)

Responsibilities:

- Consume AI analysis results.
- Update validation status.
- Store AI response.
- Publish notification events.

---

## 4. Notification Service (Go)

Responsibilities:

- Consume notification events.
- Notify the seller.
- Log notification status.

---

# Event Flow

1. Seller uploads a product image.
2. Upload Service stores metadata.
3. Upload Service publishes an event.
4. AI Service processes the image.
5. AI Service publishes the analysis result.
6. Image Management Service updates the database.
7. Notification Service informs the seller.

---

# Why Event-Driven Architecture?

The architecture provides:

- Loose coupling between services.
- Better scalability.
- Faster API response.
- Independent deployment.
- Fault tolerance.
- Easy integration of new services.

---

# Logging & Request Tracing

Every service must include:

- Product ID
- Request ID
- Service Name
- Timestamp
- Log Level

Example:

```text
INFO
Service : image-upload-service
Request ID : REQ-12345
Product ID : PROD-10001
Message : Image uploaded successfully
````

This enables request tracing across all services and supports future integration with Grafana, Loki, and distributed tracing tools.

---

# Future Architectural Improvements

- API Gateway
- Authentication Service
- Object Storage (AWS S3 / MinIO)
- Dead Letter Queue (DLQ)
- Retry Mechanism
- Kubernetes Deployment
- Distributed Tracing (OpenTelemetry)
