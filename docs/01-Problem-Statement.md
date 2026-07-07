# 01. Problem Statement

## Overview

Modern e-commerce platforms receive thousands of product image uploads from sellers every day. Before these images are displayed to customers, they must be verified to ensure they meet marketplace quality standards.

Manual image verification is expensive, time-consuming, and difficult to scale. As the number of sellers grows, relying only on human moderators leads to increased operational costs, slower approval times, and inconsistent validation results.

VisionFlow addresses this challenge by automating product image validation using Artificial Intelligence (AI) and an event-driven microservices architecture powered by Apache Kafka.

---

## Business Problem

Marketplaces need to ensure that product images:

- Are clear and of acceptable quality.
- Match the uploaded product.
- Meet platform guidelines.
- Can be processed quickly even during peak traffic.

Without an automated solution, businesses face:

- High manual verification costs.
- Delayed product publishing.
- Poor customer experience.
- Inconsistent validation decisions.
- Difficulty scaling during high upload volumes.

---

## Proposed Solution

VisionFlow provides an event-driven platform that automatically processes uploaded product images.

Instead of waiting for image validation to complete, the upload service publishes an event to Apache Kafka. Independent microservices consume the event, analyze the image using AI models, update the processing status, and notify the seller once validation is complete.

This asynchronous architecture improves scalability, fault tolerance, and system responsiveness.

---

## Objectives

The primary objectives of VisionFlow are:

- Automate product image validation.
- Reduce manual review effort.
- Improve image processing speed.
- Build a scalable event-driven architecture.
- Demonstrate communication between multiple microservices using Kafka.
- Integrate AI into a real-world backend workflow.

---

## Scope

### Included in Version 1 (MVP)

- Product image upload.
- Metadata storage.
- Kafka-based event publishing.
- AI image analysis.
- Image approval or rejection.
- Seller notification.
- Request tracing using Product ID and Request ID.
- Structured logging across all services.

### Future Enhancements

- Duplicate image detection.
- OCR-based text extraction.
- Watermark detection.
- Brand/logo recognition.
- Admin dashboard.
- Retry mechanism using Dead Letter Queue (DLQ).
- Cloud deployment using Kubernetes.
- Monitoring using Prometheus and Grafana.

---

## Expected Outcome

VisionFlow demonstrates how modern product companies design scalable backend systems using event-driven communication and AI-powered processing.

The project showcases how Java, Python, Go, Apache Kafka, Docker, and PostgreSQL can work together to solve a real-world business problem while following microservices architecture and industry-standard engineering practices.