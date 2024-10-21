CREATE DATABASE airline_reservation;

USE airline_reservation;

CREATE TABLE flights (
    flight_number VARCHAR(6) PRIMARY KEY,
    origin VARCHAR(50),
    destination VARCHAR(50),
    departure_time DATETIME,
    arrival_time DATETIME,
    available_seats INT
);

CREATE TABLE users (
    passport_number VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(50)
);

CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_id VARCHAR(6),
    passport_number VARCHAR(10),
    seat_number INT,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_number),
    FOREIGN KEY (passport_number) REFERENCES users(passport_number)
);
