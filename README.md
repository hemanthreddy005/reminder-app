# Reminder App

A simple Spring Boot-based reminder application with REST API endpoints.

## Features

- Create, read, update, and delete reminders
- Mark reminders as completed
- Get pending reminders
- Filter reminders by date range
- In-memory H2 database for easy setup

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+

### Installation

1. Clone the repository:
```bash
git clone https://github.com/hemanthreddy005/reminder-app.git
cd reminder-app
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Create a Reminder
```
POST /api/reminders
Content-Type: application/json

{
  "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "reminderDate": "2026-02-15T10:30:00"
}
```

### Get All Reminders
```
GET /api/reminders
```

### Get Reminder by ID
```
GET /api/reminders/{id}
```

### Update Reminder
```
PUT /api/reminders/{id}
Content-Type: application/json

{
  "title": "Updated title",
  "description": "Updated description",
  "reminderDate": "2026-02-15T10:30:00",
  "status": "PENDING"
}
```

### Delete Reminder
```
DELETE /api/reminders/{id}
```

### Get Pending Reminders
```
GET /api/reminders/status/pending
```

### Mark Reminder as Completed
```
PUT /api/reminders/{id}/complete
```

## Project Structure

```
reminder-app/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   ├── java/com/reminder/
    │   │   ├── ReminderApplication.java
    │   │   ├── controller/
    │   │   │   └── ReminderController.java
    │   │   ├── model/
    │   │   │   └── Reminder.java
    │   │   ├── repository/
    │   │   │   └── ReminderRepository.java
    │   │   └── service/
    │   │       └── ReminderService.java
    │   └── resources/
    │       └── application.properties
```

## Technologies Used

- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database
- Lombok
- Maven

## License

MIT License
