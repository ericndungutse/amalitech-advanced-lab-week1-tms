# Task Management System (TMS)

A robust Task Management System built with Spring Boot, providing RESTful APIs for managing tasks with full CRUD operations. This project is part of AmaliTech's Advanced Lab Week 1 curriculum.

## 📋 Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [API Documentation](#api-documentation)
- [Docker Deployment](#docker-deployment)
- [Usage Examples](#usage-examples)
- [Contributing](#contributing)

## ✨ Features

- **Full CRUD Operations**: Create, Read, Update, and Delete tasks
- **RESTful API Design**: Clean and intuitive API endpoints
- **Swagger Documentation**: Interactive API documentation with OpenAPI 3.0
- **UUID-based Identification**: Secure and unique task identifiers
- **In-Memory Storage**: Fast data access using HashMap-based repository
- **Docker Support**: Containerized deployment with multi-stage builds
- **Comprehensive Logging**: Detailed logging for monitoring and debugging
- **Error Handling**: Proper HTTP status codes and error responses

## 🏗️ Architecture

The application follows a layered architecture pattern:

```
┌─────────────────┐
│   Controller    │  ← REST endpoints
├─────────────────┤
│    Service      │  ← Business logic
├─────────────────┤
│   Repository    │  ← Data access
├─────────────────┤
│     Model       │  ← Data entities
└─────────────────┘
```

![Architecture Diagram](https://github.com/user-attachments/assets/880f1244-b977-485b-9aa3-fde79e9e59a4)

## 🛠️ Technology Stack

- **Backend Framework**: Spring Boot 3.x
- **Language**: Java 21
- **Documentation**: Swagger/OpenAPI 3.0
- **Build Tool**: Maven
- **Containerization**: Docker
- **JRE**: Bellsoft Liberica OpenJDK 24

## 📁 Project Structure

```
src/
├── main/
│   └── java/
│       └── com/ndungutse/tms/
│           ├── controller/
│           │   └── TaskController.java       # REST API endpoints
│           ├── service/
│           │   └── TaskService.java         # Business logic
│           ├── repository/
│           │   └── TasksRepository.java     # Data access layer
│           └── model/
│               └── Task.java                # Task entity
├── Dockerfile                               # Multi-stage Docker build
└── README.md                               # Project documentation
```

## 🚀 Getting Started

### Prerequisites

- Java 21 or higher
- Maven 3.6+
- Docker (optional, for containerized deployment)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/ericndungutse/amalitech-advanced-lab-week1-tms.git
   cd amalitech-advanced-lab-week1-tms
   ```

2. **Build the project**

   ```bash
   mvn clean install
   ```

3. **Run the application**

   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - API Base URL: `http://localhost:8080/api/v1/tasks`
   - Swagger UI: `http://localhost:8080/swagger-ui/index.html`

## 📚 API Documentation

### Task Model

```json
{
  "id": "uuid",
  "title": "string",
  "description": "string",
  "completed": "boolean",
  "createdAt": "datetime"
}
```

### Endpoints

| Method | Endpoint             | Description          |
| ------ | -------------------- | -------------------- |
| GET    | `/api/v1/tasks`      | Retrieve all tasks   |
| GET    | `/api/v1/tasks/{id}` | Get task by ID       |
| POST   | `/api/v1/tasks`      | Create a new task    |
| PUT    | `/api/v1/tasks/{id}` | Update existing task |
| DELETE | `/api/v1/tasks/{id}` | Delete a task        |

### Response Status Codes

- `200 OK` - Successful GET/PUT/DELETE operations
- `201 Created` - Successful POST operation
- `404 Not Found` - Task not found
- `500 Internal Server Error` - Server error

## 🐳 Docker Deployment

The application uses a multi-stage Docker build for optimized container size and performance.

### Build Docker Image

```bash
docker build -t tms-app .
```

### Run Docker Container

```bash
docker run -p 8080:8080 tms-app
```

## 💡 Usage Examples

### Create a Task

```bash
curl -X POST http://localhost:8080/api/v1/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Complete project documentation",
    "description": "Write comprehensive README and API docs",
    "completed": false
  }'
```

### Get All Tasks

```bash
curl -X GET http://localhost:8080/api/v1/tasks
```

### Update a Task

```bash
curl -X PUT http://localhost:8080/api/v1/tasks/{task-id} \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated task title",
    "description": "Updated description",
    "completed": true
  }'
```

### Delete a Task

```bash
curl -X DELETE http://localhost:8080/api/v1/tasks/{task-id}
```

## 🧪 Testing

### Manual Testing

Use the Swagger UI at `http://localhost:8080/swagger-ui/index.html` for interactive testing.

## 👨‍💻 Author

**Eric Ndungutse**

- GitHub: [@ericndungutse](https://github.com/ericndungutse)

**Happy Coding! 🚀**
