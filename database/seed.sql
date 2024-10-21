USE airline_reservation;

-- Insert sample flight data with unique flight numbers
INSERT INTO flights (flight_number, origin, destination, departure_time, arrival_time, available_seats) VALUES
('AB1234', 'New York', 'London', '2024-10-25 08:30:00', '2024-10-25 20:00:00', 10),
('BC5678', 'Paris', 'Dubai', '2024-10-26 10:00:00', '2024-10-26 18:00:00', 15),
('CD9101', 'Tokyo', 'Sydney', '2024-11-01 05:00:00', '2024-11-01 15:30:00', 20),
('DE2345', 'San Francisco', 'Chicago', '2024-10-30 12:45:00', '2024-10-30 17:00:00', 8),
('EF6789', 'London', 'New York', '2024-11-05 22:00:00', '2024-11-06 06:30:00', 25),
('GH5432', 'Berlin', 'Toronto', '2024-11-10 14:00:00', '2024-11-10 18:30:00', 30),
('IJ6789', 'Moscow', 'Los Angeles', '2024-11-12 16:00:00', '2024-11-12 21:00:00', 5),
('KL2345', 'Bangkok', 'Singapore', '2024-11-15 07:00:00', '2024-11-15 09:00:00', 12),
('MN9876', 'Rio de Janeiro', 'Sao Paulo', '2024-11-18 19:00:00', '2024-11-18 20:00:00', 20),
('OP5432', 'Madrid', 'Barcelona', '2024-11-20 11:00:00', '2024-11-20 12:30:00', 18),
('QR6789', 'Cairo', 'Cape Town', '2024-11-25 22:00:00', '2024-11-26 06:00:00', 10),
('ST1234', 'Beijing', 'Shanghai', '2024-11-30 08:00:00', '2024-11-30 10:00:00', 15),
('UV5678', 'Amsterdam', 'Brussels', '2024-12-01 13:00:00', '2024-12-01 14:30:00', 22),
('WX9012', 'Lima', 'Bogota', '2024-12-05 17:00:00', '2024-12-05 19:00:00', 11),
('YZ3456', 'Kuala Lumpur', 'Jakarta', '2024-12-10 09:30:00', '2024-12-10 12:00:00', 17),
('ZA7890', 'Hanoi', 'Bangkok', '2024-12-15 15:30:00', '2024-12-15 17:00:00', 28),
('AB6789', 'Istanbul', 'Athens', '2024-12-20 20:00:00', '2024-12-20 22:00:00', 14),
('BC1234', 'Seoul', 'Tokyo', '2024-12-25 18:00:00', '2024-12-25 19:30:00', 21),
('CD4567', 'New Delhi', 'Mumbai', '2024-12-30 10:15:00', '2024-12-30 11:45:00', 19),
('DE8901', 'Sofia', 'Varna', '2025-01-05 08:30:00', '2025-01-05 09:30:00', 13),
('EF2345', 'Bucharest', 'Cluj-Napoca', '2025-01-10 12:00:00', '2025-01-10 13:00:00', 16),
('GH6789', 'Lisbon', 'Porto', '2025-01-15 15:00:00', '2025-01-15 16:00:00', 12),
('IJ1234', 'Dublin', 'Cork', '2025-01-20 09:30:00', '2025-01-20 10:30:00', 24),
('KL5678', 'Vienna', 'Zurich', '2025-01-25 14:00:00', '2025-01-25 15:30:00', 27),
('MN8901', 'Reykjavik', 'Oslo', '2025-01-30 17:00:00', '2025-01-30 19:00:00', 9),
('OP2345', 'Helsinki', 'Tallinn', '2025-02-05 11:00:00', '2025-02-05 12:00:00', 23),
('QR6789', 'Stockholm', 'Gothenburg', '2025-02-10 16:00:00', '2025-02-10 17:00:00', 15),
('ST1234', 'Bratislava', 'Budapest', '2025-02-15 10:00:00', '2025-02-15 11:00:00', 18);

-- Insert sample user data
INSERT INTO users (passport_number, name, contact) VALUES
('A123456789', 'John Doe', 'john.doe@example.com'),
('B987654321', 'Alice Smith', 'alice.smith@example.com'),
('C192837465', 'Robert Brown', 'robert.brown@example.com'),
('D564738291', 'Emily Davis', 'emily.davis@example.com'),
('E374829105', 'Michael Johnson', 'michael.johnson@example.com');