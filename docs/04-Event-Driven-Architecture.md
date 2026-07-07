# 04. Event-Driven Architecture

## Overview

VisionFlow follows an event-driven architecture where services communicate asynchronously using Apache Kafka.

Instead of calling each service directly, every service publishes events to Kafka topics. Interested services consume those events and continue the workflow independently.

This approach improves scalability, fault tolerance, and loose coupling between services.

---

# Event Flow

```
Seller Uploads Product Image
            │
            ▼
Image Upload Service (Java)
            │
            ▼
Publish Event
Topic : image-uploaded
            │
            ▼
AI Analysis Service (Python)
            │
            ▼
Publish Event
Topic : image-analysis-completed
            │
            ▼
Image Management Service (Java)
            │
            ▼
Publish Event
Topic : notification-events
            │
            ▼
Notification Service (Go)
            │
            ▼
Seller Receives Notification
```

---

# Kafka Topics

| Topic                    | Producer                 | Consumer                 |
| ------------------------ | ------------------------ | ------------------------ |
| image-uploaded           | Image Upload Service     | AI Analysis Service      |
| image-analysis-completed | AI Analysis Service      | Image Management Service |
| notification-events      | Image Management Service | Notification Service     |

---

# Event 1 : image-uploaded

### Producer

Image Upload Service

### Consumer

AI Analysis Service

### Purpose

Notify the AI service that a new product image has been uploaded and is ready for analysis.

### Event Payload

```json
{
  "eventId": "UUID",
  "eventType": "IMAGE_UPLOADED",
  "productId": "PROD-10001",
  "requestId": "REQ-10001",
  "sellerId": "SELLER-501",
  "imageUrl": "/uploads/PROD-10001.jpg",
  "status": "PENDING",
  "uploadedAt": "2026-07-07T10:30:00Z"
}
```

---

# Event 2 : image-analysis-completed

### Producer

AI Analysis Service

### Consumer

Image Management Service

### Purpose

Publish AI analysis results after image processing.

### Event Payload

```json
{
  "eventId": "UUID",
  "eventType": "IMAGE_ANALYSIS_COMPLETED",
  "productId": "PROD-10001",
  "requestId": "REQ-10001",
  "imageQuality": "GOOD",
  "detectedObject": "SHOE",
  "confidence": 0.97,
  "validationStatus": "APPROVED",
  "processedAt": "2026-07-07T10:30:10Z"
}
```

---

# Event 3 : notification-events

### Producer

Image Management Service

### Consumer

Notification Service

### Purpose

Notify the seller about the image validation result.

### Event Payload

```json
{
  "eventId": "UUID",
  "eventType": "NOTIFICATION",
  "productId": "PROD-10001",
  "requestId": "REQ-10001",
  "sellerId": "SELLER-501",
  "validationStatus": "APPROVED",
  "message": "Your product image has been approved.",
  "sentAt": "2026-07-07T10:30:12Z"
}
```

---

# Event Design Principles

Every Kafka event must contain:

- eventId
- eventType
- productId
- requestId
- timestamp

These fields enable:

- Request tracing
- Event auditing
- Log correlation
- Future observability integrations

---

# Why Event-Driven?

Advantages include:

- Loose coupling between services
- Independent deployment
- Faster API response
- Better scalability
- Improved fault tolerance
- Easy integration of additional consumers in the future

---

# Future Enhancements

Future versions may include additional topics:

- image-retry-events
- image-dead-letter
- audit-events
- analytics-events
