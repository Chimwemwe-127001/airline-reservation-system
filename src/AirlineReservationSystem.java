import java.sql.*;
import java.util.*;

public class AirlineReservationSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/airline_reservation";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            System.out.println("Connected to the database.");

            while (true) {
                System.out.println("\n1. Search for flights");
                System.out.println("2. Make a reservation");
                System.out.println("3. View reservation details");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> searchFlights(conn);
                    case 2 -> makeReservation(conn);
                    case 3 -> viewReservations(conn);
                    case 4 -> {
                        System.out.println("Exiting...");
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void searchFlights(Connection conn) throws SQLException {
        System.out.print("Enter origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        String query = "SELECT * FROM flights WHERE origin = ? AND destination = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, origin);
            stmt.setString(2, destination);
            ResultSet rs = stmt.executeQuery();

            List<Flight> flights = new ArrayList<>();
            while (rs.next()) {
                Flight flight = new Flight(
                        rs.getString("flight_number"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getInt("available_seats"));
                flights.add(flight);
            }

            if (flights.isEmpty()) {
                System.out.println("No flights found.");
            } else {
                flights.forEach(System.out::println);
            }
        }
    }

    private static void makeReservation(Connection conn) throws SQLException {
        System.out.print("Enter flight number: ");
        String flightId = scanner.nextLine();

        // Retrieve available seats
        List<Integer> availableSeats = getAvailableSeats(conn, flightId);

        if (availableSeats.isEmpty()) {
            System.out.println("No available seats for this flight.");
            return;
        }

        System.out.println("Available seats: " + availableSeats);
        System.out.print("Enter your desired seat number: ");
        int seatNumber = Integer.parseInt(scanner.nextLine());

        // Check if the seat number is valid
        if (!availableSeats.contains(seatNumber)) {
            System.out.println("Seat number " + seatNumber + " is not available. Please choose a different seat.");
            return;
        }

        System.out.print("Enter passenger passport number: ");
        String passportNumber = scanner.nextLine();

        // Update available seats and insert reservation
        String updateSeatsQuery = "UPDATE flights SET available_seats = available_seats - 1 WHERE flight_number = ?";
        String insertReservationQuery = "INSERT INTO reservations (flight_id, passport_number, seat_number) VALUES (?, ?, ?)";

        try (PreparedStatement updateStmt = conn.prepareStatement(updateSeatsQuery);
             PreparedStatement insertStmt = conn.prepareStatement(insertReservationQuery)) {

            updateStmt.setString(1, flightId);
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                insertStmt.setString(1, flightId);
                insertStmt.setString(2, passportNumber); // Use the actual passport number instead
                insertStmt.setInt(3, seatNumber);
                insertStmt.executeUpdate();
                System.out.println("Reservation made successfully for seat number " + seatNumber + ".");
            } else {
                System.out.println("Failed to make reservation. Flight ID may be invalid or no seats available.");
            }
        }
    }

    private static List<Integer> getAvailableSeats(Connection conn, String flightId) throws SQLException {
        List<Integer> availableSeats = new ArrayList<>();

        // Get the total number of seats for the flight
        String flightQuery = "SELECT available_seats FROM flights WHERE flight_number = ?";
        int totalSeats = 0;

        try (PreparedStatement flightStmt = conn.prepareStatement(flightQuery)) {
            flightStmt.setString(1, flightId);
            ResultSet flightRs = flightStmt.executeQuery();

            if (flightRs.next()) {
                totalSeats = flightRs.getInt("available_seats");
            } else {
                System.out.println("Flight number " + flightId + " not found.");
                return availableSeats; // Return empty list if flight not found
            }
        }

        // Check which seats are reserved for this flight
        String reservationQuery = "SELECT seat_number FROM reservations WHERE flight_id = ?";
        boolean[] seatsTaken = new boolean[totalSeats + 1]; // Index 0 will be unused

        try (PreparedStatement reservationStmt = conn.prepareStatement(reservationQuery)) {
            reservationStmt.setString(1, flightId);
            ResultSet reservationRs = reservationStmt.executeQuery();

            while (reservationRs.next()) {
                int seatNumber = reservationRs.getInt("seat_number");
                if (seatNumber > 0 && seatNumber <= totalSeats) {
                    seatsTaken[seatNumber] = true; // Mark seat as taken
                }
            }
        }

        // Add available seats to the list
        for (int i = 1; i <= totalSeats; i++) {
            if (!seatsTaken[i]) {
                availableSeats.add(i);
            }
        }

        return availableSeats;
    }

    private static void viewReservations(Connection conn) throws SQLException {
      System.out.print("Enter passenger passport number: ");
      String passportNumber = scanner.nextLine();
  
      // Modified query to join reservations and users to get passenger name
      String query = "SELECT r.reservation_id, r.flight_id, r.seat_number, u.name " +
                     "FROM reservations r " +
                     "JOIN users u ON r.passport_number = u.passport_number " +
                     "WHERE r.passport_number = ?";
      try (PreparedStatement stmt = conn.prepareStatement(query)) {
          stmt.setString(1, passportNumber);
          ResultSet rs = stmt.executeQuery();
  
          List<Reservation> reservations = new ArrayList<>();
          while (rs.next()) {
              Reservation reservation = new Reservation(
                      rs.getInt("reservation_id"),
                      rs.getString("flight_id"),
                      passportNumber, // still include passport number
                      rs.getInt("seat_number"),
                      rs.getString("name") // Assuming Reservation class can hold name
              );
              reservations.add(reservation);
          }
  
          if (reservations.isEmpty()) {
              System.out.println("No reservations found.");
          } else {
              reservations.forEach(System.out::println);
          }
      }
  }
  
}
