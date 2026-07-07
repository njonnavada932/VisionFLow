# VisionFlow

> AI-powered event-driven platform for automated product image validation using Java, Kafka, Python, Go, and PostgreSQL.

---

## 📖 Overview

VisionFlow is a microservices-based platform inspired by modern e-commerce marketplaces such as Amazon and Flipkart.

When a seller uploads a product image, the system does not validate it synchronously. Instead, the upload request is accepted immediately, an event is published to Kafka, and the image is processed asynchronously by AI services. Once processing is complete, the seller receives the validation result.

This architecture improves scalability, reduces response time, and enables independent scaling of each service.

---

## 🎯 Problem Statement

Large e-commerce platforms receive thousands of product image uploads every day. Manual image validation is slow, expensive, and inconsistent.

VisionFlow automates this process using AI and an event-driven architecture.

---

## 🚀 Core Features

- Upload product images
- AI-based image validation
- Kafka event-driven communication
- Image status tracking
- Seller notifications
- Microservices architecture

---

## 🏗 Architecture

Seller

↓

Image Upload Service (Java)

↓

Kafka

↓

AI Analysis Service (Python)

↓

Kafka

↓

Image Management Service (Java)

↓

Kafka

↓

Notification Service (Go)

---

## 🛠 Technology Stack

| Technology         | Purpose                    |
| ------------------ | -------------------------- |
| Java (Spring Boot) | REST APIs & Business Logic |
| Apache Kafka       | Event Streaming            |
| Python             | AI Image Processing        |
| Go                 | Notification Service       |
| PostgreSQL         | Metadata Storage           |
| Docker             | Containerization           |

---

## 📂 Repository Structure

```
visionflow/
│
├── docs/
├── services/
├── docker/
├── postman/
├── docker-compose.yml
└── README.md
```

---

## 📅 Roadmap

### Version 1 (MVP)

- Image Upload
- Kafka Integration
- AI Validation
- Notification Service

### Future Enhancements

- Duplicate Image Detection
- OCR
- Watermark Detection
- JWT Authentication
- Dashboard
- Kubernetes Deployment

---

## 📚 Documentation

Project documentation is available inside the `docs` folder.

---

## 📄 License

MIT License
