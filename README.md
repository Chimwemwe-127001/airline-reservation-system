# Airline Reservation System

## Overview

The **Airline Reservation System** is a Java-based application that allows users to search for flights, make reservations, and view their reservation details. This system is designed to simulate a real-world airline booking process, providing an interface for managing flights, users, and reservations.

## Features

- **Search Flights:** Users can search for flights based on origin and destination.
- **Make Reservations:** Users can reserve seats on available flights using their passport number.
- **View Reservations:** Users can view their reservation details based on their passport number.
- **Database Integration:** The application connects to a MySQL database to store flight data, user information, and reservation details.
- **Dynamic Seat Management:** The system dynamically checks for available seats and ensures that seat numbers cannot be reused.

## Technologies Used

- **Java**: Main programming language for developing the application.
- **MySQL**: Database management system for storing and retrieving data.
- **JDBC**: Java Database Connectivity for connecting Java applications to the database.

## Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server
- MySQL Connector/J (JDBC driver)

### Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/airline-reservation-system.git

   cd airline-reservation-system
   ```

2. **Set up the MySQL database:**

- Open MySQL Workbench or your preferred MySQL client.
- Run the SQL script located in `resources/database_setup.sql` to create the necessary database and tables.

3. **Configure Database Connection:**

- Update the database connection details in `AirlineReservationSystem.java` if necessary:

```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/airline_reservation";
private static final String DB_USER = "root"; // Your MySQL username
private static final String DB_PASS = "root"; // Your MySQL password
```

4. **Compile the Java files:**

- Navigate to the src directory and compile the Java files:

```bash
javac -cp ../lib/mysql-connector-j-9.1.0.jar *.java
Run the application:
```

5. **Run the main application:**

```bash
java -cp .:../lib/mysql-connector-j-9.1.0.jar AirlineReservationSystem
```

6. **Usage**

- Upon running the application, you will be presented with a menu of options.
- Follow the prompts to search for flights, make reservations, or view existing reservations.
- Ensure you enter valid flight numbers and passport numbers as prompted.
