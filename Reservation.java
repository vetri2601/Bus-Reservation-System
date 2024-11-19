public class Reservation {
    private int reservationId;
    private int busId;
    private Passenger passenger;
    private String seatNumber;

    public Reservation(int reservationId, int busId, Passenger passenger, String seatNumber) {
        this.reservationId = reservationId;
        this.busId = busId;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public String getDetails() {
        return "Reservation ID: " + reservationId + ", Bus ID: " + busId + ", Seat Number: " + seatNumber +
                ", Passenger: [" + passenger.getDetails() + "]";
    }
}
