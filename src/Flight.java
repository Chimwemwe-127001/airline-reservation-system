public class Flight {
  public String flightNumber, origin, destination;
  public String departureTime, arrivalTime;
  public int availableSeats;

  public Flight(String flightNumber, String origin, String destination,
                String departureTime, String arrivalTime, int availableSeats) {
      this.flightNumber = flightNumber;
      this.origin = origin;
      this.destination = destination;
      this.departureTime = departureTime;
      this.arrivalTime = arrivalTime;
      this.availableSeats = availableSeats;
  }

  @Override
  public String toString() {
      return "Flight Number: " + flightNumber + " | Origin: " + origin +
             " | Destination: " + destination + " | Departure: " + departureTime +
             " | Arrival: " + arrivalTime + " | Available Seats: " + availableSeats;
  }
}
