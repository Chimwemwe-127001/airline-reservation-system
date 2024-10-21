public class Reservation {
  private int reservationId;
  private String flightId;
  private String passportNumber;
  private int seatNumber;
  private String passengerName; // Added field for passenger name

  // Constructor
  public Reservation(int reservationId, String flightId, String passportNumber, int seatNumber, String passengerName) {
      this.reservationId = reservationId;
      this.flightId = flightId;
      this.passportNumber = passportNumber;
      this.seatNumber = seatNumber;
      this.passengerName = passengerName;
  }

  // toString method for displaying reservation details
  @Override
  public String toString() {
      return "Reservation ID: " + reservationId + " | Flight ID: " + flightId + 
             " | Passenger Name: " + passengerName + " | Passport Number: " + passportNumber + 
             " | Seat Number: " + seatNumber;
  }

  // Getters and Setters (if needed)
}
